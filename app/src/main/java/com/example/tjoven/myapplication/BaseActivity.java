package com.example.tjoven.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("tzw",getLocalClassName()+".TaskId="+String.valueOf(getTaskId()));
    }

//    protected abstract void onBindLinstener();
//    protected abstract void initView();

}
