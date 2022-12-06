package com.example.and11_allview.human;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and11_allview.R;

import java.util.ArrayList;

public class HumanAdapter extends RecyclerView.Adapter<HumanAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<HumanDTO> list;

    public HumanAdapter(LayoutInflater inflater, ArrayList<HumanDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 아이템 붙이기 ( 수정 필요 )
        View v = inflater.inflate(R.layout.item_recy_melon, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        //각각의 아이템에 다른 이미지,테스트 적용
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //아이템 필드
        ImageView iv_main;
        TextView tv_title, tv_price;
        public ViewHolder(@NonNull View v) {
            super(v);

        }
    }
}
