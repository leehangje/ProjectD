package com.example.projectd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class NoticeFindActivity extends Fragment {

    ViewGroup viewGroup;

            public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
                    ViewGroup container, @Nullable Bundle savedInstanceState) {
                viewGroup = (ViewGroup) inflater.inflate(R.layout.activity_notice_find, null);

            ImageView btn_back;

        btn_back = viewGroup.findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return viewGroup;
    }
}