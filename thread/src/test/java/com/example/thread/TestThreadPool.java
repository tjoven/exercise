package com.example.thread;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestThreadPool {

    @Test
    public void play(){

        System.out.println("tag "+Thread.currentThread().getName());

        ThreadPoolExecutor cache = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        cache.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("tag "+Thread.currentThread().getName());
            }
        });
    }
}
