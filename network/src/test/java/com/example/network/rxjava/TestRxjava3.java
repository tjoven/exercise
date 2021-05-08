package com.example.network.rxjava;


import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 研究 操作符
 */
public class TestRxjava3 {
    private final static String TAG =  "TestRxjava";

    public void test(){
//        Single.just()
//        Maybe.ambArray()
        Observable.just(1,2).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                return Observable.just(integer + "");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String integer) {

            }
        });
    }
    @Test
    public void play() {

        Observable.just(1,2)

            //数据转化
            .map(new Function<Integer, String>() {
                @Override
                public String apply(Integer integer) throws Exception {
                    System.out.println(Thread.currentThread().getName());
                    return integer.toString() + "tzw";
                }
            })
            //重复发送
//                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
            .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String string) {
                System.out.println(Thread.currentThread().getName());
                System.out.println(string);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Test
    public void delay(){
        Observable.just("1","2","3").delay(0,TimeUnit.SECONDS)
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String string) throws Exception {
                System.out.println(string);
            }
        });
    }
}
