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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import de.hdodenhof.circleimageview.CircleImageView;
import me.relex.circleindicator.CircleIndicator;

public class MdDetailActivity extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;

    CircleImageView profile_photo;
    TextView user_nickname, member_addr, user_grade, md_name, md_price, md_deposit, md_category,
            md_hits, md_fav_count, md_detail_content;
    Button btn_chat, btn_fav;

    TabFragment1 fragment1;
    TabFragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_detail);

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

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(vpPager);

        // 탭 - 리뷰&판매자의 다른상품
        fragment1 = new TabFragment1();
        fragment2 = new TabFragment2();

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


    }//onCreate

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