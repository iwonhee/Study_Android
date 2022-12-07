package com.example.project01_clone.chat;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

public class ChatAnsAdapter extends RecyclerView.Adapter<ChatAnsAdapter.ViewHolder>{
    LayoutInflater inflater;

    public ChatAnsAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_chat_inside, parent, false);
        return new ViewHolder(v);
    }

    @Override   // Binding, bind : 화면에 보이는 요소와 화면에 보이지 않는 요소의 데이터가 연결
    public void onBindViewHolder(@NonNull ViewHolder v, int i) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_chat_msg_ans;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_chat_msg_ans = v.findViewById(R.id.tv_chat_msg_ans);
        }
    }
}
