package com.example.project01_clone.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.project01_clone.R;
import com.example.project01_clone.common.CommonMethod;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Random;

public class ViewFragment extends Fragment {
    TabLayout tab_layout;
    RecyclerView recv_view;
    int[] view_time = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view, container, false);

        tab_layout = v.findViewById(R.id.tab_layout);

        tab_layout.addTab(tab_layout.newTab().setText("My뷰"));
        tab_layout.addTab(tab_layout.newTab().setText("발견"));
        tab_layout.addTab(tab_layout.newTab().setText("카카오TV"));
        tab_layout.addTab(tab_layout.newTab().setText("코로나"));
        tab_layout.addTab(tab_layout.newTab().setText("잔여백신"));

        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //선택됐을 때
                if(tab.getPosition() == 0){
                    ArrayList<ViewDTO> list = new ArrayList<>();
                    list.add(new ViewDTO(R.drawable.room, R.drawable.santa, view_time[new Random().nextInt(view_time.length)], "제목목묵목"
                                        , "제목밑밑미밑밑", "집꾸미니", "오늘의집"));
                    list.add(new ViewDTO(R.drawable.lion, R.drawable.owl, view_time[new Random().nextInt(view_time.length)], "사자사자"
                            , "따듯한 사자", "야생사자파워", "동물의숲"));
                    list.add(new ViewDTO(R.drawable.tiger, R.drawable.fox, view_time[new Random().nextInt(view_time.length)], "호랑호랑"
                            , "그르릉", "집고양이", "동물의술"));

                    recv_view.setLayoutManager(CommonMethod.getManager(getContext()));
                    recv_view.setAdapter(new ViewAdapter(inflater, list));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    ArrayList<ViewDTO> list = new ArrayList<>();
                    list.add(new ViewDTO(R.drawable.room, R.drawable.santa, view_time[new Random().nextInt(view_time.length)], "제목목묵목"
                            , "제목밑밑미밑밑", "집꾸미니", "오늘의집"));
                    list.add(new ViewDTO(R.drawable.lion, R.drawable.owl, view_time[new Random().nextInt(view_time.length)], "사자사자"
                            , "따듯한 사자", "야생사자파워", "동물의숲"));
                    list.add(new ViewDTO(R.drawable.tiger, R.drawable.fox, view_time[new Random().nextInt(view_time.length)], "호랑호랑"
                            , "그르릉", "집고양이", "동물의술"));

                    recv_view.setLayoutManager(CommonMethod.getManager(getContext()));
                    recv_view.setAdapter(new ViewAdapter(inflater, list));
                }
            }
        });
        recv_view = v.findViewById(R.id.recv_view);
        recv_view.setLayoutManager(CommonMethod.getManager(getContext()));

        tab_layout.getTabAt(0).select();

        // Adapter나 모양은 직접 구현해야함


        return v;
    }
}