package com.example.tjoven.retrofitRxjava;

import com.example.tjoven.retrofitRxjava.api.Entry;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface ApiService {

//    @GET("{url}")
//    Call<Entry> getData(@Path("url") String url, @QueryMap Map<String,String> params);
    @GET("{url}")
    Observable<Entry> getData(@Path("url") String url, @QueryMap Map<String,String> params);

}
