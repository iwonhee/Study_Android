package com.example.project_burgerking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.project_burgerking.DTO.DeliveryDTO;
import com.example.project_burgerking.adapter.DeliveryAdapter;
import com.example.project_burgerking.databinding.ActivityDeliveryBinding;

import java.util.ArrayList;

public class DeliveryActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityDeliveryBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityDeliveryBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        //뒤로가기
        b.ivBack.setOnClickListener(this);

        //메뉴 카테고리 클릭
        b.relSpecial.setOnClickListener(this);
        b.relNew.setOnClickListener(this);
        b.relPremium.setOnClickListener(this);
        b.relWhopper.setOnClickListener(this);
        b.relChicken.setOnClickListener(this);
        b.relSide.setOnClickListener(this);
        b.relDrink.setOnClickListener(this);
        b.relDog.setOnClickListener(this);

        //스페셜&할인팩 list
        ArrayList<DeliveryDTO> special_list = new ArrayList<>();
        special_list.add(new DeliveryDTO(R.drawable.burger_buc, "블랙어니언 치킨버거", "8,500원"));
        special_list.add(new DeliveryDTO(R.drawable.burger_buc, "블랙어니언 치킨버거", "8,500원"));
        special_list.add(new DeliveryDTO(R.drawable.burger_buc, "블랙어니언 치킨버거", "8,500원"));
        //카테고리 기본 : 스페셜&할인팩
        b.recvMenu.setAdapter(new DeliveryAdapter(getLayoutInflater(), special_list));
        b.recvMenu.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

    }

    @Override
    public void onClick(View v) {
        //탭 텍스트, 밑줄
        TextView texts[] = {b.tvSpecial, b.tvPremium, b.tvNew, b.tvWhopper, b.tvChicken, b.tvSide, b.tvDrink, b.tvDog};
        View views[] = {b.vSpecial, b.vNew, b.vPremium, b.vWhopper, b.vChicken, b.vSide, b.vDrink, b.vDog};

        //스페셜&할인팩 ArrayList
        ArrayList<DeliveryDTO> special_list = new ArrayList<>();
        special_list.add(new DeliveryDTO(R.drawable.burger_buc, "블랙어니언 치킨버거", "8,500원"));
        special_list.add(new DeliveryDTO(R.drawable.burger_buc, "블랙어니언 치킨버거", "8,500원"));
        special_list.add(new DeliveryDTO(R.drawable.burger_buc, "블랙어니언 치킨버거", "9,500원"));
        //신제품 ArrayList
        ArrayList<DeliveryDTO> new_list = new ArrayList<>();
        new_list.add(new DeliveryDTO(R.drawable.burger_buw, "블랙어니언 와퍼", "7,800원"));
        new_list.add(new DeliveryDTO(R.drawable.burger_buw, "블랙어니언 와퍼", "8,800원"));
        new_list.add(new DeliveryDTO(R.drawable.burger_buw, "블랙어니언 와퍼", "9,800원"));
        new_list.add(new DeliveryDTO(R.drawable.burger_buw, "블랙어니언 와퍼", "8,800원"));
        new_list.add(new DeliveryDTO(R.drawable.burger_buw, "블랙어니언 와퍼", "8,800원"));
        //프리미엄 ArrayList
        ArrayList<DeliveryDTO> premium_list = new ArrayList<>();
        premium_list.add(new DeliveryDTO(R.drawable.burger_bux, "블랙어니언x", "9,800원"));
        premium_list.add(new DeliveryDTO(R.drawable.burger_bux, "블랙어니언x", "8,800원"));
        premium_list.add(new DeliveryDTO(R.drawable.burger_bux, "블랙어니언x", "18,800원"));

        if(v.getId() == R.id.iv_back){
            Intent intent = new Intent(DeliveryActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.rel_special){
            //스페셜 선택
            setAdapter(special_list);
            selectTab(b.tvSpecial, b.vSpecial, texts, views);
        }else if(v.getId() == R.id.rel_new){
            //신제품 선택
            setAdapter(new_list);
            selectTab(b.tvNew, b.vNew, texts, views);
        }else if(v.getId() == R.id.rel_premium){
            //프리미엄 선택
            setAdapter(premium_list);
            selectTab(b.tvPremium, b.vPremium, texts, views);
        }else if(v.getId() == R.id.rel_whopper){
            //와퍼 선택
            selectTab(b.tvWhopper, b.vWhopper, texts, views);
        }else if(v.getId() == R.id.rel_chicken){
            //치킨 선택
            selectTab(b.tvChicken, b.vChicken, texts, views);
        }else if(v.getId() == R.id.rel_side){
            //사이드 선택
            selectTab(b.tvSide, b.vSide, texts, views);
        }else if(v.getId() == R.id.rel_drink){
            //음료 선택
            selectTab(b.tvDrink, b.vDrink, texts, views);
        }else if(v.getId() == R.id.rel_dog){
            //독푸드 선택
            selectTab(b.tvDog, b.vDog, texts, views);
        }

    }

    // 어댑터 설정
    public void setAdapter(ArrayList<DeliveryDTO> list){
        //메뉴 리사이클러뷰 세팅
        b.recvMenu.setAdapter(new DeliveryAdapter(getLayoutInflater(), list));
        b.recvMenu.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    // 다른 메뉴 선택 해제
    public void selectTab(TextView tv, View underline, TextView texts[], View views[]){
        int line_gray = getResources().getColor(R.color.line_gray);
        int font_gray = getResources().getColor(R.color.font_gray);
        int red = getResources().getColor(R.color.icon_red);

        for(int i = 0; i < texts.length; i++){
            texts[i].setTextColor(font_gray);
            views[i].setBackgroundColor(line_gray);
        }
        tv.setTextColor(red);
        underline.setBackgroundColor(red);
    }

}