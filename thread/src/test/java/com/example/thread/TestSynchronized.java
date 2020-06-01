package com.example.thread;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestSynchronized {

    private byte[] BYTE = new byte[10];
    int index = 0;
    @Test
    public void play(){
        Executor executor = Executors.newFixedThreadPool(10);

        for (int i = 0;i < 10;i++){
            executor.execute(taskSync);//有同步锁
//            executor.execute(task);//没有同步锁
        }
    }

    Runnable taskSync = new Runnable() {
        @Override
        public void run() {
            synchronized (BYTE){
                index++;
                System.out.println(index);
            }
            System.out.println("@@@@@@@@@@@@@@@@@"+index);

        }
    };

    Runnable task = new Runnable() {
        @Override
        public void run() {
            index++;
            System.out.println(index);

        }
    };
}
