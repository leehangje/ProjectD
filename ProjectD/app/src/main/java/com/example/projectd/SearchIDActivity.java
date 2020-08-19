package com.example.projectd;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.example.projectd.R;
import com.google.android.material.tabs.TabLayout;

public class SearchIDActivity extends AppCompatActivity {
    Toolbar toolbar;

    IdFragment fragment1;
    PwFragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 액션 바 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.actionbar_back);
        actionBar.setTitle("아이디/비밀번호 찾기");
        actionBar.setDisplayHomeAsUpEnabled(true);



        setContentView(R.layout.activity_search_i_d);

        //뒤로가기
        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchIDActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }); //btn_back.setOnClickListener()



       /* toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("아이디/비밀번호 찾기");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*/
        fragment1 = new IdFragment();
        fragment2 = new PwFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment1).commit();



        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("아이디찾기"));
        tabs.addTab(tabs.newTab().setText("비밀번호 찾기"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭 : " + position);

                Fragment selected = null;
                if (position == 0){
                    selected = fragment1;
                }else if (position == 1){
                    selected = fragment2;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }




            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }




        });

    }

}