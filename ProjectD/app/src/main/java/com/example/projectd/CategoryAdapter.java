package com.example.projectd;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectd.Dto.MdDTO;
import static com.example.projectd.CategoryViewActivity.selItem;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<MdDTO> items;

    public CategoryAdapter(Context mContext, ArrayList<MdDTO> items) {
        this.mContext = mContext;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card_list, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d("main:CategoryAdapter", "" + position);

        MdDTO item = items.get(position);
        holder.setItem(item);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("main:CategoryAdapter", "onClick: " + position);

                selItem = items.get(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    // 어댑터에 매소드 만들기

    // 리사이클러뷰 내용 모두 지우기
    public void removeAllItem(){
        items.clear();
    }

    // 특정 인덱스 항목 가져오기
    public MdDTO getItem(int position) {
        return items.get(position);
    }

    // 특정 인덱스 항목 셋팅하기
    public void setItem(int position, MdDTO item){
        items.set(position, item);
    }

    // arrayList 통째로 셋팅하기
    public void setItems(ArrayList<MdDTO> items){
        this.items = items;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout parentLayout;
        public TextView md_name;
        public TextView md_price;
        public ImageView md_photo;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.parentLayout);
            md_name = itemView.findViewById(R.id.tv_title);
            md_price = itemView.findViewById(R.id.tv_price);
            md_photo = itemView.findViewById(R.id.iv_img);
        }

        public void setItem(MdDTO item){
            md_name.setText(item.getMd_name());
            md_price.setText(item.getMd_price());

            Glide.with(itemView).load(item.getMd_photo_url()).into(md_photo);
        }
    }
}