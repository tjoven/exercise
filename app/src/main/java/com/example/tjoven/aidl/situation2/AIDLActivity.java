package com.example.tjoven.aidl.situation2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.example.tjoven.aidl.Book;
import com.example.tjoven.aidl.IBookManager;
import com.example.tjoven.aidl.IOnAddNewBookListener;
import com.example.tjoven.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * register and unregister
 */
public class AIDLActivity extends Activity implements View.OnClickListener{

    IBookManager manager;

    public static final String TAG = "AIDLActivity";
    private boolean ServiceOnConnect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        bindListener();


    }

    private void bindListener() {
        findViewById(R.id.bindService).setOnClickListener(this);
        findViewById(R.id.unbindServer).setOnClickListener(this);
        findViewById(R.id.getBook).setOnClickListener(this);
        findViewById(R.id.addBook).setOnClickListener(this);
        findViewById(R.id.register).setOnClickListener(this);
        findViewById(R.id.unregister).setOnClickListener(this);
    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            manager = IBookManager.Stub.asInterface(service);
            Log.d(TAG,"onServiceConnected");
            ServiceOnConnect = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG,"onServiceDisconnected");
            ServiceOnConnect = false;
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bindService:
                Intent intent = new Intent();
                intent.setClass(AIDLActivity.this,AIDLService.class);
                bindService(intent,connection, Context.BIND_AUTO_CREATE);

                int pid =android.os.Process.myPid();
                Log.d(TAG, "pid  " + pid);
                break;
            case R.id.unbindServer:
                // 多次解绑 异常
                unbindService(connection);
                break;
            case R.id.getBook:
                // RPC 如果是耗时操作，建议在工作线程进行RPC
                if(manager == null){
                    return;
                }
                List<Book> data = new ArrayList<>();
                try {
                    data = manager.getBookList();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                Log.d(TAG,"获取server数据"+data.size()+"本书");
                break;
            case R.id.addBook:
                if(manager == null){
                    return;
                }
                try {
                    manager.addBook(new Book(3,"Python"));
                    Log.d(TAG,"add书籍"+manager.getBookList().size());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.register:
                if(manager == null){
                    return;
                }
                try {
                    manager.registerLisener(listener);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.unregister:
                if(manager == null){
                    return;
                }
                try {
                    manager.unregisterLisener(listener);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

                break;
            default:
                break;
        }
    }

    //AIDL 中不能使用普通接口
    IOnAddNewBookListener listener = new IOnAddNewBookListener.Stub(){

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void onAddNewBookListener(Book book) throws RemoteException {
            // 在binder线程池中，如果要更新UI 需要切换线程
            Log.d(TAG,"有新书到达  "+book.bookName);
        }
    };

    @Override
    protected void onDestroy() {
        if(ServiceOnConnect){
            unbindService(connection);
        }
        super.onDestroy();
    }
}
