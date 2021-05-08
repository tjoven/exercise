package com.example.network.rxjava;



import org.junit.Test;


import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * 研究 操作符
 */
public class TestRxjava4 {
    private final static String TAG =  "TestRxjava";

    @Test
    public void play() {

       Observable.just(3, 4, 5, 6).filter(new Predicate<Integer>() {
           @Override
           public boolean test(Integer integer) throws Exception {
               return integer > 0;
           }
       }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
