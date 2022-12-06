package com.example.project01_clone.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project01_clone.R;

public class ChatActivity extends AppCompatActivity {
    ImageView iv_chat_inside, iv_chat_profile_inside;
    TextView tv_chat_title_inside, tv_chat_msg_inside, tv_chat_time_inside;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        getSupportActionBar().hide();

        iv_chat_inside = findViewById(R.id.iv_chat_inside);                     // 채팅방 이미지
        iv_chat_profile_inside = findViewById(R.id.iv_chat_profile_inside);     // 마지막 메세지 쓴 사람의 프로필 이미지뷰
        tv_chat_title_inside = findViewById(R.id.tv_chat_title_inside);         // 채팅방 이름
        tv_chat_msg_inside = findViewById(R.id.tv_chat_msg_inside);             // 마지막 메세지
        tv_chat_time_inside = findViewById(R.id.tv_chat_time_inside);           // 마지막 메세지 옆에 붙을 시간

        Intent intent = getIntent();
        ChatDTO dto = (ChatDTO) intent.getSerializableExtra("dto");
        iv_chat_inside.setImageResource(dto.getIv_chat());
        tv_chat_title_inside.setText(dto.getTv_chat_title());
        tv_chat_msg_inside.setText(dto.getTv_chat_msg());
        tv_chat_time_inside.setText(dto.getTv_chat_time());

    }
}