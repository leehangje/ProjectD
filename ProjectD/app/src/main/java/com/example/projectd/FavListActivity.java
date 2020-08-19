package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FavListActivity extends AppCompatActivity {

    ListView listView;

    FavListSubActivity adapter;
    ArrayList<FavListDTO> dtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_list);

        Point size = getDiviceSize();

        dtos = new ArrayList<>();

        listView = findViewById(R.id.listView);

        adapter = new FavListSubActivity(FavListActivity.this,dtos,size);
        adapter.addDto(new FavListDTO("물품명","닉네임"));
        adapter.addDto(new FavListDTO("자전거","산악인"));

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                FavListDTO dto = (FavListDTO) adapter.getItem(position);
                Toast.makeText(FavListActivity.this, "선택"+position+"\n물품명"+dto.getMd_name()+"\n닉네임"+dto.getMember_nickname()
                        , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(FavListActivity.this , MdDetailActivity.class);
                startActivity(intent);

            }
        });
    }

    private Point getDiviceSize() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealSize(size);
        }
        int width = size.x;
        int height = size.y;

        return  size;
    }
}