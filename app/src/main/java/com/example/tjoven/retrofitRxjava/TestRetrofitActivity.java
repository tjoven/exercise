package com.example.tjoven.retrofitRxjava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tjoven.myapplication.R;
import com.example.tjoven.retrofitRxjava.api.Entry;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author tjoven
 * https://www.jianshu.com/p/7b839b7c5884
 *
 */
public class TestRetrofitActivity extends Activity {

    String baseUrl = "http://www.kuaidi100.com";

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_retrofit);
        textView =  (TextView)findViewById(R.id.textView);
    }

    public void request(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
       .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//为了使Rxjava与retrofit结合
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        HashMap<String,String> params = new HashMap<>();
        params.put("type","yuantong");
        params.put("postid","11111111111");
        Observable<Entry> observable = apiService.getData("query",params);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Entry>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Entry response) {
                        textView.setText(response.getData().toString());
                    }
                });
//        Call<Entry> call = apiService.getData("query",params);
//        call.enqueue(new Callback<Entry>() {
//            @Override
//            public void onResponse(Call<Entry> call, Response<Entry> response) {
//                textView.setText(response.body().getData().toString());
//            }
//
//            @Override
//            public void onFailure(Call<Entry> call, Throwable t) {
//
//            }
//        });
    }
}
