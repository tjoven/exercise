package com.example.tjoven.binderPool;

import android.os.RemoteException;

import com.example.tjoven.aidl.ICompute;

/**
 * Created by tjoven on 2018/8/15.
 */

public class ComputeImpl extends ICompute.Stub{
    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public int compute(int a, int b) throws RemoteException {
        return a + b;
    }
}
