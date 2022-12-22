package com.example.project_burgerking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project_burgerking.DTO.DeliveryDTO;
import com.example.project_burgerking.adapter.CartAdapter;
import com.example.project_burgerking.databinding.ActivityCartBinding;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityCartBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        ArrayList<DeliveryDTO> list = new ArrayList<>();    //22.12.22 제출
        list.add(new DeliveryDTO(R.drawable.burger_ch2, "통새우슈림프버거", 6900));
        list.add(new DeliveryDTO(R.drawable.burger_pre1, "기네스콰트로치즈와퍼", 10200));
        list.add(new DeliveryDTO(R.drawable.burger_wp2, "스태커3와퍼", 12400));

        b.recvCart.setAdapter(new CartAdapter(list, getLayoutInflater()));
        b.recvCart.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        b.ivBack.setOnClickListener(this);

        b.cbAll.setChecked(true);



    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.iv_back){
            //뒤로가기 클릭
            Intent intent = new Intent(CartActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }
}