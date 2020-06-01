package com.example.thread;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    int index = 0;
    Lock  lock = new ReentrantLock();

    @Test
    public void play(){

        Executor executor = Executors.newFixedThreadPool(10);
        for (int i = 0;i < 10;i++){
            executor.execute(taskSync);//有同步锁
        }
    }


    Runnable taskSync = new Runnable() {
        @Override
        public void run() {

            lock.lock();

            index++;
            System.out.println(index);


            lock.unlock();

            System.out.println("@@@  "+index);


        }
    };
}
