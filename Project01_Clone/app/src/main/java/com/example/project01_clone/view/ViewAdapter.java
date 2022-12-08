package com.example.project01_clone.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<ViewDTO> list;

    public ViewAdapter(LayoutInflater inflater, ArrayList<ViewDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_view_myview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.iv_view_writer.setImageResource(list.get(i).getIv_view_writer());
        h.iv_view_main.setImageResource(list.get(i).getImgRes());
        h.tv_view_title.setText(list.get(i).getTv_view_title());
        h.tv_view_subtitle.setText(list.get(i).getTv_view_subtitle());
        h.tv_view_time.setText(list.get(i).getTv_view_time()+"시간 전");
        h.tv_view_content.setText(list.get(i).getTv_view_content());
        h.tv_view_writer.setText(list.get(i).getTv_view_writer());
        h.tv_view_writer2.setText(list.get(i).getTv_view_writer2());
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_view_title, tv_view_writer, tv_view_subtitle, tv_view_content, tv_view_writer2, tv_view_time;
        ImageView iv_view_main, iv_view_writer;

        public ViewHolder(@NonNull View v) {
            super(v);
            iv_view_main = v.findViewById(R.id.iv_view_main);
            tv_view_title = v.findViewById(R.id.tv_view_title);
            tv_view_writer = v.findViewById(R.id.tv_view_writer);
            tv_view_subtitle = v.findViewById(R.id.tv_view_subtitle);
            tv_view_content = v.findViewById(R.id.tv_view_content);
            tv_view_writer2 = v.findViewById(R.id.tv_view_writer2);
            tv_view_time = v.findViewById(R.id.tv_view_time);
            iv_view_writer = v.findViewById(R.id.iv_view_writer);
        }
    }
}
