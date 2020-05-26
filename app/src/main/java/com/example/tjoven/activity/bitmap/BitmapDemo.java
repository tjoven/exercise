package com.example.tjoven.activity.bitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.LruCache;
import android.widget.ImageView;

/**
 * Created by tjoven on 2018/5/6.
 */

public class BitmapDemo extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;//采样率：图片的缩放比例
        options.inJustDecodeBounds = true;// 解析 宽/高 信息，但不会加载view
        ImageView imageView = new ImageView(this);

        LruCache<String,String> cache = new LruCache<String, String>(100);
        Runtime.getRuntime().maxMemory();//当前心线程，可用的最大内存

    }
}
