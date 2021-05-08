package com.example.network.test;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class Okhttp {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient.Builder()
                .eventListenerFactory(HttpEventListener.FACTORY)
                .build();


        okhttp(client);


    }

    private static void okhttp(OkHttpClient client) {

        Request request = new Request.Builder().url("https://www.kuaidi100.com")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("tag  " +"222");
                System.out.println("tag  " + Thread.currentThread().getName());
                System.out.println("tag  " +response.body().string());
            }
        });
    }
}
