package com.example.projectd;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectd.Dto.MdDTO;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    SearchActivity activity;

    RecyclerView recyclerView;
    SearchAdapter adapter;
    ArrayList<MdDTO> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_search,container,false);

        activity = (SearchActivity) getActivity();
        items = new ArrayList<>();

        recyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(activity.getApplicationContext(), LinearLayoutManager.VERTICAL , false);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new SearchAdapter(activity.getApplicationContext(), items);

        //adapter.addItem(new Search("컴퓨터","3500원"));
        //adapter.addItem(new Search("자건거", "5000원"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnSearchItemClickListener() {
            public static final int main = 1001;
            @Override
            public void onItemClick(SearchAdapter.ViewHolder holder, View view, int position) {
                MdDTO item = adapter.getItem(position);

                Toast.makeText(getActivity(), "아이템 선택됨" + item.getMd_name(),
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(activity.getApplicationContext(), MdDetailActivity.class);
                startActivityForResult(intent, main);
            }
        });

        return  rootView;
    }
}