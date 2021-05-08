package com.example.motionevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class View3 extends AppCompatTextView {
    private String TAG = "View3";

    public View3(Context context) {
        super(context);
    }

    public View3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public View3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
