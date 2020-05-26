package com.example.tjoven.binderPool;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tjoven.aidl.ICompute;
import com.example.tjoven.aidl.ISecurityCenter;
import com.example.tjoven.myapplication.R;

public class BinderPoolActivity extends Activity {

    private final static String TAG = "BinderPoolActivity";
    BinderPool pool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder_pool);
        Log.d(TAG,"onCreate"  + "  Thread Id" + Thread.currentThread().getId());
        bindListener();
    }

    private void initPool() {
        /**
         *  为什么要开线程？
         *  binderService是异步操作，返回IBinder的时间受Server控制
         *  所以为了 防止出现空指针的情况 使用 CountDownLatch 异步变同步
         *  await 当先线程 暂停，
         *  因为ServiceConnection 是在主线程，所以await 必须在work线程。如果await也在主线程的话，因为ServiceConnection也处于暂停状态，无法接收IBinder
         *  所以新建work线程，binderService 然后 await，等待ServiceConnection 在主线程将其唤醒
         */

        /**
         * CountDownLatch 官方解释：一个线程暂停，另外一个线程唤醒
         */
    }

    private void bindListener() {
        findViewById(R.id.entry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        pool = BinderPool.getInstance(BinderPoolActivity.this);
                        Log.d(TAG,"Thread"  + "  Thread Id" + Thread.currentThread().getId());
                        IBinder binder = pool.queryBinder(BinderPool.SECURITYCENTER);
                        ISecurityCenter securityCenter = SecurityCenterImpl.asInterface(binder);
                        try {
                            String result = securityCenter.encrypt("aa");
                            Log.d(TAG,"entry " + result);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


            }
        });

        findViewById(R.id.compute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        pool = BinderPool.getInstance(BinderPoolActivity.this);
                        IBinder binder =pool.queryBinder(BinderPool.COMPUTE);
                        ICompute compute = ComputeImpl.asInterface(binder);
                        try {
                            int result = compute.compute(12,43);
                            Log.d(TAG,"compute "+ result);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
}
