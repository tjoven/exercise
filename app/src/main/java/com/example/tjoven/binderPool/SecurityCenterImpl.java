package com.example.tjoven.binderPool;

import android.os.RemoteException;

import com.example.tjoven.aidl.ISecurityCenter;

/**
 * Created by tjoven on 2018/8/15.
 */

public class SecurityCenterImpl extends ISecurityCenter.Stub {
    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public String encrypt(String content) throws RemoteException {
        return "encrypt";
    }

    @Override
    public String decrypt(String password) throws RemoteException {
        return "decrypt";
    }
}
