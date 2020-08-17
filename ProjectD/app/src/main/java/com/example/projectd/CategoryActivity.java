package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CategoryActivity extends AppCompatActivity {
    ImageView category_icon1, category_icon2, category_icon3, category_icon4, category_icon5,
            category_icon6, category_icon7, category_icon8, category_icon9, category_icon10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        category_icon1 = findViewById(R.id.category_icon1);
        category_icon2 = findViewById(R.id.category_icon2);
        category_icon3 = findViewById(R.id.category_icon3);
        category_icon4 = findViewById(R.id.category_icon4);
        category_icon5 = findViewById(R.id.category_icon5);
        category_icon6 = findViewById(R.id.category_icon6);
        category_icon7 = findViewById(R.id.category_icon7);
        category_icon8 = findViewById(R.id.category_icon8);
        category_icon9 = findViewById(R.id.category_icon9);
        category_icon10 = findViewById(R.id.category_icon10);

        category_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        category_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        category_icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        category_icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        category_icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        category_icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        category_icon6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        category_icon7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        category_icon8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        category_icon9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        category_icon10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

    }//onCreate()

}//class