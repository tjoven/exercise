package com.example.tjoven.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tjoven.adapter.MainAdapter;
import com.example.tjoven.myapplication.BaseActivity;
import com.example.tjoven.myapplication.R;
import com.example.tjoven.retrofitRxjava.TestRetrofitActivity;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private Button button;
    private RecyclerView.Adapter adapter;
    private ArrayList<MainEntry> list = new ArrayList<>();


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        onBindLinstener();

    }

    protected void onBindLinstener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TestRetrofitActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.list_view);
        button = (Button) findViewById(R.id.button);
        setData();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new MainAdapter(this,list);
        recyclerView.setAdapter(adapter);
    }

    private void setData() {

        list.add(new MainEntry("com.example.tjoven.retrofitRxjava.TestRetrofitActivity","TestRetrofitActivity"));
//        list.add("com.example.tjoven.mvp.demo.activity.TestMVPActivity");
//        list.add("03");
//        list.add("04");
//        list.add("05");

    }

    public class MainEntry{
        public MainEntry(String path, String name) {
            this.path = path;
            this.name = name;
        }

        public String path;
        public String name;
    }

}
