package com.example.projectd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectd.R;

public class SignUpFormActivity extends AppCompatActivity {
    Button redCheckBtn, locationSearchBtn, joinSubmitBtn;
    EditText locationValueText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_form);

        // 액션 바 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.actionbar_back);
        actionBar.setTitle("회원가입");
        actionBar.setDisplayHomeAsUpEnabled(true);

        redCheckBtn = findViewById(R.id.redCheckBtn);
        locationSearchBtn = findViewById(R.id.locationSearchBtn);
        joinSubmitBtn = findViewById(R.id.joinSubmitBtn);
        locationValueText = findViewById(R.id.locationValueText);

        // 주소 가져오기
        Intent intent = getIntent();
        String myAddress = intent.getStringExtra("myAddress");
        locationValueText.setText(myAddress);

        // 중복 확인 버튼 클릭했을 때
        redCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpFormActivity.this, "중복 확인 기능 추가", Toast.LENGTH_SHORT).show();
            }
        }); //redCheckBtn.setOnClickListener()

        //위치 찾기 버튼 클릭했을 때
        locationSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpFormActivity.this, LocationActivity.class);
                startActivity(intent);
            }
        }); //locationSearchBtn.setOnClickListener()

        // 회원 가입 버튼 클릭했을 때
        joinSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpFormActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    } //onCreate()

    // 액션 바 뒤로가기 기능을 추가한 메소드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curId = item.getItemId();

        switch (curId) {
            case android.R.id.home :
                // → android.R.id.home : 메뉴바 상단의 아이콘(뒤로가기) 아이디
                this.finish();      // 앱 종료
                break;
        }
        return true;
    } //onOptionsItemSelected()
} //class