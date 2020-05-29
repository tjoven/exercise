package com.example.network.retrofit;

import com.example.network.retrofit.api.Entry;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ApiService {

//    @GET("{url}")
//    Call<Entry> getData(@Path("url") String url, @QueryMap Map<String,String> params);
    @GET("{url}")
    Call<Entry> getData(@Path("url") String url, @QueryMap Map<String, String> params);

}
