package com.example.project01_clone.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;

import java.util.ArrayList;
import java.util.Random;

public class ChatFragment extends Fragment {
    int[] imgArr = {
            R.drawable.profile_img8,
            R.drawable.profile_img7,
            R.drawable.profile_img6,
            R.drawable.profile_img5,
            R.drawable.profile_img4,
            R.drawable.profile_img3,
            R.drawable.profile_img2,
            R.drawable.profile_img1
    };
    String[] noonArr = {"오전","오후"};
    int[] timeArr = {
            1,2,3,4,5,6,7,8,9,10,11,12
    };
    int[] mmArr = {
            5,10,15,20,25,30,35,40,45,50,55, 27,22,17,13,46,41,26,18,19,21,23,49,47,42,33,37,38,39
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat, container, false);

        ArrayList<ChatDTO> list = new ArrayList<>();
        for(int i = 1; i < 20; i++){
            list.add(new ChatDTO(
                    imgArr[new Random().nextInt(imgArr.length)]
                    , "채팅방"+i
                    , "마지막 메세지"+i
                    , ""+noonArr[new Random().nextInt(noonArr.length)]
                                        +" "+timeArr[new Random().nextInt(timeArr.length)]
                                        +":"+mmArr[new Random().nextInt(mmArr.length)]));
        }

        RecyclerView recv_chat = v.findViewById(R.id.recv_chat);
        recv_chat.setLayoutManager(new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false
        ));
        recv_chat.setAdapter(new ChatAdapter(inflater, list, getContext()));

        return v;
    }
}