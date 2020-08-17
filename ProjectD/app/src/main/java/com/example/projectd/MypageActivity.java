package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MypageActivity extends AppCompatActivity {

    Button btn_profile_update, mypage_notice, mypage_qna, mypage_logout;
    ImageButton my_goods, my_rentlist, my_fav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        btn_profile_update = findViewById(R.id.btn_profile_update);
        my_goods = findViewById(R.id.my_goods);
        my_rentlist = findViewById(R.id.my_rentlist);
        my_fav = findViewById(R.id.my_fav);
        mypage_notice = findViewById(R.id.mypage_notice);
        mypage_qna = findViewById(R.id.mypage_qna);
        mypage_logout = findViewById(R.id.mypage_logout);

        btn_profile_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, ProfileUpdateActivity.class);
                startActivity(intent);

            }
        });

        my_goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, LendListActivity.class);
                startActivity(intent);
            }
        });

        my_rentlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, RentListActivity.class);
                startActivity(intent);
            }
        });

        my_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*Intent intent = new Intent(MainActivity.this, FavListActivity.class);
            startActivity(intent);*/
            }
        });

        mypage_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });

        mypage_qna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, QnaActivity.class);
                startActivity(intent);
            }
        });



    }//onCreate()


}//class