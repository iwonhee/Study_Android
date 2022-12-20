package com.example.project_burgerking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project_burgerking.databinding.ActivityDeliveryBinding;

public class DeliveryActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityDeliveryBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityDeliveryBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        //뒤로가기
        b.ivBack.setOnClickListener(this);

        b.relSpecial.setOnClickListener(this);
        b.relNew.setOnClickListener(this);
        b.relPremium.setOnClickListener(this);
        b.relWhopper.setOnClickListener(this);
        b.relChicken.setOnClickListener(this);
        b.relSide.setOnClickListener(this);
        b.relDrink.setOnClickListener(this);
        b.relDog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.iv_back){
            Intent intent = new Intent(DeliveryActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.rel_special){

        }

    }

    // 다른 메뉴 선택 해제
    public void unselect(){

    }

}