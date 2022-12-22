package com.example.lastproject.customer;

import android.util.Log;

import com.example.conn.CommonMethod;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CustomerDAO {
//    private final String TAG = "logd";

    //DAO <= 안드로이드 DAO는 공통 모듈로 이미 만들어뒀음 => CommonMethod
    // 공통으로 사용될 메소드들을 따로 추가하거나 사용할수있게만 만들면 된다.

//    public List<CustomerVO> selectList(){
//        AtomicReference<List<CustomerVO>> list = null;
//        new CommonMethod().sendPost("select.cu", ((isResult, data) -> {
//            Log.d(TAG, "onCreate: " + data);
//
//            list.set(new Gson().fromJson(data, new TypeToken<ArrayList<CustomerVO>>() {
//            }.getType()));
//
//
//        }));
//        return list.get();
//    }


}
