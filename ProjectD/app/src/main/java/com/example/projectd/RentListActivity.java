package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RentListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_list);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RentAdapter();

        adapter.addItem(new Rent("컴퓨터", "박준근"));
        adapter.addItem(new Rent("모니터", "안중근"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnRentItemCLickListener() {
            public static final int chat = 1001;

            @Override
            public void onItemClick(RentAdapter.ViewHolder holder, View view, int position) {
                Rent item = adapter.getItem(position);

                Toast.makeText(getApplicationContext(), "아이템 선택됨" + item.getName(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MdDetailActivity.class);
                startActivityForResult(intent, chat);

            }
        });

    }
}