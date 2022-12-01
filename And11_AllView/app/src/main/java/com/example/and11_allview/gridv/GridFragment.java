package com.example.and11_allview.gridv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.and11_allview.R;

public class GridFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid, container, false);
        // 리스트뷰 layout 파일에서 찾기
        GridView gridv = v.findViewById(R.id.gridv);

        // 어댑터 생성하고 생성자로 inflater 넘겨주기
        Adapter_Grid adapter_grid = new Adapter_Grid(inflater);
        // 찾은 리스트뷰와 어댑터 연결하기
        gridv.setAdapter(adapter_grid);


        return v;
    }
}