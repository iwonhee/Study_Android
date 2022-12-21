package com.example.lastproject.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lastproject.R;
import com.example.lastproject.databinding.ActivityExamBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

public class ExamActivity extends AppCompatActivity {
    ActivityExamBinding b;
    private final String TAG = "logd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityExamBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        ApiClient.setBASEURL("http://192.168.0.115/middle/");

        //test1 요청
        b.btn1.setOnClickListener(v -> {    //lamda식 사용 유무 장단점 : 코드만 간결해짐
            new CommonMethod().sendPost("test1", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) { // data는 spring에서 return한 값
                    Log.d(TAG, isResult+" result: "+data);
                }
            });
        });
        //test2 요청
        b.btn2.setOnClickListener(v ->{
            new CommonMethod().setParams("id", "user1").setParams("pw", "password").setParams("admin", "Y")
                .sendPost("test2", new CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        if(isResult){
                            Log.d(TAG, "성공 : " + data);
                        }else{
                            Log.d(TAG, "실패 !! ");
                        }
                    }
                });
        });
        //test3 요청
        b.btn3.setOnClickListener(v ->{
            new CommonMethod().setParams("name", "원희").sendPost("test3", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) {
                    Log.d(TAG, "result: " + data);
                }
            });
        });

        //text4 요청
        b.btn4.setOnClickListener(v ->{
            new CommonMethod().sendPost("test4", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) {
                    TestVO vo = new Gson().fromJson(data, TestVO.class);

                    Log.d(TAG, "result: " + vo.getsVal());
                    Log.d(TAG, "result: " + vo.getiVal());
                    Log.d(TAG, "result: " + vo.getdVal());
                }
            });
        });

        //text5 요청
        b.btn5.setOnClickListener(v ->{
            new CommonMethod().setParams("no", "10").sendPost("test5", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) {
                    ArrayList<TestVO> list = new Gson().fromJson(data,
                            new TypeToken<ArrayList<TestVO>>(){}.getType()
                            );
                    Log.d(TAG, "result: "+ list.size());
                }
            });
        });

    }
}