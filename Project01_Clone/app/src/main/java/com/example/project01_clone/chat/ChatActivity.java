package com.example.project01_clone.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project01_clone.R;

public class ChatActivity extends AppCompatActivity {
    ImageView iv_chat_inside, iv_chat_profile_inside, iv_chat_send;
    TextView tv_chat_title_inside, tv_chat_msg_inside, tv_chat_time_inside;
    LinearLayout lin_chat_my;
    TextView tv_chat_time_my, tv_chat_msg_my, tv_chat_tag;
    EditText edt_chat;

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
        lin_chat_my = findViewById(R.id.lin_chat_my);                   // 내가 쓴 메세지 전체 layout
        tv_chat_msg_my = findViewById(R.id.tv_chat_msg_my);             // 내가 쓴 메세지
        tv_chat_time_my = findViewById(R.id.tv_chat_time_my);           // 내가 쓴 메세지 시간
        edt_chat = findViewById(R.id.edt_chat);                         // 채팅 입력칸
        tv_chat_tag = findViewById(R.id.tv_chat_tag);                   // # 태그
        iv_chat_send = findViewById(R.id.iv_chat_send);                 // 전송 버튼

        Intent intent = getIntent();
        ChatDTO dto = (ChatDTO) intent.getSerializableExtra("dto");
        iv_chat_inside.setImageResource(dto.getIv_chat());
        tv_chat_title_inside.setText(dto.getTv_chat_title());
        tv_chat_msg_inside.setText(dto.getTv_chat_msg());
        tv_chat_time_inside.setText(dto.getTv_chat_time());
        iv_chat_profile_inside.setImageResource(dto.getIv_chat());

        // EditText 텍스트 입력시
        edt_chat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //before?
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // CharSequence(입력된값)이 있을때만 전송 버튼 보이게
                if(s.toString().equals("")){
                    tv_chat_tag.setVisibility(View.VISIBLE);
                    iv_chat_send.setVisibility(View.GONE);
                }else{
                    tv_chat_tag.setVisibility(View.GONE);
                    iv_chat_send.setVisibility(View.VISIBLE);

                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        // EditText Enter 키 입력시
        edt_chat.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( keyCode == KeyEvent.KEYCODE_ENTER){
                    sendMsg(edt_chat);
                    ansDelay(1500);
                    return true;
                }else{
                    return false;   // EnterKey 말고는 넘어가기
                }
            }
        });
        // 전송 버튼 클릭시
        iv_chat_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsg(edt_chat);
                ansDelay(1500);
            }
        });

    }// onCreate

    // 입력완료 메소드
    public void sendMsg(EditText text){
        lin_chat_my.setVisibility(View.VISIBLE);
        tv_chat_msg_my.setText(text.getText());
        InputMethodManager im = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(text.getWindowToken(),0);
    }

    // 답장 딜레이
    public void ansDelay(int delay){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction().replace(R.id.container_inside, new ChatInsideFragment()).commit();
            }
        }, delay);
    }

}