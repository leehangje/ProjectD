package com.example.projectd;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectd.Dto.ReviewDto;

import java.util.ArrayList;

public class RentAdapter extends RecyclerView.Adapter<RentAdapter.ViewHolder>
        implements OnRentItemCLickListener {
    private static final String TAG = "RentAdapter";

    ArrayList<ReviewDto> items = new ArrayList<ReviewDto>();
    OnRentItemCLickListener listener;
    Context mContext;

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_rent_list_sub, parent, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ReviewDto item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClickListener(OnRentItemCLickListener listener){
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;
        TextView textView3;
        public ViewHolder(final View itemView,
                          final OnRentItemCLickListener listener){
            super(itemView);

            textView = itemView.findViewById(R.id.tv_name);
            textView2 = itemView.findViewById(R.id.tv_addr);
            textView3 = itemView.findViewById(R.id.tv_rate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
                
            });
            
        }

        public void setItem(ReviewDto item){
            textView.setText(item.getMember_id());
            //textView2.setText(item.get);
            textView3.setText(item.getReview_scope());
        }
    }


    public void addItem(ReviewDto item){
        items.add(item);
    }

    public void setItems(ArrayList<ReviewDto> items){
        this.items = items;
    }

    public ReviewDto getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, ReviewDto item){
        items.set(position, item);
    }


}

