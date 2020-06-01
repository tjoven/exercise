package com.example.thread;

import org.junit.Test;

import java.util.concurrent.Executor;

public class TestNotify {

    private byte[] BYTE = new byte[10];
    int index = 0;

    @Test
    public void play(){
        new Thread(task2).start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(task1).start();
    }

    Runnable task1 = new Runnable() {
        @Override
        public  void run() {
                while (true){
                    synchronized (task2){
                        index++;
                        System.out.println(index + Thread.currentThread().getName());
                        if(index > 5){
                            task2.notify();
                            return;
                        }

                }
            }

        }
    };

    Runnable task2 = new Runnable() {
        @Override
        public synchronized void run() {
                try {
                    while (index < 10){

                        wait();
                        index++;
                        System.out.println(index + Thread.currentThread().getName()+"@@");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
    };
}
