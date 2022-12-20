package com.example.project_burgerking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_burgerking.DTO.DeliveryDTO;
import com.example.project_burgerking.R;

import java.util.ArrayList;

public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryAdapter.ViewHolder>{
    ArrayList<DeliveryDTO> list;
    LayoutInflater inflater;

    public DeliveryAdapter(LayoutInflater inflater, ArrayList<DeliveryDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_delivery_menu, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.img.setImageResource(list.get(i).getImg());
        h.name.setText(list.get(i).getName());
        h.price.setText(list.get(i).getPrice());
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
        ImageView img;
        TextView name, price;
        public ViewHolder(@NonNull View v) {
            super(v);
            img = v.findViewById(R.id.iv_burger);
            name = v.findViewById(R.id.tv_name);
            price = v.findViewById(R.id.tv_price);
        }
    }
}
