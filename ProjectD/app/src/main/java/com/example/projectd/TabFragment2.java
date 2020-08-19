package com.example.projectd;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TabFragment2 extends Fragment {
    MdDetailActivity activity;

    RecyclerView recyclerView;
    DarunMdAdapter adapter;
    ArrayList<Darun> items;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_tab2,container,false);

        activity = (MdDetailActivity) getActivity();
        items = new ArrayList<>();

        recyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(activity.getApplicationContext(), LinearLayoutManager.VERTICAL , false);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new DarunMdAdapter(activity.getApplicationContext(), items);

        adapter.addItem(new Darun("킥보드", "2000원"));
        adapter.addItem(new Darun("자건거", "5000원"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnDarunMdItemClickListener() {
            public static final int main = 1001;

            @Override
            public void onItemClick(DarunMdAdapter.ViewHolder holder, View view, int position) {
                Darun item = adapter.getItem(position);

                Toast.makeText(activity.getApplicationContext(), "선택됨" + item.getTitle(),
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(activity.getApplicationContext(), MdDetailActivity.class);
                startActivityForResult(intent, main);
            }
        });

        return  rootView;


    }
}