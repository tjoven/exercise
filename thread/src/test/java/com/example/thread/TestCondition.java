package com.example.thread;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *两个线程循环交替  执行
 */
public class TestCondition {

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition condition2 = lock.newCondition();
    int flag = 0;
    int count = 0;
    int MAX = 10;
    @Test
    public void play(){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (count < MAX){
                    lock.lock();
                    while (flag != 0){
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag ++;
                    count ++;
                    System.out.println(count +" runnable A");
                    condition2.signal();
                    lock.unlock();
                }



            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                while (count < MAX){
                    lock.lock();
                    while (flag != 1){
                        try {
                            condition2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag --;
                    count ++;
                    System.out.println(count +" runnable B");
                    condition.signal();
                    lock.unlock();
                }



            }
        };

        Thread thread1 = new Thread(runnable,"Thread1");
        thread1.start();

        Thread thread2 = new Thread(runnable2,"Thread2");
        thread2.start();


    }

}
