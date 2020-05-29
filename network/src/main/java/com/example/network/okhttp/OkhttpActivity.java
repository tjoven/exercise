package com.example.network.okhttp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


import com.example.network.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("tag  " + Thread.currentThread().getName());

                OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
                Request request = new Request.Builder().url("https://www.kuaidi100.com").build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        System.out.println("tag  " + Thread.currentThread().getName());
                    }
                });
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("tag  " + Thread.currentThread().getName());

                OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
                Request request = new Request.Builder().url("https://www.kuaidi100.com").build();
                Call call = okHttpClient.newCall(request);

                try {
                    Response response = call.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });



    }

}
