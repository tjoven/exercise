package com.example.motionevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    static MainActivity.Person data;
    public static void setData(MainActivity.Person person){
        data = person;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ((TextView)findViewById(R.id.tv)).setText(data.name);
    }
}
