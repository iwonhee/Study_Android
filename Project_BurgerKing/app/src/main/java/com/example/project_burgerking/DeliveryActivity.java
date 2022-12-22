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

import java.text.DecimalFormat;
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

        //장바구니 클릭
        b.ivBasket.setOnClickListener(this);

        //스페셜&할인팩 list
        ArrayList<DeliveryDTO> special_list = new ArrayList<>();
        special_list.add(new DeliveryDTO(R.drawable.burger_bup1, "블랙어니언팩1", parsePrice(23700)));
        special_list.add(new DeliveryDTO(R.drawable.burger_bup1, "블랙어니언팩2", parsePrice(21700)));
        special_list.add(new DeliveryDTO(R.drawable.burger_bup1, "블랙어니언팩3", parsePrice(22600)));
        special_list.add(new DeliveryDTO(R.drawable.burger_bup1, "블랙어니언팩4", parsePrice(20600)));
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
        special_list.add(new DeliveryDTO(R.drawable.burger_bup1, "블랙어니언팩1", parsePrice(23700)));
        special_list.add(new DeliveryDTO(R.drawable.burger_bup1, "블랙어니언팩2", parsePrice(21700)));
        special_list.add(new DeliveryDTO(R.drawable.burger_bup1, "블랙어니언팩3", parsePrice(22600)));
        special_list.add(new DeliveryDTO(R.drawable.burger_bup1, "블랙어니언팩4", parsePrice(20600)));
        //신제품 ArrayList
        ArrayList<DeliveryDTO> new_list = new ArrayList<>();
        new_list.add(new DeliveryDTO(R.drawable.burger_new1, "블랙어니언와퍼", parsePrice(10300)));
        new_list.add(new DeliveryDTO(R.drawable.burger_new2, "블랙어니언치킨버거", parsePrice(8500)));
        new_list.add(new DeliveryDTO(R.drawable.burger_new3, "블랙어니언X", parsePrice(10500)));
        new_list.add(new DeliveryDTO(R.drawable.burger_new4, "골든치즈렐라X", parsePrice(11500)));
        new_list.add(new DeliveryDTO(R.drawable.burger_new5, "골든치즈렐라와퍼", parsePrice(10500)));
        new_list.add(new DeliveryDTO(R.drawable.burger_new6, "골든치즈렐라치킨버거", parsePrice(9500)));
        new_list.add(new DeliveryDTO(R.drawable.burger_new7, "비프불고기버거", parsePrice(4800)));
        //프리미엄 ArrayList
        ArrayList<DeliveryDTO> premium_list = new ArrayList<>();
        premium_list.add(new DeliveryDTO(R.drawable.burger_pre1, "기네스콰트로치즈와퍼", parsePrice(10200)));
        premium_list.add(new DeliveryDTO(R.drawable.burger_pre2, "기네스와퍼", parsePrice(10200)));
        premium_list.add(new DeliveryDTO(R.drawable.burger_pre3, "몬스터와퍼", parsePrice(10200)));
        premium_list.add(new DeliveryDTO(R.drawable.burger_pre4, "몬스터X", parsePrice(11000)));
        premium_list.add(new DeliveryDTO(R.drawable.burger_pre5, "콰트로치즈와퍼", parsePrice(8600)));
        premium_list.add(new DeliveryDTO(R.drawable.burger_pre6, "콰트로치즈X", parsePrice(9400)));
        premium_list.add(new DeliveryDTO(R.drawable.burger_pre7, "통새우와퍼", parsePrice(8600)));
        //와퍼주니어
        ArrayList<DeliveryDTO> whopper_list = new ArrayList<>();
        whopper_list.add(new DeliveryDTO(R.drawable.burger_wp1, "스태커2와퍼", parsePrice(10400)));
        whopper_list.add(new DeliveryDTO(R.drawable.burger_wp2, "스태커3와퍼", parsePrice(12400)));
        whopper_list.add(new DeliveryDTO(R.drawable.burger_wp3, "갈릭불고기와퍼", parsePrice(8200)));
        whopper_list.add(new DeliveryDTO(R.drawable.burger_wp4, "베이컨치즈와퍼", parsePrice(9600)));
        whopper_list.add(new DeliveryDTO(R.drawable.burger_wp5, "할라피뇨와퍼", parsePrice(8600)));
        whopper_list.add(new DeliveryDTO(R.drawable.burger_wp6, "치즈와퍼", parsePrice(8400)));
        whopper_list.add(new DeliveryDTO(R.drawable.burger_wp7, "와퍼", parsePrice(7800)));
        whopper_list.add(new DeliveryDTO(R.drawable.burger_wp8, "불고기와퍼", parsePrice(7800)));
        whopper_list.add(new DeliveryDTO(R.drawable.burger_wp9, "통새우와퍼주니어", parsePrice(6100)));
        whopper_list.add(new DeliveryDTO(R.drawable.burger_wp10, "콰트로치즈와퍼주니어", parsePrice(6100)));
        whopper_list.add(new DeliveryDTO(R.drawable.burger_wp11, "치즈와퍼주니어", parsePrice(5800)));
        whopper_list.add(new DeliveryDTO(R.drawable.burger_wp12, "와퍼주니어", parsePrice(5500)));
        whopper_list.add(new DeliveryDTO(R.drawable.burger_wp13, "불고기와퍼주니어", parsePrice(5500)));
        //치킨슈림프
        ArrayList<DeliveryDTO> chicken_list = new ArrayList<>();
        chicken_list.add(new DeliveryDTO(R.drawable.burger_ch1, "비프&슈림프버거", parsePrice(7900)));
        chicken_list.add(new DeliveryDTO(R.drawable.burger_ch2, "통새우슈림프버거", parsePrice(6900)));
        chicken_list.add(new DeliveryDTO(R.drawable.burger_ch3, "잔망루피슈림프버거", parsePrice(5900)));
        chicken_list.add(new DeliveryDTO(R.drawable.burger_ch4, "롱치킨버거", parsePrice(5500)));
        chicken_list.add(new DeliveryDTO(R.drawable.burger_ch5, "킹치킨버거", parsePrice(4500)));
        chicken_list.add(new DeliveryDTO(R.drawable.burger_ch6, "바비큐킹치킨버거", parsePrice(4500)));
        //사이드
        ArrayList<DeliveryDTO> side_list = new ArrayList<>();
        side_list.add(new DeliveryDTO(R.drawable.side1, "앵그리 너겟킹", parsePrice(3500)));
        side_list.add(new DeliveryDTO(R.drawable.side2, "너겟킹", parsePrice(3500)));
        side_list.add(new DeliveryDTO(R.drawable.side3, "21치즈스틱", parsePrice(2700)));
        side_list.add(new DeliveryDTO(R.drawable.side4, "어니언링", parsePrice(3000)));
        side_list.add(new DeliveryDTO(R.drawable.side5, "바삭킹", parsePrice(3800)));
        side_list.add(new DeliveryDTO(R.drawable.side6, "바삭킹8조각+소스", parsePrice(13000)));
        side_list.add(new DeliveryDTO(R.drawable.side7, "쉐이킹프라이", parsePrice(3000)));
        side_list.add(new DeliveryDTO(R.drawable.side8, "크리미모짜볼", parsePrice(3200)));
        side_list.add(new DeliveryDTO(R.drawable.side9, "코코넛쉬림프+스위트칠리소스", parsePrice(4500)));
        side_list.add(new DeliveryDTO(R.drawable.side10, "치즈프라이", parsePrice(3600)));
        //음료
        ArrayList<DeliveryDTO> drink_list = new ArrayList<>();
        drink_list.add(new DeliveryDTO(R.drawable.drink1, "아메리카노", parsePrice(2200)));
        drink_list.add(new DeliveryDTO(R.drawable.drink2, "핫초코", parsePrice(2700)));
        drink_list.add(new DeliveryDTO(R.drawable.drink3, "아이스초코", parsePrice(2700)));
        drink_list.add(new DeliveryDTO(R.drawable.drink4, "코카콜라", parsePrice(2600)));
        drink_list.add(new DeliveryDTO(R.drawable.drink5, "코카콜라 제로", parsePrice(2600)));
        drink_list.add(new DeliveryDTO(R.drawable.drink6, "스프라이트", parsePrice(2600)));
        drink_list.add(new DeliveryDTO(R.drawable.drink7, "씨그램", parsePrice(2600)));
        drink_list.add(new DeliveryDTO(R.drawable.drink8, "미닛메이드 오렌지", parsePrice(3400)));
        drink_list.add(new DeliveryDTO(R.drawable.drink9, "순수(미네랄워터)", parsePrice(1900)));
        //독퍼
        ArrayList<DeliveryDTO> dog_list = new ArrayList<>();
        dog_list.add(new DeliveryDTO(R.drawable.dogpper, "리얼 독퍼", parsePrice(2900)));

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
            setAdapter(whopper_list);
            selectTab(b.tvWhopper, b.vWhopper, texts, views);
        }else if(v.getId() == R.id.rel_chicken){
            //치킨 선택
            setAdapter(chicken_list);
            selectTab(b.tvChicken, b.vChicken, texts, views);
        }else if(v.getId() == R.id.rel_side){
            //사이드 선택
            setAdapter(side_list);
            selectTab(b.tvSide, b.vSide, texts, views);
        }else if(v.getId() == R.id.rel_drink){
            //음료 선택
            setAdapter(drink_list);
            selectTab(b.tvDrink, b.vDrink, texts, views);
        }else if(v.getId() == R.id.rel_dog){
            //독푸드 선택
            setAdapter(dog_list);
            selectTab(b.tvDog, b.vDog, texts, views);
        }else if(v.getId() == R.id.iv_basket){
            //CartActivity 이동
            Intent intent = new Intent(DeliveryActivity.this, CartActivity.class);
            startActivity(intent);
        }

    }

    // 가격 (int -> String)
    public String parsePrice(int price){
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(price)+"원";
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