package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainMdAdapter adapter;

    private Context mContext = MainActivity.this;
    private static final int ACTIVITY_NUM = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 상단 바 없애기
        if (Build.VERSION.SDK_INT >= 21) {
            getSupportActionBar().hide();
        } else if (Build.VERSION.SDK_INT < 21) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MainMdAdapter();

        adapter.addItem(new Main("컴퓨터","3500원"));
        adapter.addItem(new Main("모니터","3000원"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnMainMdItemClickListener() {
            public static final int main = 1001;

            @Override
            public void onItemClick(MainMdAdapter.ViewHolder holder, View view, int position) {
                Main item = adapter.getItem(position);


                Toast.makeText(getApplicationContext(), "아이템 선택됨" + item.getTitle(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MdDetailActivity.class);
                startActivityForResult(intent, main);

            }


        });


        //찜목록
        ImageButton btn_like = findViewById(R.id.btn_like);
        btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FavListActivity.class);
                startActivity(intent);
            }
        });

        //gps
        ImageButton btn_gps = findViewById(R.id.btn_gps);
        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });

        //검색
        ImageButton btn_search = findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });

        //알람
        ImageButton btn_alram = findViewById(R.id.btn_alram);
        btn_alram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AlramActivity.class);
                startActivity(intent);
            }
        });

        setupBottomNavigationView();    //하단 바 메소드 호출
    } //onCreate()

    // 하단 바 메소드
    private void setupBottomNavigationView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    } //setupBottomNavigationView()
}