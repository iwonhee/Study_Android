package com.example.project_burgerking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.project_burgerking.DTO.HomeBurgerDTO;
import com.example.project_burgerking.adapter.HomeBurgerAdapter;
import com.example.project_burgerking.adapter.HomeViewPagerAdapter;
import com.example.project_burgerking.databinding.FragmentMainBinding;
import com.example.project_burgerking.membership.MemberActivity;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    FragmentMainBinding b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentMainBinding.inflate(inflater);

        Context context = container.getContext();

        // 멤버십화면
        b.ivMembership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MemberActivity.class);
                startActivity(intent);
            }
        });

        b.ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 킹오더 클릭
        b.cardKingOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderActivity.class);
                startActivity(intent);
            }
        });

        //뷰페이저 이미지 List
        ArrayList<Integer> slideList = new ArrayList<>();
        slideList.add(R.drawable.home_slide1);
        slideList.add(R.drawable.home_slide2);
        slideList.add(R.drawable.home_slide3);
        slideList.add(R.drawable.home_slide4);
        //뷰페이저 어댑터 연결
        b.viewpagerHome.setAdapter(new HomeViewPagerAdapter(context, getLayoutInflater(), slideList));

        ArrayList<HomeBurgerDTO> list = new ArrayList<>();
        list.add(new HomeBurgerDTO(R.drawable.burger_buw, "블랙어니언 와퍼"));
        list.add(new HomeBurgerDTO(R.drawable.burger_bux, "블랙어니언X"));
        list.add(new HomeBurgerDTO(R.drawable.burger_buc, "블랙어니언 치킨"));
        // It's NEW 스크롤
        b.recvHomeNew.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        b.recvHomeNew.setAdapter(new HomeBurgerAdapter(getLayoutInflater(), list));

        return b.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        b = null;
    }
}