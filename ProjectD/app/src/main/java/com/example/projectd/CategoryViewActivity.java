package com.example.projectd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
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

    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    ArrayList<MdDTO> items ;

    CategorySelect categorySelect;
    ProgressDialog progressDialog;

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


        categorySelect = new CategorySelect(items, adapter, progressDialog, category);
        try {
            categorySelect.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

