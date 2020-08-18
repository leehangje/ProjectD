package com.example.projectd;

import android.view.View;

public interface OnDarunItemClickListener {
    public void onDarunClick(DarunGoogsAdapter.ViewHolder holder, View view, int position);

    void onItemClick(DarunGoogsAdapter.ViewHolder holder, View view, int position);
}
