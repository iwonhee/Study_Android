package com.example.lastproject.customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lastproject.R;
import com.example.lastproject.databinding.ActivityCustomerBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class CustomerActivity extends AppCompatActivity {
    private final String TAG = "logd";
    ActivityCustomerBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityCustomerBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        ApiClient.setBASEURL("http://192.168.0.115/middle/");

        selectList();

    }

    public void selectList(){
        new CommonMethod().sendPost("select.cu", (isResult, data) -> {
            Log.d(TAG, "onCreate: " + data);

            ArrayList<CustomerVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CustomerVO>>(){}.getType());

            //비동기 영역 (최대 10초 후에 실행될 수도 있음)
            //데이터가 있어야 할수있는 처리는 모두 이 영역에서
            b.recvSelect.setAdapter(new CuAdapter(list, getLayoutInflater(), CustomerActivity.this));
            b.recvSelect.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        });
    }

}