package com.example.project_burgerking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;

import com.example.project_burgerking.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityLoginBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        b = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        // EditText 값 입력시 x 버튼 나오게
        b.edtId.addTextChangedListener(getTextWatcher(b.ivClearId));
        b.edtPw.addTextChangedListener(getTextWatcher(b.ivClearPw));

        // x 누르면 입력한 값 지우기
        b.ivClearId.setOnClickListener(this);
        b.ivClearPw.setOnClickListener(this);

        // 뒤로가기
        b.ivBack.setOnClickListener(this);

    }//

    // 클릭 이벤트
    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.iv_clear_id){
            //아이디 지우기
            b.edtId.setText("");
        }else if(v.getId() == R.id.iv_clear_pw){
            //비밀번호 지우기
            b.edtPw.setText("");
        }else if(v.getId() == R.id.iv_back){
            //뒤로가기 : 메인액티비티
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    // TextWatcher 재사용
    public TextWatcher getTextWatcher(ImageView close){
        TextWatcher tw = new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //입력 전
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //입력칸 변화시
                if(s.toString().equals("")){
                    //값 없을때
                    close.setVisibility(View.GONE);
                }else{
                    //값 입력시
                    close.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //입력 끝난 후
           }
        };
        return tw;
    }
}