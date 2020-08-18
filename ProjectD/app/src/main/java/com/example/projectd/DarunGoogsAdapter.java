package com.example.projectd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DarunGoogsAdapter extends RecyclerView.Adapter<DarunGoogsAdapter.ViewHolder>
            implements OnDarunItemClickListener {
    ArrayList<Main> items = new ArrayList<Main>();
    OnDarunItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card_list, parent, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Main item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClickListener(OnDarunItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onDarunClick(ViewHolder holder, View view, int position) {

    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView price;

        public ViewHolder(View itemView, final DarunGoogsAdapter listener) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title);
            price = itemView.findViewById(R.id.tv_price);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(Main item){
            title.setText(item.getTitle());
            price.setText(item.getPrice());
        }
    }

        public void addItem(Main item){
            items.add(item);
        }

        public void setItems(ArrayList<Main> items){
            this.items = items;
        }

        public Main getItem(int position){
            return items.get(position);
        }

        public void setItem(int position, Main item){
            items.set(position, item);
        }

    }

