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

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CategoryActivity extends Fragment {

    ImageView category_icon1, category_icon2, category_icon3, category_icon4, category_icon5,
            category_icon6, category_icon7, category_icon8, category_icon9, category_icon10;

    ViewGroup viewGroup;

    /*private Context mContext = CategoryActivity.this;*/
    private static final int ACTIVITY_NUM = 3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.activity_category, container, false);


        category_icon1 = viewGroup.findViewById(R.id.category_icon1);
        category_icon2 = viewGroup.findViewById(R.id.category_icon2);
        category_icon3 = viewGroup.findViewById(R.id.category_icon3);
        category_icon4 = viewGroup.findViewById(R.id.category_icon4);
        category_icon5 = viewGroup.findViewById(R.id.category_icon5);
        category_icon6 = viewGroup.findViewById(R.id.category_icon6);
        category_icon7 = viewGroup.findViewById(R.id.category_icon7);
        category_icon8 = viewGroup.findViewById(R.id.category_icon8);
        category_icon9 = viewGroup.findViewById(R.id.category_icon9);
        category_icon10 = viewGroup.findViewById(R.id.category_icon10);

        //디지털,가전 카테고리
        category_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }
        });

        //유,아동 카테고리
        category_icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //생활용품 카테고리
        category_icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //스포츠,레져 카테고리
        category_icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //의류,잡화 카테고리
        category_icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //게임,취미 카테고리
        category_icon6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //뷰티,미용 카테고리
        category_icon7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //반려동물용품 카테고리
        category_icon8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //기타 물품 카테고리
        category_icon9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        //무료나눔 카테고리
        category_icon10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryViewActivity.class);
                startActivity(intent);
            }//onClick()
        });

        return viewGroup;
    }//onCreateView()

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        category_icon1 = findViewById(R.id.category_icon1);
        category_icon2 = findViewById(R.id.category_icon2);
        category_icon3 = findViewById(R.id.category_icon3);
        category_icon4 = findViewById(R.id.category_icon4);
        category_icon5 = findViewById(R.id.category_icon5);
        category_icon6 = findViewById(R.id.category_icon6);
        category_icon7 = findViewById(R.id.category_icon7);
        category_icon8 = findViewById(R.id.category_icon8);
        category_icon9 = findViewById(R.id.category_icon9);
        category_icon10 = findViewById(R.id.category_icon10);

        //디지털,가전 카테고리
        category_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        //유,아동 카테고리
        category_icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        //생활용품 카테고리
        category_icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        //스포츠,레져 카테고리
        category_icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        //의류,잡화 카테고리
        category_icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        //게임,취미 카테고리
        category_icon6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        //뷰티,미용 카테고리
        category_icon7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        //반려동물용품 카테고리
        category_icon8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        //기타 물품 카테고리
        category_icon9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        //무료나눔 카테고리
        category_icon10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryViewActivity.class);
                startActivity(intent);

            }//onClick()
        });//setOnClickListener()

        setupBottomNavigationView();

    }//onCreate()*/

    // 하단 바 메소드
   /* private void setupBottomNavigationView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    } //setupBottomNavigationView()*/

}//class