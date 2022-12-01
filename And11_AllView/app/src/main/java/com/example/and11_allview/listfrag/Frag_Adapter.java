package com.example.and11_allview.listfrag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.and11_allview.R;

import java.util.ArrayList;

public class Frag_Adapter extends BaseAdapter {

    ArrayList<FragDTO> list;
    LayoutInflater inflater;

    public Frag_Adapter(LayoutInflater inflater, ArrayList<FragDTO> list){
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
    public View getView(int i, View v, ViewGroup root) {
        v = inflater.inflate(R.layout.item_frag_listv, root, false);

        TextView tv_name = v.findViewById(R.id.tv_name);
        TextView tv_upload_time = v.findViewById(R.id.tv_upload_time);

        return v;
    }
}
