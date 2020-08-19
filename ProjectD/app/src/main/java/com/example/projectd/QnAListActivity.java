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

            ActionBar actionBar = getSupportActionBar();  //제목줄 객 제목체 얻어오기
            actionBar.setTitle("QnA");  //액션바 설정
            actionBar.setDisplayHomeAsUpEnabled(true);   //업버튼 <- 만들기

            button = findViewById(R.id.button);
            LinearLayout layout01 = (LinearLayout) findViewById(R.id.layout01);

            recyclerview = findViewById(R.id.recyclerview);
            recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            List<QnAListAdapter.Item> data = new ArrayList<>();

        data.add(new QnAListAdapter.Item(QnAListAdapter.HEADER, "Fruits"));
        data.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "Apple"));
        data.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "Orange"));
        data.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "Banana"));
        data.add(new QnAListAdapter.Item(QnAListAdapter.HEADER, "Cars"));
        data.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "Audi"));
        data.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "Aston Martin"));
        data.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "BMW"));
        data.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "Cadillac"));

        QnAListAdapter.Item places = new QnAListAdapter.Item(QnAListAdapter.HEADER, "Places");
        places.invisibleChildren = new ArrayList<>();
        places.invisibleChildren.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "Kerala"));
        places.invisibleChildren.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "Tamil Nadu"));
        places.invisibleChildren.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "Karnataka"));
        places.invisibleChildren.add(new QnAListAdapter.Item(QnAListAdapter.CHILD, "Maharashtra"));

        data.add(places);

        recyclerview.setAdapter(new QnAListAdapter(data));
    }
}