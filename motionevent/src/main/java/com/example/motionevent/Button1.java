package com.example.motionevent;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class Button1 extends android.support.v7.widget.AppCompatButton {

    private String TAG = "Button1";

    public Button1(Context context) {
        super(context);
    }

    public Button1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Button1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG,"dispatchTouchEvent"+"  "+event.getActionMasked());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG,"onTouchEvent"+"  "+event.getActionMasked());
        return super.onTouchEvent(event);
    }


}
