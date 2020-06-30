package com.example.leak;

import android.content.Context;
import android.widget.TextView;

public class TestDataModel {

    private static TestDataModel sInstance;
    private static TextView mRetainedTextView;
    private static Context mContext;

    public static TestDataModel getInstance(Context context) {
        mContext = context;
        if (sInstance == null) {
            sInstance = new TestDataModel();
        }
        return sInstance;
    }

    public void setRetainedTextView(TextView textView) {
        mRetainedTextView = textView;
    }
}