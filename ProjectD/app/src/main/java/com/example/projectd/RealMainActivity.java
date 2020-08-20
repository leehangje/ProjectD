package com.example.projectd;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RealMainActivity extends AppCompatActivity {

    MainActivity mainActivity;
    CategoryActivity categoryActivity;
    MypageActivity mypageActivity;
    MdInsertActivity mdInsertActivity;
    ChatListActivity chatListActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_real);

        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        mainActivity = new MainActivity();
        categoryActivity = new CategoryActivity();
        mypageActivity = new MypageActivity();
        mdInsertActivity = new MdInsertActivity();
        chatListActivity = new ChatListActivity();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_layout, mainActivity).commitAllowingStateLoss();


        //bottomnavigationview의 아이콘을 선택 했을때 원하는 프래그먼트가 띄워질 수 있도록 리스너를 추가합니다.
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {
                // 하단 바에서 fragment로 연결 시 사용하는 switch 구문
                switch (menuItem.getItemId()) {
                    //menu_bottom.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생시킵니다.
                    case R.id.tab1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_layout, mainActivity).commit();
                        break;

                    case R.id.tab2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_layout, categoryActivity).commit();
                        break;
                    /*
                    case R.id.tab4:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_layout, chatListActivity).commit();
                        break;
                    */
                    case R.id.tab5:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_layout, mypageActivity).commit();
                        break;
                } //switch

                // 하단 바에서 activity로 연결 시 사용하는 메소드
                bottomNavigationView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int itemId = menuItem.getItemId();
                        if (itemId == R.id.tab3) {
                            Intent intent = new Intent(getApplicationContext(), MdInsertActivity.class);
                            startActivity(intent);
                        } else if(itemId == R.id.tab4) {
                            Intent intent = new Intent(getApplicationContext(), ChatListActivity.class);
                            startActivity(intent);
                        }
                    }
                }, 300);
                return true;
            } //onNavigationItemSelected()
        }); //setOnNavigationItemSelectedListener()
    } //onCreate()
} //class
