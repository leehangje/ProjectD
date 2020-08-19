package com.example.projectd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NoticeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NoticeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        ActionBar actionBar = getSupportActionBar();  //제목줄 객체 얻어오기
        actionBar.setTitle("공지사항");  //액션바 제목설정
        actionBar.setDisplayHomeAsUpEnabled(true);   //업버튼 <- 만들기

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NoticeAdapter();

        adapter.addItem(new Notice("박준근", "광주시 길구"));
        adapter.addItem(new Notice("안중근", "광주시 봉구"));
        adapter.addItem(new Notice("안중근", "광주시 봉구"));
        adapter.addItem(new Notice("안중근", "광주시 봉구"));
        adapter.addItem(new Notice("안중근", "광주시 봉구"));
        adapter.addItem(new Notice("안중근", "광주시 봉구"));
        adapter.addItem(new Notice("안중근", "광주시 봉구"));



        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnNoticeItemClickListener() {
            public static final int Notice = 1001;

            @Override
            public void onItemClick(NoticeAdapter.ViewHolder holder, View view, int position) {
                Notice item = adapter.getItem(position);

                Toast.makeText(getApplicationContext(), "아이템 선택됨" + item.getSub(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                startActivityForResult(intent, Notice);

            }
        });

    }
}