package com.example.tjoven.binderPool;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.tjoven.aidl.IBinderPool;
import com.example.tjoven.aidl.ISecurityCenter;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tjoven on 2018/8/15.
 */

public class BinderPool {

    private final static String TAG = "BinderPool@@@@";

    public final static int SECURITYCENTER = 1;
    public final static int COMPUTE = 2;

    private Context mContext;
    private static BinderPool instance;
    private IBinderPool pool;
    private CountDownLatch downLatch;

    private BinderPool(Context mContext) {
        this.mContext = mContext;
        bindService(mContext);
    }

    public static BinderPool getInstance(Context context){
        if(instance != null){
           return instance;
        }
        synchronized (new byte[1]){
            instance =new BinderPool(context);
        }
        return instance;
    }

    private void bindService(Context mContext) {
        Log.d(TAG,"bindService"  + "  Thread Id" + Thread.currentThread().getId());
        downLatch = new CountDownLatch(1);
        Intent intent = new Intent(mContext,BinderPoolService.class);
        mContext.bindService(intent,connection,Context.BIND_AUTO_CREATE);
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG,"bindService  OK");
    }

    //当前线程
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG,"onServiceConnected" + "  Thread Id:" + Thread.currentThread().getId());
            pool = IBinderPool.Stub.asInterface(service);
            downLatch.countDown();
            Log.d(TAG,"pool " + pool.toString());



        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public IBinder queryBinder(int code){
        Log.d(TAG,"queryBinder" + "  Thread Id:" + Thread.currentThread().getId());

        IBinder binder = null;
        try {
            binder = pool.queryBinder(code);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return binder;
    }

    static class BinderPoolImpl extends IBinderPool.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public IBinder queryBinder(int code) throws RemoteException {
            IBinder binder = null;
            switch (code){
                case SECURITYCENTER:
                    binder = new SecurityCenterImpl();
                    break;
                case COMPUTE:
                    binder = new ComputeImpl();
                    break;
            }
            return binder;
        }
    }
}
