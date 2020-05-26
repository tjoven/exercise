package com.example.motionevent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class View2 extends FrameLayout {
    private String TAG = "View2";

    public View2(@NonNull Context context) {
        super(context);
    }

    public View2(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public View2(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG,"dispatchTouchEvent"+"  "+event.getActionMasked() );
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG,"onTouchEvent"+"  "+event.getActionMasked());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Log.d(TAG,"onInterceptTouchEvent"+"  "+event.getActionMasked());
        return super.onInterceptTouchEvent(event);
    }
}
