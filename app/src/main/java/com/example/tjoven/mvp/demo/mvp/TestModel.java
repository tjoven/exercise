package com.example.tjoven.mvp.demo.mvp;

import android.content.Context;

import com.example.tjoven.mvp.IDataSource;
import com.example.tjoven.mvp.demo.api.TestResponse;

public class TestModel implements IDataSource {
    Context mContext;

    String id;
    public TestModel(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void sendRequest(IDataSourceListener listener) {
        TestResponse response = new TestResponse();
        response.result = "ok:" + id;
        listener.onData(response);
    }

    public void setParams(String id){
        this.id = id;
    }
}
