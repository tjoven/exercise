package com.example.tjoven.activity.thread;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by tjoven on 2018/5/5.
 */

public class Demo extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HandlerThreadDemo handlerThreadDemo = new HandlerThreadDemo("");
        handlerThreadDemo.start();
    }



}
