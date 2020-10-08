package com.example.projectd;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectd.ATask.AnDarunSelect;
import com.example.projectd.Dto.MdDTO;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class TabFragment2 extends Fragment {

    RecyclerView recyclerView;
    DarunMdAdapter adapter;
    MdDetailActivity activity;

    ArrayList<MdDTO> items;
    String member_id;

    /*private Context mContext = MainActivity.this;*/
    private static final int ACTIVITY_NUM = 3;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_tab2,container,false);

        activity = (MdDetailActivity) getActivity();

        if(activity.mBundle != null){
            Bundle bundle = activity.mBundle;
            member_id = bundle.getString("member_id");
            activity.mBundle = null;
        }

        /*Bundle args = getArguments(); // 데이터 받기
        if(args != null)
        {
            member_id = args.getString("member_id");
        }*/

        items = new ArrayList<>();

        recyclerView = rootView.findViewById(R.id.recyclerView);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(activity.getApplicationContext(), LinearLayoutManager.VERTICAL , false);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new DarunMdAdapter(getContext(), items);

        recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new OnDarunMdItemClickListener() {
            public static final int main = 1001;

            @Override
            public void onItemClick(DarunMdAdapter.ViewHolder holder, View view, int position) {
                MdDTO item = adapter.getItem(position);

                Toast.makeText(getActivity(), "아이템 선택됨" + item.getMd_name(),
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getActivity(), MdDetailActivity.class);
                intent.putExtra("item", item);
                startActivityForResult(intent, main);
            }
        });



        AnDarunSelect anDarunSelect = new AnDarunSelect(items, adapter, member_id);
        try {
            anDarunSelect.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return  rootView;

    }
}