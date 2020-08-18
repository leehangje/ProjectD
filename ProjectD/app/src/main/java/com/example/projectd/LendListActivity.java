package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LendListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LendAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend_list);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new LendAdapter();

        adapter.addItem(new Lend("컴퓨터", "박준근"));
        adapter.addItem(new Lend("모니터", "안중근"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnLendItemCLickListener() {
            public static final int chat = 1001;

            @Override
            public void onItemClick(LendAdapter.ViewHolder holder, View view, int position) {
                Lend item = adapter.getItem(position);

                Toast.makeText(getApplicationContext(), "아이템 선택됨" + item.getName(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MdDetailActivity.class);
                startActivityForResult(intent, chat);

            }
        });

    }
}