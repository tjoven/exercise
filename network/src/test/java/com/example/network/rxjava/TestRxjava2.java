package com.example.network.rxjava;


import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 研究 线程切换
 */
public class TestRxjava2 {
    private final static String TAG =  "TestRxjava";

    @Test
    public void play() {

        System.out.println( "TestRxjava2 所在线程为 :" + Thread.currentThread().getName());
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                System.out.println( "subscribe 所在线程为 :" + Thread.currentThread().getName());
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())//被观察者 线程
//                .observeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.computation())
                .subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println( "onSubscribe 所在线程为 :" + Thread.currentThread().getName());
                System.out.println("onSubscribe");

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println( "onNext 所在线程为 :" + Thread.currentThread().getName());
                System.out.println("onNext "+integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println( "onComplete 所在线程为 :" + Thread.currentThread().getName());
                System.out.println("onComplete");
            }
        });
    }
}
