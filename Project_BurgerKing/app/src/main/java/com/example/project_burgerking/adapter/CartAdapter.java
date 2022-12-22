package com.example.project_burgerking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_burgerking.DTO.DeliveryDTO;
import com.example.project_burgerking.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{

    ArrayList<DeliveryDTO> list;
    LayoutInflater inflater;

    public CartAdapter(ArrayList<DeliveryDTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        DecimalFormat df = new DecimalFormat("###,###원");
        h.name.setText(list.get(i).getName());
        h.price.setText(df.format(list.get(i).getInt_price()));
        h.total.setText(df.format(list.get(i).getInt_price()));
        h.checkBox.setChecked(true);

        AtomicInteger cnt = new AtomicInteger(Integer.parseInt((String) h.cnt.getText()));

        h.add.setOnClickListener(v -> {
            if(cnt.get() < 21){
                cnt.getAndIncrement();
                h.cnt.setText(""+cnt);
                h.total.setText(df.format(cnt.get()*list.get(i).getInt_price()));
            }
        });
        h.remove.setOnClickListener(v -> {
            if(cnt.get() > 0){
                cnt.getAndDecrement();
                h.cnt.setText(""+cnt);
                h.total.setText(df.format(cnt.get()*list.get(i).getInt_price()));
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public long getItemId(int i){return i;}
    @Override
    public int getItemViewType(int i){return i;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        ImageView add, remove, delete;
        TextView cnt, total, price, name;
        public ViewHolder(@NonNull View v) {
            super(v);
            checkBox = v.findViewById(R.id.cb_menu);
            add = v.findViewById(R.id.iv_add);
            remove = v.findViewById(R.id.iv_remove);
            cnt = v.findViewById(R.id.tv_cnt);
            total = v.findViewById(R.id.tv_total);
            price = v.findViewById(R.id.tv_price);
            name = v.findViewById(R.id.tv_name);
            delete = v.findViewById(R.id.iv_delete);
        }
    }
}
