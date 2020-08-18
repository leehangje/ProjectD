package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ChatListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChatAdapter();

        adapter.addItem(new Chat("박준근", "광주시 서구"));
        adapter.addItem(new Chat("안중근", "광주시 서구"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnChatItemClickListener() {
            public static final int chat = 1001;

            @Override
            public void onItemClick(ChatAdapter.ViewHolder holder, View view, int position) {
                Chat item = adapter.getItem(position);

                Toast.makeText(getApplicationContext(), "아이템 선택됨" + item.getName(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                startActivityForResult(intent, chat);

            }
        });


    }
}