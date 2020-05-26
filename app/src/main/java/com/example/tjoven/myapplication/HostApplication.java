package com.example.tjoven.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by tjoven on 2017/10/8.
 */
public class HostApplication extends Application{

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = new CrashHandler();
        crashHandler.init();
    }
}
