package com.example.tjoven.plugin;

import android.os.Bundle;

/**
 * Created by tjoven on 2017/10/8.
 */
public interface DLPlugin {
    void onCreate(Bundle saveInstanceState);
    void onResume();
}
