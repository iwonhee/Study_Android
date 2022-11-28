package com.example.and10_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class SubFragment extends Fragment {
    Button btn_sub_frag;
    ImageView img1, img2;
    int cnt = 0 ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sub, container, false);

        btn_sub_frag = v.findViewById(R.id.btn_sub_frag);
        img1 = v.findViewById(R.id.iv_sub_frag1);
        img2 = v.findViewById(R.id.iv_sub_frag2);

        btn_sub_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt == 0){
                    img1.setVisibility(View.GONE);
                    img2.setVisibility(View.VISIBLE);
                    cnt = 1;
                }else if(cnt == 1){
                    img2.setVisibility(View.GONE);
                    img1.setVisibility(View.VISIBLE);
                    cnt = 0;
                }
            }
        });

        return v;
    }
}