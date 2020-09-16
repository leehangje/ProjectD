package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ReviewActivity extends AppCompatActivity {
    LinearLayout toolbar_context;   //툴바를 감싸고 있는 레이아웃

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        toolbar_context = findViewById(R.id.toolbar_context);

        // 툴바 뒤로가기 클릭시 Activity 화면 끝내기
        toolbar_context.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    } //onCreate()
} //class