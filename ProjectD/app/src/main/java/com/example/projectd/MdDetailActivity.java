package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.projectd.ATask.DetailPhotoSelect;
import com.example.projectd.ATask.DetailSelect;
import com.example.projectd.Dto.MdDTO;
import com.example.projectd.Dto.MemberDto;
import com.google.android.material.tabs.TabLayout;

import java.util.concurrent.ExecutionException;

import de.hdodenhof.circleimageview.CircleImageView;
import me.relex.circleindicator.CircleIndicator;

public class MdDetailActivity extends AppCompatActivity {
    public MdDTO item = null;
    public MemberDto memberDto = null;
    Bundle mBundle = null;

    FragmentPagerAdapter adapterViewPager;

    CircleImageView profile_photo;
    TextView user_nickname, member_addr, user_grade, md_name, md_price, md_deposit, md_category,
            md_Registration_date, md_hits, md_fav_count, md_detail_content;
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

            DetailSelect detailSelect = new DetailSelect(item.getMember_id());


            try {
                memberDto = detailSelect.execute().get();
                //item = detailPhotoSelect.execute().get();
                //Log.d("main:Detail", "onCreate: " + memberDto.getMember_nickname());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        profile_photo = findViewById(R.id.profile_photo);
        user_nickname = findViewById(R.id.user_nickname);
        member_addr = findViewById(R.id.member_addr);
        user_grade = findViewById(R.id.user_grade);
        md_name = findViewById(R.id.md_name);
        md_price = findViewById(R.id.md_price);
        md_deposit = findViewById(R.id.md_dedosit);
        md_category = findViewById(R.id.md_category);
        md_Registration_date = findViewById(R.id.md_Registration_date);
        md_hits = findViewById(R.id.md_hits);
        md_fav_count = findViewById(R.id.md_fav_count);
        md_detail_content = findViewById(R.id.md_detail_content);

        btn_chat = findViewById(R.id.btn_chat);
        btn_fav = findViewById(R.id.btn_fav);

        toolbar_context = findViewById(R.id.toolbar_context);

        setItem(item, memberDto);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());


        vpPager.setAdapter(adapterViewPager);

        //프로필사진 동글이
        /*CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(vpPager);*/

        // 탭 프래그먼트
        fragment1 = new TabFragment1();
        fragment2 = new TabFragment2();

        //탭 프래그먼트중 기본으로 표시될 프래그먼트
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("리뷰"));
        tabs.addTab(tabs.newTab().setText( memberDto.getMember_nickname() + "님의 다른 상품"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭: " + position);

                Fragment selected = null;
                if (position == 0){
                    selected = fragment1;
                }else if (position == 1){
                    // 전달할 데이터 Bundle
                    mBundle = new Bundle();
                    mBundle.putString("member_id", item.getMember_id());  // 키값, 데이터
                    mBundle.putString("md_serial_number", item.getMd_serial_number());  // 키값, 데이터
                    selected = fragment2;
                }

                //fragment2.setArguments(args);

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        }); //tabs.addOnTabSelectedListener()


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

    }//onCreate()


    public void setItem(MdDTO item, MemberDto memberDto){
        user_nickname.setText(memberDto.getMember_nickname());
        member_addr.setText(memberDto.getMember_addr());
        user_grade.setText(memberDto.getMember_grade());
        Glide.with(this).load(memberDto.getMember_profile()).into(profile_photo);

        // 사진url 가져오는 대표적인 방법: 글라이드 (쓰려면 그래들 추가해야됨)
       /* String imageUrl = mdDTO.getMd_photo_url();
        Glide.with(this).load(imageUrl)
                .placeholder(R.drawable.choonbae1)
                .error(R.drawable.heart)
                .into(detail_photo1);*/

        md_name.setText(item.getMd_name());
        md_price.setText("대여료: " + item.getMd_price() + "원");  //int형 가져올땐 ""를 추가해야됨
        md_deposit.setText("보증금: " + item.getMd_deposit() + "원");
        md_category.setText("카테고리 - " + item.getMd_category());
        md_Registration_date.setText(item.getMd_registration_date());
        md_hits.setText("조회수:" + item.getMd_hits());
        md_fav_count.setText("찜:" + item.getMd_fav_count());
        md_detail_content.setText("<상세정보>\n" + item.getMd_detail_content());
    }


    //상품 상세사진 슬라이드 넘기기
    public class MyPagerAdapter extends FragmentPagerAdapter {
        //private int NUM_ITEMS = 3;
        private int NUM_ITEMS = 1;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }


        @Override
        public int getCount() {
            return NUM_ITEMS;
        }


        @Override
        public Fragment getItem(int position) {

            // 전달할 데이터 Bundle
            Bundle bundle = new Bundle();
            bundle.putString("md_serial_number", item.getMd_serial_number());  // 키값, 데이터
            return new DetailPhotoFragment1(0, bundle);


            /*switch (position) {
                case 0:
                    // 전달할 데이터 Bundle
                    Bundle bundle = new Bundle();
                    bundle.putString("md_serial_number", item.getMd_serial_number());  // 키값, 데이터
                    return new DetailPhotoFragment1(0, bundle);
                case 1:
                    return DetailPhotoFragment2.newInstance(1);
                case 2:
                    return DetailPhotoFragment3.newInstance(2);
                default:
                    return null;
            }*/
        }//getItem()

    }//MyPagerAdapter()

    public void fragChanged(Bundle bundle){

    }

}