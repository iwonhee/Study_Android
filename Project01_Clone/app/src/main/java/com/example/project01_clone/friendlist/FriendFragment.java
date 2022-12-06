package com.example.project01_clone.friendlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;

import java.util.ArrayList;
import java.util.Random;

public class FriendFragment extends Fragment {
    ArrayList<FriendDTO> list = new ArrayList<>();
    int[] imgArr = {
            R.drawable.profile_img1,
            R.drawable.profile_img2,
            R.drawable.profile_img3,
            R.drawable.profile_img4,
            R.drawable.profile_img5,
            R.drawable.profile_img6,
            R.drawable.profile_img7,
            R.drawable.profile_img8,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_friend, container, false);
        // 데이터를 반복문을 통해 30건 넣기.
        // 이름 : 친구이름 + 번호, 상메 : 메세지 + 번호
        // 이미지는 배열을 이용, 랜덤하게 들어가기
//        new Random(imgArr.length);

        Log.d("random", "onCreateView: "+ new Random().nextInt(imgArr.length));
//        list.add(new FriendDTO());
        for(int i = 1; i <= 30; i++){
            list.add(new FriendDTO(imgArr[new Random().nextInt(imgArr.length)] , "친구이름"+i, "메세지"+i));
        }

        RecyclerView recv_friend = v.findViewById(R.id.recv_friend_frag);
        recv_friend.setLayoutManager(new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false
        ));
        recv_friend.setAdapter(new AdapterFriend(inflater, list));

        return v;
    }
}