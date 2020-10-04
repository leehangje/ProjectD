package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.projectd.Dto.FavDto;
import com.example.projectd.Dto.MdDTO;

import java.util.ArrayList;

import static com.example.projectd.LoginActivity.loginDTO;

public class FavListActivity extends AppCompatActivity {

    RecyclerView favRecyclerView;
    FavMdAdapter adapter;
    ArrayList<FavDto> favDtos;
    ArrayList<MdDTO> items;

    LinearLayout toolbar_context;   //툴바를 감싸는 레이아웃

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_list);

        //Point size = getDiviceSize();

        favDtos = new ArrayList<>();
        items = new ArrayList<>();

        favRecyclerView = findViewById(R.id.favRecyclerView);
        toolbar_context = findViewById(R.id.toolbar_context);

        adapter = new FavMdAdapter(getApplicationContext(), items);


        favRecyclerView.setAdapter(adapter);
        /*favRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                FavDto dto = (FavDto) adapter.getItem(position);
                //Toast.makeText(FavListActivity.this, "선택"+position+"\n물품명"+dto.getMd_name()+"\n닉네임"+dto.getMember_nickname()
                //        , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(FavListActivity.this , MdDetailActivity.class);
                startActivity(intent);

            }
        });*/

        // 툴바 안의 뒤로가기 버튼 클릭할 때
        toolbar_context.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        adapter.setOnItemClickListener(new OnFavItemClickListener() {
            public static final int main = 1001;

            @Override
            public void onItemClick(FavMdAdapter.ViewHolder holder, View view, int position) {
                MdDTO item = adapter.getItem(position);

                Toast.makeText(getApplicationContext(), "아이템 선택됨" + item.getMd_name(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MdDetailActivity.class);
                intent.putExtra("item", item);
                startActivityForResult(intent, main);
            }

        });

        //여기서부터 작업해라
        //AnFavSelect anFavSelect = new AnFavSelect(items, adapter, loginDTO.getMember_id());
        //AnFavSelect.execute();

        return;
    }//onCreate()s


    /*private Point getDiviceSize() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealSize(size);
        }
        int width = size.x;
        int height = size.y;

        return  size;
    }*/

}//class