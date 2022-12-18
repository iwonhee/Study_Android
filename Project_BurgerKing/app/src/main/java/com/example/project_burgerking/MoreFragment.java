package com.example.project_burgerking;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_burgerking.adapter.MoreAdapter;
import com.example.project_burgerking.databinding.FragmentMoreBinding;

import java.util.ArrayList;

public class MoreFragment extends Fragment implements View.OnClickListener{
    FragmentMoreBinding b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentMoreBinding.inflate(inflater);

        // 이벤트 이미지 list 에 담기
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.event_big1);
        list.add(R.drawable.event_big2);
        list.add(R.drawable.event_big3);
        list.add(R.drawable.event_big4);
        list.add(R.drawable.event_big5);

        // 어댑터 설정
        b.recvMoreEvent.setAdapter(new MoreAdapter(inflater, list));
        b.recvMoreEvent.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        // 뒤로가기
        b.ivBack.setOnClickListener(this);

        // 텍스트 리니어 클릭
        b.linEvent.setOnClickListener(this);
        b.linStoreInfo.setOnClickListener(this);
        b.linMenuInfo.setOnClickListener(this);
        b.linTerms.setOnClickListener(this);
        b.linCustomer.setOnClickListener(this);
        b.linSetting.setOnClickListener(this);

        // & 입력
        b.tvDetailSpecial.setText("스페셜&할인팩");
        b.tvDetailWhopper.setText("와퍼&주니어");
        b.tvDetailChicken.setText("치킨&슈림프");
        b.tvDetailDrink.setText("음료&디저트");

        return b.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        b = null;
    }

    // 클릭이벤트
    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.iv_back){
            //뒤로가기(홈으로)
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.lin_event){
            toggleDetail(b.linSub1, b.ivDown1);
        }else if(v.getId() == R.id.lin_store_info){
            toggleDetail(b.linSub2, b.ivDown2);
        }else if(v.getId() == R.id.lin_menu_info){
            toggleDetail(b.linSub3, b.ivDown3);
        }else if(v.getId() == R.id.lin_terms){
            toggleDetail(b.linSub4, b.ivDown4);
        }else if(v.getId() == R.id.lin_customer){
            toggleDetail(b.linSub5, b.ivDown5);
        }

    }

    public  void toggleDetail(View linear, View img){
        if(linear.getVisibility() == View.GONE) {
            linear.setVisibility(View.VISIBLE);
            img.setRotation(180);
        } else {
            linear.setVisibility(View.GONE);
            img.setRotation(0);
        }
    }


}