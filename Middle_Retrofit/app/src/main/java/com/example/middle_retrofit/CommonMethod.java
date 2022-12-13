package com.example.middle_retrofit;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;

public class CommonMethod {
    private HashMap<String, Object> params = new HashMap<>();

    public void setParams(String key, String value){
        params.put(key, value);
    }

    public void getConn(String url, Callback<String> callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);

        Call<String> apiTest = apiInterface.getData(url, params);

        apiTest.enqueue(callback);
    }

}
