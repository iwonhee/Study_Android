package com.example.check_listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class Adapter_Main extends BaseAdapter {
    LayoutInflater inflater;

    public Adapter_Main(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 0;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        //
        convertView = inflater.inflate(R.layout.item_lv_main, parent, false);


        return convertView;
    }
}
