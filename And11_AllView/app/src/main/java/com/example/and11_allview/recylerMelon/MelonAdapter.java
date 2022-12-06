package com.example.and11_allview.recylerMelon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and11_allview.R;

import java.util.ArrayList;

public class MelonAdapter extends RecyclerView.Adapter<MelonAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<MelonDTO> list;

    public MelonAdapter(LayoutInflater inflater, ArrayList<MelonDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recy_melon, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    //
    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.iv_main.setImageResource(list.get(i).iv_main);
        h.tv_title.setText(list.get(i).tv_title);
        h.tv_sub.setText(list.get(i).tv_sub);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // 포지션이 꼬여서 데이터 통제가 안되는 문제 해결법
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public int getItemViewType(int position){
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //필드
        ImageView iv_main;
        TextView tv_title, tv_sub;
        public ViewHolder(@NonNull View v) {
            super(v);
            // item id 초기화
            iv_main = v.findViewById(R.id.iv_main);
            tv_title = v.findViewById(R.id.tv_title);
            tv_sub = v.findViewById(R.id.tv_sub);

        }
    }
}
