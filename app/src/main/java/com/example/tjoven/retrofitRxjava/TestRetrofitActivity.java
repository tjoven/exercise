package com.example.tjoven.retrofitRxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tjoven.myapplication.R;
import com.example.tjoven.retrofitRxjava.api.Entry;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

    private String TAG = "TestRetrofitActivity";
    String baseUrl = "http://www.kuaidi100.com";

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_retrofit);
        textView =  (TextView)findViewById(R.id.textView);
        button =  (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request(view);
            }
        });
    }


    private void request(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        HashMap<String,String> params = new HashMap<>();
        params.put("type","yuantong");
        params.put("postid","11111111111");

        Call<Entry> call = apiService.getData("query",params);
        call.enqueue(new Callback<Entry>() {
            @Override
            public void onResponse(Call<Entry> call, Response<Entry> response) {
                Log.d(TAG,"onResponse");
                textView.setText(response.body().getData().toString());
            }

            @Override
            public void onFailure(Call<Entry> call, Throwable t) {
                Log.d(TAG,"onFailure "+ t.toString());

            }
        });
    }
}
