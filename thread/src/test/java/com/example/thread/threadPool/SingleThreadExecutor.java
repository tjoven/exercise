package com.example.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0 ;i < 10;i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("main "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
