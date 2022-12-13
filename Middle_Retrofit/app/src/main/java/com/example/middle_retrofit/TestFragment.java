package com.example.middle_retrofit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.middle_retrofit.databinding.FragmentTestBinding;

public class TestFragment extends Fragment {
    FragmentTestBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTestBinding.inflate(inflater);
        return binding.getRoot();
    }

    //fragment 에서 꼭 지우는 작업 하기
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}