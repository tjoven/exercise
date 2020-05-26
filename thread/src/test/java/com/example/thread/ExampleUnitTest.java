package com.example.thread;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test(){
        System.out.println("main thread "+Thread.currentThread().getName());
        new MyThread().start();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    class MyThread extends Thread{
        @Override
        public void run() {
           System.out.println("work thread "+Thread.currentThread().getName());
        }
    }
}