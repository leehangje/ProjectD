package com.example.projectd;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.projectd.ATask.LoginSelect;
import com.example.projectd.Dto.MemberDto;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {
    public static MemberDto loginDTO = null;

    EditText etId, etPw;
    TextView id_pw_search, signUp;
    Button loginSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        checkDangerousPermissions();    //위험 권한 주기

        id_pw_search = findViewById(R.id.id_pw_search);
        signUp = findViewById(R.id.signUp);
        loginSubmitBtn = findViewById(R.id.loginSubmitBtn);
        etId = findViewById(R.id.etId);
        etPw = findViewById(R.id.etPw);


        // 아이디/비밀번호 찾기 화면 띄우기
        id_pw_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SearchIDActivity.class);
                startActivity(intent);
            }
        }); //id_pw_search.setOnClickListener()

        // 회원가입 화면 띄우기
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpFormActivity.class);
                startActivity(intent);
            }
        }); //signUp.setOnClickListener()

        // 로그인 버튼 클릭 시 실행되는 메소드
        loginSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginDTO = null;

                if(etId.getText().toString().length() != 0 && etPw.getText().toString().length() != 0) {
                    String member_id = etId.getText().toString();
                    String member_pw = etPw.getText().toString();

                    LoginSelect loginSelect = new LoginSelect(member_id, member_pw);
                    try {
                        loginSelect.execute().get();
                    } catch (ExecutionException e) {
                        e.getMessage();
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "아이디와 암호를 모두 입력하세요.", Toast.LENGTH_SHORT).show();
                    Log.d("main:login", "아이디와 암호를 모두 입력하세요.");
                    return;
                }

                if(loginDTO != null){
                    Toast.makeText(LoginActivity.this, loginDTO.getMember_id() + "님 로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                    Log.d("main:login", loginDTO.getMember_id() + "님 로그인 되었습니다.");

                    // 로그인 정보에 값이 있으면 로그인이 되었으므로 메인화면으로 이동
                    Intent intent = new Intent(LoginActivity.this, RealMainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginActivity.this, "아이디나 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    Log.d("main:login", "아이디나 비밀번호가 일치하지 않습니다.");
                    etId.setText("");
                    etPw.setText("");
                    etId.requestFocus();
                }

            }
        }); //loginSubmitBtn.setOnClickListener()

    } //onCreate()

    //----------------------------------------------------------------
    // 위험 권한
    private void checkDangerousPermissions () {
        String[] permissions = {
                android.Manifest.permission.INTERNET,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult ( int requestCode, String[] permissions,
                                             int[] grantResults){
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, permissions[i] + " 권한이 승인됨.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, permissions[i] + " 권한이 승인되지 않음.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

} //class