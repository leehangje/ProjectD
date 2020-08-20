package com.example.projectd;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RealMainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    MainActivity mainActivity;
    CategoryActivity categoryActivity;
    MypageActivity mypageActivity;
    MdInsertActivity mdInsertActivity;
    ChatListActivity chatListActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_real);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        mainActivity = new MainActivity();
        categoryActivity = new CategoryActivity();
        mypageActivity = new MypageActivity();
        mdInsertActivity = new MdInsertActivity();
        chatListActivity = new ChatListActivity();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_layout, mainActivity).commitAllowingStateLoss();


        //bottomnavigationview의 아이콘을 선택 했을때 원하는 프래그먼트가 띄워질 수 있도록 리스너를 추가합니다.
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) { switch (menuItem.getItemId()){
                //menu_bottom.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생시킵니다.
                case R.id.tab1:{ getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout,mainActivity).commitAllowingStateLoss();
                    return true;
                }
                case R.id.tab2:{ getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout,categoryActivity).commitAllowingStateLoss();
                    return true;
                }
                /*
                case R.id.tab4:{ getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout,chatListActivity).commitAllowingStateLoss();
                    return true;
                }*/
                case R.id.tab5:{ getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout,mypageActivity).commitAllowingStateLoss();
                    return true;
                } default: return false;
            }
            }
        });
    }
}
