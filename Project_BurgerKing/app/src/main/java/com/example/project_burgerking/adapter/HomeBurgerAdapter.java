package com.example.project_burgerking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_burgerking.DTO.HomeBurgerDTO;
import com.example.project_burgerking.R;

import java.util.ArrayList;

public class HomeBurgerAdapter extends RecyclerView.Adapter<HomeBurgerAdapter.ViewHolder>{
    ArrayList<HomeBurgerDTO> list;
    LayoutInflater inflater;

    public HomeBurgerAdapter(LayoutInflater inflater, ArrayList<HomeBurgerDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_home_newburger, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.iv_home_newburger.setImageResource(list.get(i).getImgRes());
        h.tv_home_newburger.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public long getItemId(int i){
        return i;
    }
    @Override
    public int getItemViewType(int i){
        return i;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_home_newburger;
        TextView tv_home_newburger;

        public ViewHolder(@NonNull View v) {
            super(v);
            iv_home_newburger = v.findViewById(R.id.iv_home_newburger);
            tv_home_newburger = v.findViewById(R.id.tv_home_newburger);

        }
    }
}
