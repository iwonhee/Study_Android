package com.example.project01_clone.friendlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

// 상속 리사이클러뷰.어댑터<밑에서 만든 ViewHolder>
public class AdapterFriend extends RecyclerView.Adapter<AdapterFriend.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<FriendDTO> list;

    public AdapterFriend(LayoutInflater inflater, ArrayList<FriendDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 만들어둔 아이템 붙이기
        View v = inflater.inflate(R.layout.item_friend, parent, false);

        return new ViewHolder(v);
    }

    //각각의 아이템 내부 처리
    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.iv_profile.setImageResource(list.get(i).getImgRes());
        h.tv_friend_name.setText(list.get(i).getName());
        h.tv_friend_message.setText(list.get(i).getMsg());
    }

    // 아이템 횟수
    @Override
    public int getItemCount() {
        return 10;
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

    // Inner class ViewHolder 생성. Android의 ViewHolder 상속
    // Java DTO 의 기능
    public class ViewHolder extends RecyclerView.ViewHolder{
        // 아이템 필드선언
        ImageView iv_profile;
        TextView tv_friend_name, tv_friend_message;
        public ViewHolder(@NonNull View v) {
            super(v);
            // 찾기
            iv_profile = v.findViewById(R.id.iv_friend_profile);
            tv_friend_name = v.findViewById(R.id.tv_friend_name);
            tv_friend_message = v.findViewById(R.id.tv_friend_message);
        }
    }
}
