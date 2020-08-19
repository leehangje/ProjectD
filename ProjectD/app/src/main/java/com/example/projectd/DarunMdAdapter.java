package com.example.projectd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DarunMdAdapter extends RecyclerView.Adapter<DarunMdAdapter.ViewHolder>
        implements OnDarunMdItemClickListener {

    Context context;
    ArrayList<Darun> items;
    OnDarunMdItemClickListener listener;

    public DarunMdAdapter(Context context, ArrayList<Darun> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card_list, parent, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Darun item = items.get(position);
        holder.setItem(item);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClickListener(OnDarunMdItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onItemClick(DarunMdAdapter.ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView, final OnDarunMdItemClickListener listener){
            super(itemView);

            textView = itemView.findViewById(R.id.tv_title);
            textView2 = itemView.findViewById(R.id.tv_price);

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
        public void setItem(Darun item){
            textView.setText(item.getTitle());
            textView2.setText(item.getPrice());
        }

    }


    public void addItem(Darun item){
        items.add(item);
    }

    public void setItems(ArrayList<Darun> items){
        this.items = items;
    }

    public Darun getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, Darun item){
        items.set(position, item);
    }

}