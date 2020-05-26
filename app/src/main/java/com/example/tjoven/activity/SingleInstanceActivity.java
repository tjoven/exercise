package com.example.tjoven.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tjoven.myapplication.BaseActivity;
import com.example.tjoven.myapplication.R;

public class SingleInstanceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        initView();
    }

    private void initView() {
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SingleInstanceActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
