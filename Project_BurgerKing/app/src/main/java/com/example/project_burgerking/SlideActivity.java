package com.example.project_burgerking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_burgerking.adapter.MoreAdapter;
import com.example.project_burgerking.databinding.ActivitySlideBinding;

import java.util.ArrayList;

public class SlideActivity extends AppCompatActivity implements View.OnClickListener {
    ActivitySlideBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        b = ActivitySlideBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        selectRank(b.ivDetail, b.cardBrand, b.tvSelectBrand, b.vBrand);

        // 이벤트 이미지 list 에 담기
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.event_big1);
        list.add(R.drawable.event_big2);
        list.add(R.drawable.event_big3);
        list.add(R.drawable.event_big4);
        list.add(R.drawable.event_big5);

        // 어댑터 설정
        b.recvMoreEvent.setAdapter(new MoreAdapter(getLayoutInflater(), list));
        b.recvMoreEvent.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));


        // 탭 클릭
        b.cardBrand.setOnClickListener(this);
        b.cardWhopper.setOnClickListener(this);
        b.cardComm.setOnClickListener(this);

        // 바텀 탭 클릭
        b.linStoreInfo.setOnClickListener(this);
        b.linMenuInfo.setOnClickListener(this);
        b.linTerms.setOnClickListener(this);
        b.linCustomer.setOnClickListener(this);

        // 닫기 클릭
        b.ivClose.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        CardView[] cards = {b.cardBrand, b.cardWhopper, b.cardComm};
        TextView[] texts = {b.tvSelectBrand, b.tvSelectWhopper, b.tvSelectComm};
        View[] views = {b.vBrand, b.vWhopper, b.vComm};

        if(v.getId() == R.id.card_brand){
            // BRAND 선택
            unselectCard(cards, texts, views);
            selectRank(b.ivDetail, b.cardBrand, b.tvSelectBrand, b.vBrand);
        }else if(v.getId() == R.id.card_whopper){
            // WHOPPER 선택
            unselectCard(cards, texts, views);
            selectRank(b.ivDetail, b.cardWhopper, b.tvSelectWhopper, b.vWhopper);
        }else if(v.getId() == R.id.card_comm){
            // COMM. 선택
            unselectCard(cards, texts, views);
            selectRank(b.ivDetail, b.cardComm, b.tvSelectComm, b.vComm);
        }else if(v.getId() == R.id.lin_store_info){
            toggleDetail(b.linSub1, b.ivDown1);
        }else if(v.getId() == R.id.lin_menu_info){
            toggleDetail(b.linSub2, b.ivDown2);
        }else if(v.getId() == R.id.lin_terms){
            toggleDetail(b.linSub3, b.ivDown3);
        }else if(v.getId() == R.id.lin_customer){
            toggleDetail(b.linSub4, b.ivDown4);
        }else if(v.getId() == R.id.iv_close){
            // MainActivity 로 이동 : 애니메이션 slide
            Intent intent = new Intent(SlideActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_out, R.anim.none);
            finish();
        }

    }

    // 바텀 탭 토글
    public  void toggleDetail(View linear, View img){
        if(linear.getVisibility() == View.GONE) {
            linear.setVisibility(View.VISIBLE);
            img.setRotation(180);
        } else {
            linear.setVisibility(View.GONE);
            img.setRotation(0);
        }
    }

    // 탭 선택
    public void selectRank(ImageView detail, CardView cardview, TextView title, View underline){
        if(title.getText().equals("BRAND")){
            detail.setImageResource(R.drawable.slide_brand);
        }else if(title.getText().equals("WHOPPER")){
            detail.setImageResource(R.drawable.slide_whopper);
        }else if(title.getText().equals("COMM.")){
            detail.setImageResource(R.drawable.slide_comm);
        }
        cardview.setCardBackgroundColor(getResources().getColor(R.color.white));
        title.setTextColor(getResources().getColor(R.color.font_braun));
        underline.setVisibility(View.VISIBLE);
    }
    // 나머지 탭 선택 해제
    public  void unselectCard(CardView[] cards, TextView[] texts, View[] views) {
        for (int i = 0; i < cards.length; i++){
            cards[i].setCardBackgroundColor(getResources().getColor(R.color.bg_middle));
            texts[i].setTextColor(getResources().getColor(R.color.font_unselected));
            views[i].setVisibility(View.INVISIBLE);
        }
    }


}