package com.example.project_burgerking.coupon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_burgerking.R;
import com.example.project_burgerking.databinding.FragmentCouponBinding;
import com.example.project_burgerking.databinding.FragmentCouponC1Binding;

import java.util.ArrayList;

public class CouponC1Fragment extends Fragment {
    FragmentCouponC1Binding b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentCouponC1Binding.inflate(inflater);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.coupon_m1);
        list.add(R.drawable.coupon_m2);
        list.add(R.drawable.coupon_m3);
        list.add(R.drawable.coupon_m4);
        list.add(R.drawable.coupon_m5);
        list.add(R.drawable.coupon_m6);
        list.add(R.drawable.coupon_m7);
        list.add(R.drawable.coupon_m8);
        b.recvCouponC1.setAdapter(new CouponAdapter(list, inflater));
        b.recvCouponC1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));


        return b.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        b = null;
    }
}