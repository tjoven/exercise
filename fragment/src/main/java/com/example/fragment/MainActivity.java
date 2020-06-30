package com.example.fragment;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    private static final String TAT = "MainActivity";

    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAT,"onCreate");
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();

        init();
        onBind();


    }

    private void onBind() {
        findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction  transaction = manager.beginTransaction();
                MainFragment mainFragment = (MainFragment) manager.findFragmentByTag("main");
                if(mainFragment != null){
                    transaction.remove(mainFragment);
                    transaction.commit();
                }

            }
        });

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });

        findViewById(R.id.replace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment fragment = new SecondFragment();
                MainFragment mainFragment = new MainFragment();
                FragmentTransaction  transaction = manager.beginTransaction();
                if(manager.findFragmentByTag("second") == null){
                    FragmentTransaction add = transaction.replace(R.id.fragment, fragment, "second");
                    add.commit();
                }else if(manager.findFragmentByTag("main") == null){
                    FragmentTransaction add = transaction.replace(R.id.fragment, mainFragment, "main");
                    add.commit();
                }


            }
        });

        findViewById(R.id.hide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction  transaction = manager.beginTransaction();
                MainFragment mainFragment = (MainFragment) manager.findFragmentByTag("main");
                if(mainFragment != null){
                    transaction.hide(mainFragment);
                    transaction.commit();
                }
            }
        });

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction  transaction = manager.beginTransaction();
                MainFragment mainFragment = (MainFragment) manager.findFragmentByTag("main");
                if(mainFragment != null){
                    transaction.show(mainFragment);
                    transaction.commit();
                }
            }
        });

        findViewById(R.id.stack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction  transaction = manager.beginTransaction();
                MainFragment mainFragment = (MainFragment) manager.findFragmentByTag("main");
                if(mainFragment != null){
                    transaction.remove(mainFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }

    private void init() {
        FragmentTransaction  transaction = manager.beginTransaction();
        MainFragment mainFragment = (MainFragment) manager.findFragmentByTag("main");
        if( mainFragment == null){
            mainFragment = new MainFragment();
            FragmentTransaction add = transaction.add(R.id.fragment, mainFragment, "main");
            add.commit();
        }else {
            transaction.show(mainFragment).commit();
        }

    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAT,"onAttachedToWindow");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAT,"onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAT,"onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAT,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAT,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAT,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAT,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAT,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAT,"onDestroy");
    }
}

