package com.example.project_burgerking;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_burgerking.databinding.FragmentMyKingBinding;

public class MyKingFragment extends Fragment implements View.OnClickListener{
    FragmentMyKingBinding b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentMyKingBinding.inflate(inflater);

        // 로그인 클릭
        b.cardLogin.setOnClickListener(this);
        // 멤버십 바코드 클릭
        b.ivMembership.setOnClickListener(this);
        // 조회하기 클릭
        b.cardFind.setOnClickListener(this);

        // Bottom Details Click
        b.linDeliveryCart.setOnClickListener(this);
        b.linKingOrderCart.setOnClickListener(this);
        b.linMembership.setOnClickListener(this);
        b.linInfoChange.setOnClickListener(this);

        // 입력관련 메소드 가져오기
        LoginActivity login = new LoginActivity();
        // 주문번호 입력
        b.edtId.addTextChangedListener(login.getTextWatcher(b.ivClearNumber));
        b.edtPw.addTextChangedListener(login.getTextWatcher(b.ivClearPw));
        // x 누르면 입력한 값 지우기
        b.ivClearNumber.setOnClickListener(this);
        b.ivClearPw.setOnClickListener(this);

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
        // 로그인 화면 이동할 Intent
        Intent intent = new Intent(getContext(), LoginActivity.class);

        if(v.getId() == R.id.lin_delivery_cart){
            // 로그인 페이지로 이동
            startActivity(intent);
        }else if(v.getId() == R.id.iv_clear_number){
            // 주문번호 clear
            b.edtId.setText("");
        }else if(v.getId() == R.id.iv_clear_pw){
            // 비밀번호 clear
            b.edtPw.setText("");
        }else if(v.getId() == R.id.card_login){
            startActivity(intent);
        }else if(v.getId() == R.id.iv_membership){
            startActivity(intent);
        }else if(v.getId() == R.id.lin_kingOrder_cart){
            startActivity(intent);
        }else if(v.getId() == R.id.lin_membership){
            startActivity(intent);
        }else if(v.getId() == R.id.lin_info_change){
            startActivity(intent);
        }

    }
}