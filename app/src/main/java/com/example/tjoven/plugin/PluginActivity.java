package com.example.tjoven.plugin;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class PluginActivity extends Activity implements DLPlugin{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("tag","PluginActivity:onCreate");

    }
    public void onResume(){
        super.onResume();
    }
}
