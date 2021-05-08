package com.example.network.rxjava;


import android.util.Log;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 研究 订阅过程
 */
public class TestRxjava {
    private final static String TAG =  "TestRxjava";

    @Test
    public void play() {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                System.out.println("subscribe");
                System.out.println("m1");
                emitter.onNext(1);
                System.out.println("m2");
                emitter.onNext(2);
                System.out.println("m3");
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");

            }

            @Override
            public void onNext(Integer integer) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("onNext "+integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}
