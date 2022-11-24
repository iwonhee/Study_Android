package com.example.and08_activityintent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NoneContext {

    LayoutInflater inflater;
    String str;

    public NoneContext(LayoutInflater inflater, String str){
        this.inflater = inflater;
        this.str = str;
    }
    public void method1(){
        if(inflater==null){
            Log.d("inf", "inflater: null");
        }else{
            Log.d("inf", "inflater: not null");
        }

        if(str==null){
            Log.d("inf", "str: null");
        }else{
            Log.d("inf", "str: not null");
        }
    }
    public void showToast(MainActivity ma){
        // 토스트 메세지 띄워보기
        Toast.makeText(ma, "showToast", Toast.LENGTH_SHORT).show();
    }
    public void v1Setting(View v2){
        TextView tv_sub1 = v2.findViewById(R.id.tv_sub2);
        tv_sub1.setText("바뀐글씨바뀐글씨바뀐글씨바뀐글씨바뀐글씨바뀐글씨바뀐글씨바뀐글씨");
        Button btn_sub1 = v2.findViewById(R.id.btn_sub2);
        btn_sub1.setText("바뀐 버튼 글씨");
    }

}
