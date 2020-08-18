package com.example.projectd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

public class CategoryViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_view);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CategoryAdapter();

        adapter.addItem(new Category("모니터", "1000원"));
        adapter.addItem(new Category("자전거", "1000원"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnCategoryItemClickListener() {
            public static final int category1 = 1001;

            @Override
            public void onItemClick(CategoryAdapter.ViewHolder holder, View view, int position) {
                Category item = adapter.getItem(position);

                Toast.makeText(getApplicationContext(), "선택됨" + item.getTitle(),
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), MdDetailActivity.class);
                startActivityForResult(intent, category1);

            }
        });

    }
}