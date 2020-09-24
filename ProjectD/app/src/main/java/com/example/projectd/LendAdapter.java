package com.example.projectd;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectd.Dto.MdDTO;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LendAdapter extends RecyclerView.Adapter<LendAdapter.ViewHolder> implements OnLendItemCLickListener {

    Context context;
    List<MdDTO> items;
    OnLendItemCLickListener listener;

    public LendAdapter(Context context, List<MdDTO> items){
        this.context = context;
        this.items = items;
    }

    // 리스너 객체 참조를 저장하는 변수
   // private OnLendItemCLickListener mListener = null ;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_lend_list_sub, parent, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MdDTO item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() { return items.size(); }

    public void setOnItemClickListener(OnLendItemCLickListener listener){
        this.listener = listener;
    }

    @Override
    public void onItemClick(LendAdapter.ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_md_lend_name;
        TextView tv_md_lender;
        TextView tv_md_category;
        TextView tv_md_serial_num;
        ImageView iv_md_img;

        public ViewHolder(final View itemView, final OnLendItemCLickListener listener){
            super(itemView);

            tv_md_lend_name = itemView.findViewById(R.id.tv_md_lend_name);
            tv_md_lender = itemView.findViewById(R.id.tv_md_lender);
            tv_md_category = itemView.findViewById(R.id.tv_md_category);
            tv_md_serial_num = itemView.findViewById(R.id.tv_md_serial_num);
            iv_md_img = itemView.findViewById(R.id.iv_md_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }

                }
            });
        }

        public void setItem(MdDTO item){
            tv_md_lend_name.setText(item.getMd_name());
            tv_md_lender.setText(item.getMember_id());
            tv_md_category.setText(item.getMd_category());
            tv_md_serial_num.setText(item.getMd_serial_number());
            Glide.with(itemView).load(item.getMd_photo_url()).into(iv_md_img);
        }
    }

    public void removeAll(){
        items.clear();
    }

    public void addItem(MdDTO item){
        items.add(item);
    }

    public void setItems(ArrayList<MdDTO> items){
        this.items = items;
    }

    public MdDTO getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, MdDTO item){
        items.set(position, item);
    }

}

