package com.example.project01_clone.friendlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project01_clone.MainActivity;
import com.example.project01_clone.R;
import com.example.project01_clone.friendlist.DetailActivity;

import java.util.Random;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView iv_profile_detail, iv_background, iv_close_detail;
    TextView tv_profile_name, tv_profile_msg;
    LinearLayout lin_menu1, lin_menu2, lin_menu3;
    int[] imgArr = {
        R.drawable.background1,
        R.drawable.background2,
        R.drawable.background3,
        R.drawable.background4,
        R.drawable.background5,
        R.drawable.background6,
        R.drawable.background7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();   // 액션바 가져와서 안보이게 처리

        iv_background = findViewById(R.id.iv_background);
        iv_profile_detail = findViewById(R.id.iv_profile_detail);
        tv_profile_name = findViewById(R.id.tv_profile_name);
        tv_profile_msg = findViewById(R.id.tv_profile_msg);
        iv_close_detail = findViewById(R.id.iv_close_detail);
        lin_menu1 = findViewById(R.id.lin_menu1);
        lin_menu2 = findViewById(R.id.lin_menu2);
        lin_menu3 = findViewById(R.id.lin_menu3);

        // 인텐트로 보낸 정보 담기
        Intent intent = getIntent();
        FriendDTO dto = (FriendDTO) intent.getSerializableExtra("dto");
        iv_profile_detail.setImageResource(dto.getImgRes());
        tv_profile_name.setText(dto.getName());
        tv_profile_msg.setText(dto.getMsg());

        // 배경이미지 랜덤으로
        iv_background.setImageResource(imgArr[new Random().nextInt(imgArr.length)]);

        // 버튼 클릭
        lin_menu1.setOnClickListener(this);
        lin_menu2.setOnClickListener(this);
        lin_menu3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // Intent <= 컴포넌트들간의 통신을 맡고 있는 객체 ( 액티비티 )
        // 1. 명시적 인텐트 : 우리가 만든 클래스 내부에서 사용하고 통제가 가능
        // ( Intent intent = new Intent ( 현재위치(Context), 다음 띄울 액티비티.class )
        // startActivity 로 끝남

        // 2. 묵시적(암시적) 인텐트 : 직접 만든게 아니라, OS나 다른 외부에서 제공하는 기능과 통신(호출) 할때 사용
        // 직접 만든게 아니므로 어떤 결과가 나올지 모름
        // ex) 인터넷연결, 전화연결, 카메라, 갤러리, 맵.. 등

        Intent intent = null;

        if( v.getId() == R.id.lin_menu1 ){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));   //인터넷 연결

        }else if( v.getId() == R.id.lin_menu2 ){
            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01075232141"));

        }else if( v.getId() == R.id.lin_menu3 ){
            // Google 에 검색해서 한가지 Intent 액션 넣어보기
            intent = new Intent(Intent.ACTION_WEB_SEARCH, Uri.parse("And")); // 실패
        }
        startActivity(intent);
    }
}