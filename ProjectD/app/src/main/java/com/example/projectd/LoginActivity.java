package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView id_pw_search, signUp;
    Button loginSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id_pw_search = findViewById(R.id.loginSubmitBtn);
        signUp = findViewById(R.id.signUp);
        loginSubmitBtn = findViewById(R.id.loginSubmitBtn);


    } //onCreate()
} //class