package com.example.projectd;

import android.os.Bundle;
import android.widget.Button;
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

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_qna_list);

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
    }
}