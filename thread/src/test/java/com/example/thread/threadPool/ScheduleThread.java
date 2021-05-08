package com.example.thread.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThread {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("main "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },1,2, TimeUnit.SECONDS);
    }
}
