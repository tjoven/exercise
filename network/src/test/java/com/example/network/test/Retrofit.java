package com.example.network.test;

import com.example.network.retrofit.ApiService;
import com.example.network.retrofit.api.Entry;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Retrofit {
    public static void main(String[] args) {
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder().baseUrl("https://www.baicu.com")
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<Entry> call = apiService.getData("qu",new HashMap<String, String>());
        call.enqueue(new Callback<Entry>() {
            @Override
            public void onResponse(Call<Entry> call, Response<Entry> response) {

            }

            @Override
            public void onFailure(Call<Entry> call, Throwable t) {

            }
        });
    }
}
