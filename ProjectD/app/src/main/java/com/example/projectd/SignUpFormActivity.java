package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        redCheckBtn = findViewById(R.id.redCheckBtn);
        locationSearchBtn = findViewById(R.id.locationSearchBtn);
        joinSubmitBtn = findViewById(R.id.joinSubmitBtn);
        locationValueText = findViewById(R.id.locationValueText);

        redCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpFormActivity.this, "중복 확인 기능 추가", Toast.LENGTH_SHORT).show();
            }
        }); //redCheckBtn.setOnClickListener()

        locationSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpFormActivity.this, LocationActivity.class);
                startActivity(intent);
            }
        }); //locationSearchBtn.setOnClickListener()

        joinSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpFormActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        /*
        Intent intent = getIntent();
        String address = String.valueOf(intent.getExtras().getStringArray("address"));
        locationValueText.setText(address);
        */
    } //onCreate()
} //class