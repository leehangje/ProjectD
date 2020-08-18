package com.example.projectd;

import android.view.View;

public interface OnReviewItemClickListener {
    public void onReviewClick(ReviewAdapter.ViewHolder holder, View view, int position);

    void onItemClick(ReviewAdapter.ViewHolder holder, View view, int position);
}
