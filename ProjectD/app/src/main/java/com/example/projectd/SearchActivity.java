package com.example.projectd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;
import android.view.MenuItem;

import java.util.zip.Inflater;

public class SearchActivity extends AppCompatActivity {
    EditText editText;
    SearchView searchView;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = findViewById(R.id.searchText);
        searchView = findViewById(R.id.icon_search);
        linearLayout = findViewById(R.id.linearlayout);

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.VISIBLE);
            }
        });






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