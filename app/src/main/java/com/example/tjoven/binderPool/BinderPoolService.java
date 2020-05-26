package com.example.tjoven.binderPool;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.tjoven.aidl.IBinderPool;

public class BinderPoolService extends Service {


    public BinderPoolService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new BinderPool.BinderPoolImpl();
    }
}
