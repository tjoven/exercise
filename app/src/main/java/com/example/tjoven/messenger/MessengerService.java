package com.example.tjoven.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import static java.lang.System.out;

public class MessengerService extends Service {
    public static final int HELLO = 11;
    public static final int FROMSERVER = 22;

    private Messenger mMessenger = new Messenger(new MessengerHandler());

    public MessengerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    static class MessengerHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case HELLO:
                    out.println("From Client" + msg.getData().toString());
                    sendClient(msg);

            }
        }

        private void sendClient(Message message) {
            Messenger messenger = message.replyTo;
            Message msg = new Message();
            msg.what = MessengerService.FROMSERVER;
            Bundle bundle = new Bundle();
            bundle.putString("msg","server say im ok");
            message.setData(bundle);
            try {
                messenger.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
