package com.example.projectd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // 액션 바 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.actionbar_back);
        actionBar.setTitle("검색");
        actionBar.setDisplayHomeAsUpEnabled(true);




    }
}