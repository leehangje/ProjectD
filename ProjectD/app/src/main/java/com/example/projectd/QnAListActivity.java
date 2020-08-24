package com.example.projectd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QnAListActivity extends AppCompatActivity {

    private RecyclerView recyclerview;

    Button button;
    ImageButton back_btn;

    LinearLayout toolbar_context;   //툴바를 감싸는 레이아웃

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_qna_list);

            toolbar_context = findViewById(R.id.toolbar_context);
            back_btn = findViewById(R.id.btn_back);

            button = findViewById(R.id.button);
            LinearLayout layout01 = (LinearLayout) findViewById(R.id.layout01);

            recyclerview = findViewById(R.id.recyclerview);
            recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            List<QnAListAdapter.Item> data = new ArrayList<>();

            data.add(new QnAListAdapter.Item(QnAListAdapter.HEADER, "궁금한게 있나요?"));
            data.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "저도 몰라요"));
            data.add(new QnAListAdapter.Item(QnAListAdapter.HEADER, "이 앱을 만든 동기가 궁금하신가요?"));
            data.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "안알려줌 ㅎ"));

            QnAListAdapter.Item places = new QnAListAdapter.Item(QnAListAdapter.HEADER, "대여하는 방법이 궁금하신가요?");
            places.invisibleChildren = new ArrayList<>();
            places.invisibleChildren.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "안대여"));

            data.add(places);

        recyclerview.setAdapter(new QnAListAdapter(data));

        // 툴바 안의 뒤로가기 버튼 클릭할 때
        toolbar_context.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}