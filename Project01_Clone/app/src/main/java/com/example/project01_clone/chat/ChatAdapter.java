package com.example.project01_clone.chat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<ChatDTO> list;
    Context context;

    public ChatAdapter(LayoutInflater inflater, ArrayList<ChatDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_chat_recv, parent, false);


        return new ViewHolder(v);
    }

    //아이템 각각 컨트롤
    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.iv_chat.setImageResource(list.get(i).getIv_chat());
        h.tv_chat_title.setText(list.get(i).getTv_chat_title());
        h.tv_chat_msg.setText(list.get(i).getTv_chat_msg());
        h.tv_chat_time.setText(list.get(i).getTv_chat_time());

        final int index = i;
        h.lin_chat_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("dto", list.get(index));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // 포지션이 꼬여서 데이터 통제가 안되는 문제 해결법
    @Override
    public long getItemId(int i){
        return i;
    }
    @Override
    public int getItemViewType(int i){
        return i;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_chat;
        TextView tv_chat_title, tv_chat_msg, tv_chat_time;
        LinearLayout lin_chat_item;
        public ViewHolder(@NonNull View v) {
            super(v);
            iv_chat = v.findViewById(R.id.iv_chat);
            tv_chat_title = v.findViewById(R.id.tv_chat_title);
            tv_chat_msg = v.findViewById(R.id.tv_chat_msg);
            tv_chat_time = v.findViewById(R.id.tv_chat_time);
            lin_chat_item = v.findViewById(R.id.lin_chat_item);
        }
    }
}
