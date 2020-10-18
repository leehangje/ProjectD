package com.example.projectd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectd.ATask.CategorySelect;
import com.example.projectd.Dto.MdDTO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class CategoryViewActivity extends AppCompatActivity {

    public static MdDTO selItem = null;

    RecyclerView recyclerView;
    CategoryAdapter adapter;
    ArrayList<MdDTO> items;

    CategorySelect categorySelect;
    ProgressDialog progressDialog;
    TextView category_name;

    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_view);

        items = new ArrayList<>();
        adapter = new CategoryAdapter(this, items);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        Intent intent = getIntent();
        if (intent != null) {
            category = intent.getStringExtra("category");
        }

        category_name = findViewById(R.id.category_name);

        category_name.setText(category);

        categorySelect = new CategorySelect(items, adapter, progressDialog, category);
        try {
            categorySelect.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        adapter.setOnItemClickListener(new OnCategoryItemClickListener() {
            public static final int category = 1001;

            @Override
            public void onItemClick(CategoryAdapter.ViewHolder holder, View view, int position) {
                MdDTO item = adapter.getItem(position);

                Intent intent = new Intent(getApplicationContext(), MdDetailActivity.class);
                intent.putExtra("item", item);
                startActivityForResult(intent, category);

            }
        });
    }

}

