package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectd.Dto.MdDTO;
import com.google.android.material.tabs.TabLayout;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import me.relex.circleindicator.CircleIndicator;

public class MdDetailActivity extends AppCompatActivity {
    public MdDTO item = null;

    /*연결할 주소*/
    //String str = "[{\"md_name\":\"미란이\",\"md_category\":\"생활용품\",\"md_price\":10000,\"md_rental_term\":\"1일\",\"md_deposit\":100000,\"md_detail_content\":\"요리를 참 잘해요\",\"md_photo_url\":\"https://ifh.cc/g/TqfuhP.jpg\",\"member_id\":\"conan\",\"member_addr\":\"광주 서구 경열로\",\"md_fav_count\":2,\"md_registration_date\":\"2020.08.27\",\"md_serial_number\":\"1\",\"md_rent_status\":1,\"md_hits\":99999}]";
    //실패//private String str = "http://localhost:80/app/anDetail?md_serial_number=1";
    //실패//private String str = "http://localhost:80/app/anDetail?md_serial_number=" + detailDTO.getMd_serial_number();
    //실패//private String str = "['http://localhost:80/app/anDetail?md_serial_number=1']";
    //실패//private String str = "[" + "http://localhost:80/app/anDetail?md_serial_number=1" + "]";
    //private String str = ipConfig + "/app/anDetail?md_serial_number=1";

    private ArrayList<String> md_nameList;
    private ArrayList<String>md_categoryList;
    private JSONArray jsonArray;

    FragmentPagerAdapter adapterViewPager;

    CircleImageView profile_photo;
    TextView user_nickname, member_addr, user_grade, md_name, md_price, md_deposit, md_category,
            md_hits, md_fav_count, md_detail_content;
    Button btn_chat, btn_fav;

    TabFragment1 fragment1;
    TabFragment2 fragment2;

    LinearLayout toolbar_context;   //툴바를 감싸는 레이아웃

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_detail);

        Intent intent = getIntent();

        if (intent != null){
            item = (MdDTO) intent.getSerializableExtra("item");
        }

        profile_photo = findViewById(R.id.profile_photo);
        user_nickname = findViewById(R.id.user_nickname);
        member_addr = findViewById(R.id.member_addr);
        user_grade = findViewById(R.id.user_grade);
        md_name = findViewById(R.id.md_name);
        md_price = findViewById(R.id.md_price);
        md_deposit = findViewById(R.id.md_dedosit);
        md_category = findViewById(R.id.md_category);
        md_hits = findViewById(R.id.md_hits);
        md_fav_count = findViewById(R.id.md_fav_count);
        md_detail_content = findViewById(R.id.md_detail_content);

        btn_chat = findViewById(R.id.btn_chat);
        btn_fav = findViewById(R.id.btn_fav);

        setItem(item);

        toolbar_context = findViewById(R.id.toolbar_context);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(vpPager);

        // 탭 프래그먼트
        fragment1 = new TabFragment1();
        fragment2 = new TabFragment2();

        //기본으로 표시될 프래그먼트
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("리뷰"));
        tabs.addTab(tabs.newTab().setText("닉네임님의 다른 상품"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭: " + position);

                Fragment selected = null;
                if (position == 0){
                    selected = fragment1;
                }else if (position == 1){
                    selected = fragment2;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });


        //채팅하기
        btn_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MdDetailActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        //찜하기
        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MdDetailActivity.this, "해당 상품을 찜 목록에 넣었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        // 툴바 안의 뒤로가기 버튼 클릭할 때
        toolbar_context.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        //db에서 데이터 가져오기(json)
        md_nameList = new ArrayList<>();
        md_categoryList = new ArrayList<>();

        //jsonRead();

    }//onCreate

    public void setItem(MdDTO item){
        md_name.setText(item.getMd_name());
        md_price.setText("" + item.getMd_price());  //int형 가져올땐 "" 추가
    }

    //db에서 데이터 가져오기(json)
    /*private void jsonRead() {
        try {
            jsonArray = new JSONArray(str);
            for(int i = 0 ; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String md_name = jsonObject.getString("md_name");
                String md_category = jsonObject.getString("md_category");

                md_nameList.add(md_name);
                md_categoryList.add(md_category);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        md_name.setText(md_nameList.toString());
        md_category.setText(md_categoryList.toString());


    }
*/
    //상품 상세사진 슬라이드 넘기기
    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return DetailPhotoFragment1.newInstance(0, "Page # 1");
                case 1:
                    return DetailPhotoFragment2.newInstance(1, "Page # 2");
                case 2:
                    return DetailPhotoFragment3.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }//getItem()

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }//getPageTitle()

    }//MyPagerAdapter()

}