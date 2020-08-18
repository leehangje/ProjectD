package com.example.projectd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder>
            implements OnReviewItemClickListener {
    ArrayList<Review> items = new ArrayList<Review>();
    OnReviewItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.review_sub, parent, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Review item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClickListener(OnReviewItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onReviewClick(ViewHolder holder, View view, int position) {

    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView user_nickname;
        TextView review_text;

        public ViewHolder(View itemView, final ReviewAdapter listener) {
            super(itemView);

            user_nickname = itemView.findViewById(R.id.user_nickname);
            review_text = itemView.findViewById(R.id.review_text);

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

        public void setItem(Review item){
            user_nickname.setText(item.getReviewer());
            review_text.setText(item.getReview_text());
        }
    }

        public void addItem(Review item){
            items.add(item);
        }

        public void setItems(ArrayList<Review> items){
            this.items = items;
        }

        public Review getItem(int position){
            return items.get(position);
        }

        public void setItem(int position, Review item){
            items.set(position, item);
        }

    }

