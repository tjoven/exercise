package com.example.thread;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class DeathLock {

    @Test
    public void test(){
        final ReentrantLock lock1 = new ReentrantLock();
        final ReentrantLock lock2 = new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {

                lock1.lock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock2.lock();
                System.out.println("Thread 1");
                lock2.unlock();
                lock1.unlock();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                lock2.lock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock1.lock();
                System.out.println("Thread 2");
                lock1.unlock();
                lock2.unlock();
            }
        }).start();
    }

    public static void main(String[] args) {
        final Object obj1 = new Object();
        final Object obj2 = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(obj1){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj2){
                        System.out.println("Thread 1");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(obj2){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj1){
                        System.out.println("Thread 2");
                    }
                }
            }
        }).start();

    }
}
