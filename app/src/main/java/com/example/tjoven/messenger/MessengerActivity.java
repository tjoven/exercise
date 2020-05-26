package com.example.tjoven.messenger;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;

import com.example.tjoven.myapplication.R;

import static java.lang.System.out;

public class MessengerActivity extends Activity {
    public static final int HELLO = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MessengerActivity.this,MessengerService.class);
                bindService(intent,connection, Context.BIND_AUTO_CREATE);
            }
        });
    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Messenger messenger = new Messenger(service);
            Message msg = new Message();
            msg.what = MessengerService.HELLO;
            Bundle bundle = new Bundle();
            bundle.putString("msg","client say hello");
            msg.setData(bundle);

            Messenger messengerC = new Messenger(new ClientMessengerHandler());
            msg.replyTo = messengerC;
            try {
                messenger.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    static class ClientMessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MessengerService.FROMSERVER:
                    out.println("From Server" + msg.getData().toString());
            }
        }
    }
}
