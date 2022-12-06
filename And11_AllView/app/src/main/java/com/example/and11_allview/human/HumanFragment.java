package com.example.and11_allview.human;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and11_allview.R;

import java.util.ArrayList;

public class HumanFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_human, container, false);

        RecyclerView recy_human = v.findViewById(R.id.recv_human);

        ArrayList<HumanDTO> list = new ArrayList<>();

        list.add(new HumanDTO());

        recy_human.setAdapter(new HumanAdapter(inflater, list));
        // 리사이클러뷰 매니저 설정
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false
        );
        recy_human.setLayoutManager(manager);

        return v;
    }
}