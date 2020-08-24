package com.example.projectd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NoticeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NoticeAdapter adapter;

    LinearLayout toolbar_context;   //툴바를 감싸는 레이아웃

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        recyclerView = findViewById(R.id.recyclerView);
        toolbar_context = findViewById(R.id.toolbar_context);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NoticeAdapter();

        adapter.addItem(new Notice("8월 19일", "최고기온 34도"));
        adapter.addItem(new Notice("8월 20일", "쉬고싶다"));


        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnNoticeItemClickListener() {
            public static final int Notice = 1001;

            @Override
            public void onItemClick(NoticeAdapter.ViewHolder holder, View view, int position) {
                Notice item = adapter.getItem(position);

                Toast.makeText(getApplicationContext(), "아이템 선택됨" + item.getSub(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), NoticeFindActivity.class);
                startActivityForResult(intent, Notice);

            }
        });

        // 툴바 안의 뒤로가기 버튼 클릭할 때
        toolbar_context.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}