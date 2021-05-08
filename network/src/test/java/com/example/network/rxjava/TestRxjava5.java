package com.example.network.rxjava;


import org.junit.Test;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableSubscriber;
import io.reactivex.schedulers.Schedulers;

/**
 * 背压
 */
public class TestRxjava5 {
    private final static String TAG =  "TestRxjava5";

    @Test
    public void play() {

        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                System.out.println("e1");
                emitter.onNext(2);
                System.out.println("e2");
                emitter.onNext(3);
                System.out.println("e3");
                emitter.onNext(4);
                System.out.println("e4");
            }
        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io()).observeOn(Schedulers.computation()).subscribe(new FlowableSubscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe");
//                s.request(3);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: "+integer);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError: "+t.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete: ");
            }
        });
    }
}
