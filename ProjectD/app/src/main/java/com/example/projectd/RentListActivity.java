package com.example.projectd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RentListActivity extends AppCompatActivity {
    public static final int chat = 1001;

    RecyclerView recyclerView;
    RentAdapter adapter;
    LinearLayout toolbar_context;   //툴바를 감싸는 레이아웃
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_list);

        recyclerView = findViewById(R.id.recyclerView);
        toolbar_context = findViewById(R.id.toolbar_context);
        button = findViewById(R.id.btn_review);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RentAdapter();

        adapter.setmContext(RentListActivity.this);

        adapter.addItem(new Rent("컴퓨터", "박준근"));
        adapter.addItem(new Rent("모니터", "안중근"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnRentItemCLickListener() {
            @Override
            public void onItemClick(RentAdapter.ViewHolder holder, View view, int position) {
                Rent item = adapter.getItem(position);

                Toast.makeText(getApplicationContext(), "아이템 선택됨" + item.getName(),
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), MdDetailActivity.class);
                startActivityForResult(intent, chat);
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

    // 액티비티 전환 메소드 (리뷰 액티비티 띄우기)
    public void runReviewActivity() {
        Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
        startActivityForResult(intent, chat);
    }

}