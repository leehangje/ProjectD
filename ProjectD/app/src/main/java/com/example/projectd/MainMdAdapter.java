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

public class MainMdAdapter extends RecyclerView.Adapter<MainMdAdapter.ViewHolder>
        implements OnMainMdItemClickListener {

    Context context;
    ArrayList<MdDTO> items;
    OnMainMdItemClickListener listener;

    public MainMdAdapter(Context context, ArrayList<MdDTO> items) {
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
        MdDTO item = items.get(position);

        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClickListener(OnMainMdItemClickListener listener){
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

        public ViewHolder(View itemView, final OnMainMdItemClickListener listener){
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
        public void setItem(MdDTO item){
            textView.setText(item.getMd_name());
            textView2.setText(item.getMd_price());
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
