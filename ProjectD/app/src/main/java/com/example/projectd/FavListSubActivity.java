package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FavListSubActivity extends BaseAdapter {
    Context context;
    ArrayList<FavListDTO> dtos;

    LayoutInflater inflater;

    Point size;

    public FavListSubActivity(Context context, ArrayList<FavListDTO> dtos,Point size){
        this.context = context;
        this.dtos = dtos;
        this.size = size;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public void addDto(FavListDTO dto) {
        dtos.add(dto);
    }

    public void delDto(int position) {
        dtos.remove(position);
    }

    public void removeAllDto() {
        dtos.clear();
    }
    @Override
    public int getCount() {
        return dtos.size();
    }

    @Override
    public Object getItem(int position) {
        return dtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        SingerViewHolder viewHolder;
        if (view == null) {
            view = inflater.inflate(R.layout.activity_fav_list_sub, viewGroup,false);
            viewHolder = new SingerViewHolder();
            viewHolder. tvMd_name = view.findViewById(R.id.md_name);
            viewHolder.tvMember_nickname = view.findViewById(R.id.member_nickname );

            view.setTag(viewHolder);
        } else {
            viewHolder = (SingerViewHolder) view.getTag();
        }

        FavListDTO dto = dtos.get(position);
        String md_name = dto.getMd_name();
        String member_nickname = dto.getMember_nickname();


        viewHolder.tvMd_name.setText(md_name);
        viewHolder.tvMember_nickname.setText(member_nickname);

        return  view;
    }
    public  class  SingerViewHolder{
        public TextView tvMd_name ,tvMember_nickname;
    }
}