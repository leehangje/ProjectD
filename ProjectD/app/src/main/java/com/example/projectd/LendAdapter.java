package com.example.projectd;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectd.Dto.MdDTO;

import java.util.ArrayList;
import java.util.List;

public class LendAdapter extends RecyclerView.Adapter<LendAdapter.ViewHolder>
        implements OnLendItemCLickListener {

    Context context;
    List<MdDTO> items;
    OnLendItemCLickListener listener;

    public LendAdapter(Context context, List<MdDTO> items){
        this.context = context;
        this.items = items;
    }

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
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClickListener(OnLendItemCLickListener listener){
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }



    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_md_lend_name;
        TextView tv_md_lender;
        TextView tv_md_category;
        TextView tv_md_serial_num;


        public ViewHolder(View itemView, final OnLendItemCLickListener listener){
            super(itemView);

            tv_md_lend_name = itemView.findViewById(R.id.tv_md_lend_name);
            tv_md_lender = itemView.findViewById(R.id.tv_md_lender);
            tv_md_category = itemView.findViewById(R.id.tv_md_category);
            tv_md_serial_num = itemView.findViewById(R.id.tv_md_serial_num);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {


                    }
                }
            });
        }

        public void setItem(MdDTO item){
            tv_md_lend_name.setText(item.getMd_name());
            tv_md_lender.setText(item.getMember_id());
            tv_md_category.setText(item.getMd_category());
            tv_md_serial_num.setText(item.getMd_serial_number());
        }
    }


    public void addItem(MdDTO item){
        items.add(item);
    }

    public void setItems(List<MdDTO> items){
        this.items = items;
    }

    public MdDTO getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, MdDTO item){
        items.set(position, item);
    }








}

