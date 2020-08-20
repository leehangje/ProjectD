package com.example.projectd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MypageActivity extends Fragment {

    Button btn_profile_update, mypage_notice, mypage_qna, mypage_logout;
    ImageButton my_goods, my_rentlist, my_fav;

    ViewGroup viewGroup;

    /*private Context mContext = MypageActivity.this;*/
    private static final int ACTIVITY_NUM = 3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.activity_mypage, container, false);

        btn_profile_update = viewGroup.findViewById(R.id.btn_profile_update);
        my_goods = viewGroup.findViewById(R.id.my_goods);
        my_rentlist = viewGroup.findViewById(R.id.my_rentlist);
        my_fav = viewGroup.findViewById(R.id.my_fav);
        mypage_notice = viewGroup.findViewById(R.id.mypage_notice);
        mypage_qna = viewGroup.findViewById(R.id.mypage_qna);
        mypage_logout = viewGroup.findViewById(R.id.mypage_logout);

        //프로필 수정
        btn_profile_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                startActivity(intent);

            }
        });

        //내 상품목록
        my_goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LendListActivity.class);
                startActivity(intent);
            }
        });

        //빌린내역목록
        my_rentlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RentListActivity.class);
                startActivity(intent);
            }
        });

        //찜목록
        my_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(getActivity(), FavListActivity.class);
                startActivity(intent);
            }
        });

        //공지사항
        mypage_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NoticeActivity.class);
                startActivity(intent);
            }
        });

        //자주묻는질문
        mypage_qna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QnAListActivity.class);
                startActivity(intent);
            }
        });

        //로그아웃
        mypage_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return viewGroup;

    }//onCreateView()


    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        btn_profile_update = findViewById(R.id.btn_profile_update);
        my_goods = findViewById(R.id.my_goods);
        my_rentlist = findViewById(R.id.my_rentlist);
        my_fav = findViewById(R.id.my_fav);
        mypage_notice = findViewById(R.id.mypage_notice);
        mypage_qna = findViewById(R.id.mypage_qna);
        mypage_logout = findViewById(R.id.mypage_logout);

        //프로필 수정
        btn_profile_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, ProfilActivity.class);
                startActivity(intent);

            }
        });

        //내 상품목록
        my_goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, LendListActivity.class);
                startActivity(intent);
            }
        });

        //빌린내역목록
        my_rentlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, RentListActivity.class);
                startActivity(intent);
            }
        });

        //찜목록
        my_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            *//*Intent intent = new Intent(MainActivity.this, FavListActivity.class);
            startActivity(intent);*//*
            }
        });

        //공지사항
        mypage_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });

        //자주묻는질문
        mypage_qna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, QnAListActivity.class);
                startActivity(intent);
            }
        });

        //로그아웃
        mypage_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        setupBottomNavigationView();

    }//onCreate()

    // 하단 바 메소드
    private void setupBottomNavigationView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    } //setupBottomNavigationView()*/

}//class