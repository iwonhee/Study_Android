package com.example.project_burgerking.membership;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_burgerking.R;

public class MemberActivity extends AppCompatActivity {
    ImageView iv_member_rank_detail, iv_member_back;
    CardView card_member_welcome, card_member_junior, card_member_whopper, card_member_king;
    TextView tv_select_welcome, tv_select_junior, tv_select_whopper, tv_select_king;
    View v_rank_welcome, v_rank_junior, v_rank_whopper, v_rank_king;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        getSupportActionBar().hide();

        card_member_welcome = findViewById(R.id.card_member_welcome);
        card_member_junior = findViewById(R.id.card_member_junior);
        card_member_whopper = findViewById(R.id.card_member_whopper);
        card_member_king = findViewById(R.id.card_member_king);

        tv_select_welcome = findViewById(R.id.tv_select_welcome);
        tv_select_junior = findViewById(R.id.tv_select_junior);
        tv_select_whopper = findViewById(R.id.tv_select_whopper);
        tv_select_king = findViewById(R.id.tv_select_king);

        v_rank_welcome = findViewById(R.id.v_rank_welcome);
        v_rank_junior = findViewById(R.id.v_rank_junior);
        v_rank_whopper = findViewById(R.id.v_rank_whopper);
        v_rank_king = findViewById(R.id.v_rank_king);

        iv_member_back = findViewById(R.id.iv_member_back);
        iv_member_rank_detail = findViewById(R.id.iv_member_rank_detail);
        iv_member_rank_detail.setImageResource(R.drawable.m_rank_whopper);

        CardView[] cards = {
                card_member_welcome, card_member_junior, card_member_whopper, card_member_king
        };
        TextView[] texts = {
                tv_select_welcome, tv_select_junior, tv_select_whopper, tv_select_king
        };
        View[] views = {
                v_rank_welcome, v_rank_junior, v_rank_whopper, v_rank_king
        };

        //welcome 등급
        card_member_welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unselectCard(cards, texts, views);
                selectRank(iv_member_rank_detail, card_member_welcome, tv_select_welcome, v_rank_welcome);
            }
        });
        card_member_junior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unselectCard(cards, texts, views);
                selectRank(iv_member_rank_detail, card_member_junior, tv_select_junior, v_rank_junior);
            }
        });
        card_member_whopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unselectCard(cards, texts, views);
                selectRank(iv_member_rank_detail, card_member_whopper, tv_select_whopper, v_rank_whopper);
            }
        });
        card_member_king.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unselectCard(cards, texts, views);
                selectRank(iv_member_rank_detail, card_member_king, tv_select_king, v_rank_king);
            }
        });
        

//        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MembershipFragment()).commit();

    }

    // 탭 선택
    public void selectRank(ImageView detail, CardView cardview, TextView title, View underline){
        if(title.getText().equals("WELCOME")){
            detail.setImageResource(R.drawable.m_rank_welcome);
        }else if(title.getText().equals("JUNIOR")){
            detail.setImageResource(R.drawable.m_rank_junior);
        }else if(title.getText().equals("WHOPPER")){
            detail.setImageResource(R.drawable.m_rank_whopper);
        }else if(title.getText().equals("KING")){
            detail.setImageResource(R.drawable.m_rank_king);
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