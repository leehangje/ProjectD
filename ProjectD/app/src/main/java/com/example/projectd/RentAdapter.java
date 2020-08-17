package com.example.projectd;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RentAdapter extends RecyclerView.Adapter<RentAdapter.ViewHolder>
        implements OnRentItemCLickListener {
    ArrayList<Rent> items = new ArrayList<Rent>();
    OnRentItemCLickListener listener;


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



    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView, final OnRentItemCLickListener listener){
            super(itemView);

            textView = itemView.findViewById(R.id.tv_name);
            textView2 = itemView.findViewById(R.id.tv_addr);

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

