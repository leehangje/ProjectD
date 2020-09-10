package com.example.projectd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectd.Dto.ChatDto;

import java.util.ArrayList;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ViewHolder>
        implements OnChatItemClickListener {
    ArrayList<ChatDto> items = new ArrayList<ChatDto>();
    OnChatItemClickListener listener;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_chat_list_sub, parent, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChatDto item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClickListener(OnChatItemClickListener listener){
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
        TextView textView3;
        ImageView imageView;
        public ViewHolder(View itemView, final OnChatItemClickListener listener){
            super(itemView);

            textView = itemView.findViewById(R.id.tv_name);
            textView2 = itemView.findViewById(R.id.tv_addr);
            textView3 = itemView.findViewById(R.id.tv_msg);
            imageView = itemView.findViewById(R.id.iv_img);

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

        public void setItem(ChatDto item){
            textView.setText(item.getName());
            textView2.setText(item.getAddr());
            textView3.setText(item.getMsg());
        }


    }


    public void addItem(ChatDto item){
        items.add(item);
    }

    public void setItems(ArrayList<ChatDto> items){
        this.items = items;
    }

    public ChatDto getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, ChatDto item){
        items.set(position, item);
    }








}
