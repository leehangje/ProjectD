package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MdInsertActivity extends AppCompatActivity {
    TextView textView;

    String[] items = {"스포츠/레저","여행용품","육아용품","게임/취미","자전거/오토바이","기타"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_insert);

        textView = findViewById(R.id.textView);

        Spinner spinner = findViewById(R.id.catecory);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);    //스피너 어뎁터 설정하기

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {  //스피너에 리스너 설정하기
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(items[i]);
            }

            public void onNothingSelected(AdapterView<?> adapterView){
                textView.setText("");
            }
        });
    }
}