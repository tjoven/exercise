package com.example.tjoven.aidl.situation1;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.tjoven.aidl.Book;
import com.example.tjoven.aidl.IBookManager;
import com.example.tjoven.aidl.IOnAddNewBookListener;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by tjoven on 2018/8/14.
 */

public class AIDLService extends Service {
    //线程同步问题
    CopyOnWriteArrayList<Book> bookList = new CopyOnWriteArrayList<>();

    public static final String TAG = "AIDLService";

    @Override
    public void onCreate() {
        super.onCreate();
        Book book1 = new Book(1,"Android");
        Book book2 = new Book(2,"IOS");
        bookList.add(book1);
        bookList.add(book2);

        int pid = android.os.Process.myPid();
        Log.d(TAG, "pid  " + pid);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    Binder binder = new IBookManager.Stub(){
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            return bookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            bookList.add(book);
        }

        @Override
        public void registerLisener(IOnAddNewBookListener listener) throws RemoteException {

        }

        @Override
        public void unregisterLisener(IOnAddNewBookListener listener) throws RemoteException {

        }
    };

}
