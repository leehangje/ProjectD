package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.projectd.Common.CommonMethod;
import com.example.projectd.Dto.MdDTO;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LendListActivity extends AppCompatActivity {

    private static final String TAG = "LendListActivity";

    RecyclerView recyclerView;
    LendAdapter adapter;
    ViewGroup viewGroup;
    MdDTO dto;

    LinearLayout toolbar_context;   //툴바를 감싸는 레이아웃

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend_list);

        recyclerView = findViewById(R.id.recyclerView);
        toolbar_context = findViewById(R.id.toolbar_context);


        String category; // TODO 여기서 카테고리를 받는다
        //category = dto.getMd_category();

        category = "육아용품";  // 임의 카테고리 TODO 바꾸세요

        MdPullRequest request = new MdPullRequest(category);
        request.execute();
/*
        adapter.setOnItemClickListener(new OnLendItemCLickListener() {
            public static final int lend = 1001;

            @Override
            public void onItemClick(LendAdapter.ViewHolder holder, View view, int position) {
                MdDTO item = adapter.getItem(position);

                Toast.makeText(getApplicationContext(), "아이템 선택됨" + item.getMd_name(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MdDetailActivity.class);
                startActivity(intent);

            }
        });
*/

        // 툴바 안의 뒤로가기 버튼 클릭할 때
        toolbar_context.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private class MdPullRequest extends AsyncTask<Void, Void, List<MdDTO>> {

        String category;

        public MdPullRequest(String category) {
            this.category = category;
        }

        @Override
        protected List<MdDTO> doInBackground(Void... voids) {
            Log.e(TAG, "doInBackground: 호출됨");
            String param = "category=" + category;
            List<MdDTO> list = null;
            try {
                // 연결단계
                URL url = new URL(CommonMethod.ipConfig + "app/anMdpull");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setConnectTimeout(3000);
                conn.setReadTimeout(3000);

                Log.e(TAG, "doInBackground: 1단계");

                // 파라미터를 보내는 단계
                OutputStream os = conn.getOutputStream();
                os.write(param.getBytes("utf-8"));
                os.flush();
                os.close();

                Log.e(TAG, "doInBackground: 2단계");

                // 데이터를 가져오는 단계
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = "";
                StringBuffer sb = new StringBuffer();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                String json = sb.toString();

                Log.e(TAG, "doInBackground: 3단계");
                Log.e(TAG, "json: " + json);

                // Json 데이터를 객체로 반환
                Gson gson = new Gson();
                MdDTO[] dtos = gson.fromJson(json.trim(), MdDTO[].class);
                list = Arrays.asList(dtos);

                Log.e(TAG, "doInBackground: 4단계");

            } catch (Exception e) {
                e.printStackTrace();
            }

            return list;
        }

        @Override
        protected void onPostExecute(List<MdDTO> mdDTOS) {
            LinearLayoutManager layoutManager =
                    new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
            adapter = new LendAdapter(getApplicationContext(), mdDTOS);
            recyclerView.setAdapter(adapter);
            super.onPostExecute(mdDTOS);
        }
    }
}