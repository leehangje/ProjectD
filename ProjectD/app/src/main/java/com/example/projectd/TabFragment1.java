package com.example.projectd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectd.ATask.AnReviewSelect;
import com.example.projectd.Dto.MdDTO;
import com.example.projectd.Dto.ReviewDto;

import java.util.ArrayList;

public class  TabFragment1 extends Fragment {

    RecyclerView recyclerView;
    ReviewAdapter adapter;
    MdDetailActivity activity;

    ArrayList<ReviewDto> reviews;
    String md_serial_number;

    /*private Context mContext = MainActivity.this;*/
    private static final int ACTIVITY_NUM = 3;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_tab1,container,false);

        activity = (MdDetailActivity) getActivity();

        if(activity.mBundle != null){
            Bundle bundle = activity.mBundle;
            md_serial_number = bundle.getString("md_serial_number");
            activity.mBundle = null;
        }

        reviews = new ArrayList<>();

        recyclerView = rootView.findViewById(R.id.recyclerView);

        //recyclerView.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new ReviewAdapter(getContext(), reviews);

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnReviewItemClickListener() {
            //public static final int main = 1001;

            @Override
            public void onItemClick(ReviewAdapter.ViewHolder holder, View view, int position) {
                //ReviewDto review = adapter.getItem(position);

                //Intent intent = new Intent(getActivity(), MdDetailActivity.class);
                //intent.putExtra("item", item);
                //startActivityForResult(intent, main);
            }
        });

        AnReviewSelect anReviewSelect = new AnReviewSelect(reviews, adapter, md_serial_number);
        anReviewSelect.execute();


        return  rootView;


    }
}