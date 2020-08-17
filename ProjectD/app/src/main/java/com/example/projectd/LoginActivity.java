package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    EditText idValueText, pwValueText;
    TextView id_pw_search, signUp;
    Button loginSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_pw_search = findViewById(R.id.id_pw_search);
        signUp = findViewById(R.id.signUp);
        loginSubmitBtn = findViewById(R.id.loginSubmitBtn);



    } //onCreate()
} //class