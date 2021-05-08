package com.example.imageloader.glide;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.example.imageloader.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button,buttonGif,bt_quiet;
    String url= "https://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
    String urlGIF= "https://p1.pstatp.com/large/166200019850062839d3";

    RequestOptions options = new RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            //缓存策略
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
        button = findViewById(R.id.button);
        buttonGif = findViewById(R.id.buttonGif);
        bt_quiet = findViewById(R.id.bt_quiet);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageLoader(v,url);
            }
        });

        buttonGif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageLoader(v,urlGIF);
            }
        });

        bt_quiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageLoaderQuiet(v,urlGIF);
            }
        });


    }

    private void imageLoaderQuiet(View v,String pathurl) {
//        Glide.with(this).load(url).into(imageView);

        Glide.with(this)
                .asBitmap()
                .load(pathurl)
                .apply(options)
                .into(new  SimpleTarget<Bitmap>(){

                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {

                    }
                }

        );
//                .into(imageView);

    }

    private void imageLoader(View v,String pathurl) {

        Glide.with(this)
                .load(pathurl)
              .apply(options)
              .into(imageView);

    }
}
