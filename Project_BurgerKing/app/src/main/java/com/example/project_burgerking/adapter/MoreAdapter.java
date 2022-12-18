package com.example.project_burgerking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_burgerking.R;

import java.util.ArrayList;

public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<Integer> list;

    public MoreAdapter(LayoutInflater inflater, ArrayList<Integer> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_more_event, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.iv_event.setImageResource(list.get(i));
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
        ImageView iv_event;
        public ViewHolder(@NonNull View v) {
            super(v);
            iv_event = v.findViewById(R.id.iv_event_big);
        }
    }
}
