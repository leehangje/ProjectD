package com.example.projectd;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends Fragment {

    RecyclerView recyclerView;
    MainMdAdapter adapter;
    ViewGroup viewGroup;
    ImageButton btn_like;

    /*private Context mContext = MainActivity.this;*/
    private static final int ACTIVITY_NUM = 3;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.activity_main, container, false);

        // 상단 바 없애기
        /*if (Build.VERSION.SDK_INT >= 21) {
            getSupportActionBar().hide();
        } else if (Build.VERSION.SDK_INT < 21) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }*/
        recyclerView = viewGroup.findViewById(R.id.recyclerView);

        //찜목록
        btn_like = viewGroup.findViewById(R.id.btn_like);
        btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FavListActivity.class);
                startActivity(intent);
            }
        });

        //gps
        ImageButton btn_gps = viewGroup.findViewById(R.id.btn_gps);
        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LocationActivity.class);
                startActivity(intent);
            }
        });

        //검색
        ImageButton btn_search = viewGroup.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        //알람
        ImageButton btn_alram = viewGroup.findViewById(R.id.btn_alram);
        btn_alram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AlramActivity.class);
                startActivity(intent);
            }
        });



        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MainMdAdapter();

        adapter.addItem(new Main("컴퓨터", "3500원"));
        adapter.addItem(new Main("모니터", "3000원"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnMainMdItemClickListener() {
            public static final int main = 1001;

            @Override
            public void onItemClick(MainMdAdapter.ViewHolder holder, View view, int position) {
                Main item = adapter.getItem(position);


                Toast.makeText(getActivity(), "아이템 선택됨" + item.getTitle(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), MdDetailActivity.class);
                startActivityForResult(intent, main);

            }


        });



        /*setupBottomNavigationView();*/    //하단 바 메소드 호출
        //onCreate()

        // 하단 바 메소드
    /*private void setupBottomNavigationView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);*/
        //setupBottomNavigationView()
        return viewGroup;
    }
}