package com.example.projectd;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;
import android.view.MenuItem;

import com.example.projectd.ATask.SearchSelect;
import com.example.projectd.Dto.MdDTO;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    EditText editText;
    SearchView searchView;
    LinearLayout linearLayout;
    SearchAdapter adapter;
    RecyclerView recyclerView;
    ViewGroup viewGroup;

    ArrayList<MdDTO> items;

    private static final int ACTIVITY_NUM = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = findViewById(R.id.searchText);
        searchView = findViewById(R.id.icon_search);
        items = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter = new SearchAdapter(getApplicationContext(), items);

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.VISIBLE);
            }
        });

        recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new OnSearchItemClickListener() {
            public static final int search = 1001;

            @Override
            public void onItemClick(SearchAdapter.ViewHolder holder, View view, int position) {
                MdDTO item = adapter.getItem(position);

                //Toast.makeText(getApplicationContext(), "아이템 선택됨" + item.getMd_name(),
                //       Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), MdDetailActivity.class);
                intent.putExtra("item", item);
                startActivityForResult(intent, search);

            }


        });

        SearchSelect searchSelect = new SearchSelect(items, adapter);
        searchSelect.execute();






    }//onCreate

    // 액션 바 뒤로가기 기능을 추가한 메소드
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();

        switch (curId) {
            case android.R.id.home :
                // → android.R.id.home : 메뉴바 상단의 아이콘(뒤로가기) 아이디
                this.finish();      // 앱 종료
                break;
        }
        return true;
    } //onOptionsItemSelected()





}