package com.example.test02_listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainAdapter extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList<ListDTO> list;
//    HashMap<String, ListDTO> map;

    public MainAdapter(LayoutInflater inflater, ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_main_listview, parent, false);

        TextView tv_main = convertView.findViewById(R.id.tv_main);
        ImageView iv_main = convertView.findViewById(R.id.iv_main);
//        tv_main.setText(list.get(i).tv_main);

        //객체 생성시 받은 값 그대로 출력 (Main Text)
        tv_main.setText(list.get(i).tv_main);

        iv_main.setImageResource(list.get(i).getIv_main());


        return convertView;
    }
}
