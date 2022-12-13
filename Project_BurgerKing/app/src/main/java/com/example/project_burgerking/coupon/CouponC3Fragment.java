package com.example.project_burgerking.coupon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_burgerking.R;
import com.example.project_burgerking.databinding.FragmentCouponC3Binding;

public class CouponC3Fragment extends Fragment {
    FragmentCouponC3Binding b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentCouponC3Binding.inflate(inflater);



        return b.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        b = null;
    }
}