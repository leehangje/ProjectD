package com.example.projectd;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectd.Dto.MdDTO;
import static com.example.projectd.CategoryViewActivity.selItem;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>  implements OnMainMdItemClickListener {

    private Context mContext;
    private ArrayList<MdDTO> items;
    OnMainMdItemClickListener listener;
    public CategoryAdapter(Context mContext, ArrayList<MdDTO> items) {
        this.mContext = mContext;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card_list, parent, false);

        return new ViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d("main:CategoryAdapter", "" + position);

        MdDTO item = items.get(position);
        holder.setItem(item);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("main:CategoryAdapter", "onClick: " + position);

                selItem = items.get(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    // 어댑터에 매소드 만들기

    // 리사이클러뷰 내용 모두 지우기
    public void removeAllItem(){
        items.clear();
    }

    // 특정 인덱스 항목 가져오기
    public MdDTO getItem(int position) {
        return items.get(position);
    }

    // 특정 인덱스 항목 셋팅하기
    public void setItem(int position, MdDTO item){
        items.set(position, item);
    }

    // arrayList 통째로 셋팅하기
    public void setItems(ArrayList<MdDTO> items){
        this.items = items;
    }


    public void setOnItemClickListener(OnMainMdItemClickListener listener){
        this.listener = listener;
    }



  

    @Override
    public void onItemClick(MainMdAdapter.ViewHolder holder, View view, int position) {
        if (listener != null){
            listener.onItemClick(holder, view, position);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout parentLayout;
         TextView md_name;
         TextView md_price;
         ImageView md_photo;
        ImageView img_possible;


        public ViewHolder(View itemView, CategoryAdapter categoryAdapter) {
            super(itemView);


                parentLayout = itemView.findViewById(R.id.parentLayout);
                md_name = itemView.findViewById(R.id.tv_title);
                md_price = itemView.findViewById(R.id.tv_price);
                md_photo = itemView.findViewById(R.id.iv_img);
                img_possible = itemView.findViewById(R.id.img_possible);

                itemView.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        int position = getAdapterPosition();


                    }
                });
            }


        public void setItem(MdDTO item){
            md_name.setText(item.getMd_name());
            md_price.setText(item.getMd_price() + "원");

            Glide.with(itemView).load(item.getMd_photo_url()).into(md_photo);

            //getMd_rent_status(대여상태)가 1이면 대여중, 0이면 대여가능 표시
            if (item.getMd_rent_status().equals("1")){
                img_possible.setImageResource(R.drawable.impossible);
            }else {
                img_possible.setImageResource(R.drawable.possible);
            }


        }
    }
}