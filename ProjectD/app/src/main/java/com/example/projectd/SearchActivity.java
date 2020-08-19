package com.example.projectd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;
import android.view.MenuItem;

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


    }//onCreate

    // 액션 바 뒤로가기 기능을 추가한 메소드
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();

        switch (curId) {
            case android.R.id.home :
                // → android.R.id.home : 메뉴바 상단의 아이콘(뒤로가기) 아이디
                this.finish();      // 앱 종료
                break;
        }
        return true;
    } //onOptionsItemSelected()
}