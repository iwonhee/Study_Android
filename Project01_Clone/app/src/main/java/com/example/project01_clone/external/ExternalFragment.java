package com.example.project01_clone.external;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.project01_clone.R;

public class ExternalFragment extends Fragment {
    ImageView imgv1, imgv2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_external, container, false);

        imgv1 = v.findViewById(R.id.imgv1);
        imgv2 = v.findViewById(R.id.imgv2);

        Glide.with(this)
                .load("https://media.tenor.com/vxJjiiRh3CUAAAAd/%EC%B6%98%EC%8B%9D-%EC%B6%98%EC%8B%9D%EC%9D%B4.gif")
                .into(imgv1);
        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2022/12/04/00/42/fox-7633557_960_720.png")
                .into(imgv2);

        return v;
    }
}