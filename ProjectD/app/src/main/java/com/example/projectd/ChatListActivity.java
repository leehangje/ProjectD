package com.example.projectd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projectd.Dto.ChatDto;

public class ChatListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ChatListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChatListAdapter();

        adapter.addItem(new ChatDto());
        adapter.addItem(new ChatDto());

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnChatItemClickListener() {
            public static final int chat = 1001;

            @Override
            public void onItemClick(ChatListAdapter.ViewHolder holder, View view, int position) {
                ChatDto item = adapter.getItem(position);

                Toast.makeText(getApplicationContext(), "아이템 선택됨" + item.getName(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                startActivityForResult(intent, chat);

            }
        });


    }
}