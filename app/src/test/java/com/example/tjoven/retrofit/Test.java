package com.example.tjoven.retrofit;

import retrofit2.Retrofit;

public class Test {

    String baseUrl = "http://www.kuaidi100.com";

    public void test(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .build();
    }
}
