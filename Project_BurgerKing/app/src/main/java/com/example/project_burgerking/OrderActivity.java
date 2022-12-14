package com.example.project_burgerking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_burgerking.databinding.ActivityOrderBinding;
import com.example.project_burgerking.kingOrder.Search1Fragment;
import com.example.project_burgerking.kingOrder.Search2Fragment;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityOrderBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();


        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Search1Fragment()).commit();

        b.relSearchTab1.setOnClickListener(this);
        b.relSearchTab2.setOnClickListener(this);

        //뒤로가기 클릭
        b.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        // 킹오더 탭 클릭
        if(v.getId() == R.id.rel_search_tab1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Search1Fragment()).commit();
            checkOff(b.tvSearchTab2, b.vSearchUnderline2);
            checkOn(b.tvSearchTab1, b.vSearchUnderline1);
        }else if(v.getId() == R.id.rel_search_tab2){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Search2Fragment()).commit();
            checkOff(b.tvSearchTab1, b.vSearchUnderline1);
            checkOn(b.tvSearchTab2, b.vSearchUnderline2);
        }
    }

    // 선택하지 않은 탭 회색으로 바꾸기
    public void checkOff(TextView txt, View underline){
        txt.setTextColor(getResources().getColor(R.color.font_gray));
        underline.setBackgroundColor(getResources().getColor(R.color.line_gray));
    }
    // 선택한 탭 강조색으로
    public void checkOn(TextView txt, View underline){
        txt.setTextColor(getResources().getColor(R.color.icon_red));
        underline.setBackgroundColor(getResources().getColor(R.color.icon_red));
    }


}