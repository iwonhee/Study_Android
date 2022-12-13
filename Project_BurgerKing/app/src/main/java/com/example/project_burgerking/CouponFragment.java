package com.example.project_burgerking;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_burgerking.coupon.CouponC1Fragment;
import com.example.project_burgerking.coupon.CouponC2Fragment;
import com.example.project_burgerking.coupon.CouponC3Fragment;
import com.example.project_burgerking.databinding.FragmentCouponBinding;

public class CouponFragment extends Fragment {
    FragmentCouponBinding b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentCouponBinding.inflate(inflater);

        // 기본 '매장용' 선택됨
        getChildFragmentManager().beginTransaction().replace(R.id.container, new CouponC1Fragment()).commit();

        // 탭 '매장용' 클릭시
        b.tvCouponTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.tvCouponTab1.setTextColor(getResources().getColor(R.color.icon_red));
                b.vCouponUnderline1.setBackgroundColor(getResources().getColor(R.color.icon_red));
                b.tvCouponTab2.setTextColor(getResources().getColor(R.color.font_gray));
                b.vCouponUnderline2.setBackgroundColor(getResources().getColor(R.color.line_gray));
                b.tvCouponTab3.setTextColor(getResources().getColor(R.color.font_gray));
                b.vCouponUnderline3.setBackgroundColor(getResources().getColor(R.color.line_gray));
                getChildFragmentManager().beginTransaction().replace(R.id.container, new CouponC1Fragment()).commit();
            }
        });
        // 탭 '킹오더용' 클릭시
        b.tvCouponTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.tvCouponTab2.setTextColor(getResources().getColor(R.color.icon_red));
                b.vCouponUnderline2.setBackgroundColor(getResources().getColor(R.color.icon_red));
                b.tvCouponTab1.setTextColor(getResources().getColor(R.color.font_gray));
                b.vCouponUnderline1.setBackgroundColor(getResources().getColor(R.color.line_gray));
                b.tvCouponTab3.setTextColor(getResources().getColor(R.color.font_gray));
                b.vCouponUnderline3.setBackgroundColor(getResources().getColor(R.color.line_gray));
                getChildFragmentManager().beginTransaction().replace(R.id.container, new CouponC2Fragment()).commit();
            }
        });
        // 탭 '딜리버리용' 클릭시
        b.tvCouponTab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.tvCouponTab3.setTextColor(getResources().getColor(R.color.icon_red));
                b.vCouponUnderline3.setBackgroundColor(getResources().getColor(R.color.icon_red));
                b.tvCouponTab1.setTextColor(getResources().getColor(R.color.font_gray));
                b.vCouponUnderline1.setBackgroundColor(getResources().getColor(R.color.line_gray));
                b.tvCouponTab2.setTextColor(getResources().getColor(R.color.font_gray));
                b.vCouponUnderline2.setBackgroundColor(getResources().getColor(R.color.line_gray));
                getChildFragmentManager().beginTransaction().replace(R.id.container, new CouponC3Fragment()).commit();
            }
        });


        // 뒤로가기 클릭
        b.ivCouponBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return b.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        b = null;
    }
}