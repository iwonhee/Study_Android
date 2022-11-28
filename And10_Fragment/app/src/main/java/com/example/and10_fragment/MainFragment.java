package com.example.and10_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainFragment extends Fragment {
    Button btn_main_frag;
    MainActivity activity;
    public MainFragment(MainActivity activity){
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,      // MainActivity 에서 준 container
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);    // false 는 바로 붙이지 않겠다는 의미, mainAct에서 commit할때 하므로
        btn_main_frag = v.findViewById(R.id.btn_main_frag);

        btn_main_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //토스트창 띄우기
                Toast.makeText(container.getContext(), "버튼클릭", Toast.LENGTH_SHORT).show();
            }
        });
        
        return v;
    }


}