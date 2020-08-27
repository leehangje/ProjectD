package com.example.projectd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.projectd.ATask.SignUpInsert;
import com.example.projectd.R;

import java.util.concurrent.ExecutionException;

public class SignUpFormActivity extends AppCompatActivity {
    Button redCheckBtn, locationSearchBtn, joinSubmitBtn;
    EditText idValueText, pwValueText, nameValueText, nicknameValueText, telValueText, locationValueText;
    String state;
    LinearLayout toolbar_context;   // 툴바를 감싸는 레이아웃

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_form);

        redCheckBtn = findViewById(R.id.redCheckBtn);
        locationSearchBtn = findViewById(R.id.locationSearchBtn);
        joinSubmitBtn = findViewById(R.id.joinSubmitBtn);

        idValueText = findViewById(R.id.idValueText);
        nameValueText = findViewById(R.id.nameValueText);
        pwValueText = findViewById(R.id.pwValueText);
        nicknameValueText = findViewById(R.id.nicknameValueText);
        telValueText = findViewById(R.id.telValueText);
        locationValueText = findViewById(R.id.locationValueText);

        toolbar_context = findViewById(R.id.toolbar_context);

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
                String member_id = idValueText.getText().toString();
                String member_pw = pwValueText.getText().toString();
                String member_name = nameValueText.getText().toString();
                String member_nickname = nicknameValueText.getText().toString();
                String member_tel = telValueText.getText().toString();
                String member_addr = locationValueText.getText().toString();
                String member_latitude = locationValueText.getText().toString();
                String member_longitude = locationValueText.getText().toString();

                SignUpInsert signUpInsert = new SignUpInsert(member_id, member_pw, member_nickname,
                                                             member_tel, member_addr, member_latitude, member_longitude,  member_name);
                try {
                    state = signUpInsert.execute().get().trim();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (state.equals("1")) {
                    Toast.makeText(SignUpFormActivity.this, "삽입성공 !!!", Toast.LENGTH_SHORT).show();
                    Log.d("main:joinact", "삽입성공 !!!");
                    finish();
                } else {
                    Toast.makeText(SignUpFormActivity.this, "삽입실패 !!!", Toast.LENGTH_SHORT).show();
                    Log.d("main:joinact", "삽입실패 !!!");
                }
            }
        });

        // 툴바 안에 뒤로가기 버튼 눌렀을 때
        toolbar_context.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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