package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.projectd.ATask.AnFavSelectList;
import com.example.projectd.ATask.FavSelect;
import com.example.projectd.Dto.FavDto;
import com.example.projectd.Dto.MdDTO;

import java.util.ArrayList;

import static com.example.projectd.LoginActivity.loginDTO;

public class FavListActivity extends AppCompatActivity {

    RecyclerView favRecyclerView;
    FavMdAdapter adapter;
    ImageView favlist_null;

    ArrayList<MdDTO> items;

    LinearLayout toolbar_context;   //툴바를 감싸는 레이아웃

    private static final int ACTIVITY_NUM = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_list);

        items = new ArrayList<>();

        toolbar_context = findViewById(R.id.toolbar_context);

        favlist_null = findViewById(R.id.favlist_null); //리스트가 없다면 대신 보여줄 이미지

        favRecyclerView = findViewById(R.id.favRecyclerView);
        favRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter = new FavMdAdapter(getApplicationContext(), items);

       /* if (items.isEmpty()){
            favlist_null.setVisibility(View.VISIBLE);
        }else{
            favlist_null.setVisibility(View.INVISIBLE);
        }*/

        favRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnFavItemClickListener() {
            public static final int fav = 1001;

            @Override
            public void onItemClick(FavMdAdapter.ViewHolder holder, View view, int position) {
                MdDTO item = adapter.getItem(position);
                //Toast.makeText(getApplicationContext(), "아이템 선택됨" + item.getMd_name(),
                //        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), MdDetailActivity.class);
                intent.putExtra("item", item);
                startActivityForResult(intent, fav);
            }
        });

        AnFavSelectList anFavSelectList = new AnFavSelectList(items, adapter, loginDTO.getMember_id());
        anFavSelectList.execute();

        // 툴바 안의 뒤로가기 버튼 클릭할 때
        toolbar_context.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //return ;
    }//onCreate()

}//class