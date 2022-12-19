package com.example.lastproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 팀프로젝트 할때 자기것으로 바꾸기
        ApiClient.setBASEURL("http://192.168.0.115/middle/");

        new CommonMethod().setParams("data", "lastTest")
                .sendGet("andVO", new CommonMethod.CallBackResult() {
            @Override
            public void result(boolean isResult, String data) {
                if(isResult){
                    Log.d("log", "result: " + data);
                }
            }
        });
    }
}