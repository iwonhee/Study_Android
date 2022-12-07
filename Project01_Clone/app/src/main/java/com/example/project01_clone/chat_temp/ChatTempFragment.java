package com.example.project01_clone.chat_temp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;
import com.example.project01_clone.common.CommonMethod;

import java.util.ArrayList;

public class ChatTempFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat_temp, container, false);
        RecyclerView recv_temp_chat = v.findViewById(R.id.recv_temp_chat);

        ArrayList<ChatTempDTO> list = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            list.add(new ChatTempDTO(R.drawable.profile_img8, "이름"+i, "메세지"+i, "오후 1:25"));
        }

        recv_temp_chat.setAdapter(new ChatTempAdapter(getLayoutInflater(), list, getContext()));

        recv_temp_chat.setLayoutManager(CommonMethod.getManager(getContext()));

        return v;
    }
}