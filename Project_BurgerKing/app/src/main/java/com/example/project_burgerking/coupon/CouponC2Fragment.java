package com.example.project_burgerking.coupon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_burgerking.R;
import com.example.project_burgerking.databinding.FragmentCouponC2Binding;

import java.util.ArrayList;

public class CouponC2Fragment extends Fragment {
    FragmentCouponC2Binding b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentCouponC2Binding.inflate(inflater);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.coupon_k1);
        list.add(R.drawable.coupon_k2);
        list.add(R.drawable.coupon_k3);
        list.add(R.drawable.coupon_k4);
        list.add(R.drawable.coupon_k5);
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