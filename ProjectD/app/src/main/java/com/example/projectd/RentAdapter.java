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

import java.util.ArrayList;

public class RentAdapter extends RecyclerView.Adapter<RentAdapter.ViewHolder>
        implements OnRentItemCLickListener {
    private static final String TAG = "RentAdapter";

    ArrayList<Rent> items = new ArrayList<Rent>();
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
        Rent item = items.get(position);
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
        Button button;
        public ViewHolder(final View itemView,
                          final OnRentItemCLickListener listener){
            super(itemView);

            textView = itemView.findViewById(R.id.tv_name);
            textView2 = itemView.findViewById(R.id.tv_addr);
            button = itemView.findViewById(R.id.btn_review);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
                
            });
            
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    //int i = 0;
                    /**
                     * 버튼 클릭 이벤트
                     */

                    if (position == 0) {
                        Log.e(TAG, "onClick: button " + position);
                        RentListActivity activity = (RentListActivity) mContext;
                        activity.runReviewActivity();
                    }

                    if (position == 1) {
                        Log.e(TAG, "onClick: button " + position);
                        RentListActivity activity = (RentListActivity) mContext;
                        activity.runReviewActivity();
                    }

                }
            });
            
        }

        public void setItem(Rent item){
            textView.setText(item.getName());
            textView2.setText(item.getRenter());
        }


    }


    public void addItem(Rent item){
        items.add(item);
    }

    public void setItems(ArrayList<Rent> items){
        this.items = items;
    }

    public Rent getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, Rent item){
        items.set(position, item);
    }








}

