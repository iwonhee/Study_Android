package com.example.project_burgerking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.project_burgerking.R;

import java.util.ArrayList;

public class HomeViewPagerAdapter extends RecyclerView.Adapter<HomeViewPagerAdapter.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<Integer> slideList;

    public HomeViewPagerAdapter(Context context, LayoutInflater inflater, ArrayList<Integer> slideList) {
        this.context = context;
        this.inflater = inflater;
        this.slideList = slideList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder( inflater.inflate(R.layout.page_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.iv_home_slide.setImageResource(slideList.get(i));
        h.iv_home_slide.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override
    public int getItemCount() {
        return slideList.size();
    }

    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public int getItemViewType(int position){
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_home_slide;
        public ViewHolder(@NonNull View v) {
            super(v);
            iv_home_slide = v.findViewById(R.id.iv_home_slide);
        }
    }
}
