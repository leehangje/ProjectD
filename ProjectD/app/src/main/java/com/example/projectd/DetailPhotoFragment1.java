package com.example.projectd;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailPhotoFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailPhotoFragment1 extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static DetailPhotoFragment1 newInstance(int page, String title) {
        DetailPhotoFragment1 fragment = new DetailPhotoFragment1();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_photo1, container, false);
        EditText tvLabel = (EditText) view.findViewById(R.id.editText);
        tvLabel.setText(page + "번째 사진");
        return view;
    }
}