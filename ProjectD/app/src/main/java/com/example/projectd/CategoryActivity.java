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
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CategoryActivity extends Fragment {

   LinearLayout category1, category2, category3, category4, category5,
            category6, category7, category8, category9, category10;

    ViewGroup viewGroup;

    MainActivity mainActivity;

    LinearLayout toolbar_context;   //툴바를 감싸고 있는 레이아웃

    /*private Context mContext = CategoryActivity.this;*/
    private static final int ACTIVITY_NUM = 3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.activity_category, container, false);

        category1 = viewGroup.findViewById(R.id.category1);
        category2 = viewGroup.findViewById(R.id.category2);
        category3 = viewGroup.findViewById(R.id.category3);
        category4 = viewGroup.findViewById(R.id.category4);
        category5 = viewGroup.findViewById(R.id.category5);
        category6 = viewGroup.findViewById(R.id.category6);
        category7 = viewGroup.findViewById(R.id.category7);
        category8 = viewGroup.findViewById(R.id.category8);
        category9 = viewGroup.findViewById(R.id.category9);
        category10 = viewGroup.findViewById(R.id.category10);
        toolbar_context = viewGroup.findViewById(R.id.toolbar_context);
        mainActivity = new MainActivity();

        //디지털,가전 카테고리
        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }
        });

        //유,아동 카테고리
        category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //생활용품 카테고리
        category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //스포츠,레져 카테고리
        category4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //의류,잡화 카테고리
        category5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //게임,취미 카테고리
        category6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //뷰티,미용 카테고리
        category7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //반려동물용품 카테고리
        category8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //기타 물품 카테고리
        category9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //무료나눔 카테고리
        category10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        // 툴바안의 뒤로가기 버튼을 클릭했을 때
        toolbar_context.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.main_layout, mainActivity).commitAllowingStateLoss();
            }
        });

        return viewGroup;
    }//onCreateView()

}//class