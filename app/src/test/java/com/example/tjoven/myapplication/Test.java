package com.example.tjoven.myapplication;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Test<T> {

    T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public static void main(String[] args) {
        List<String > stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("泛型测试"+"类型相同");
        }
        play(stringArrayList);
        play(integerArrayList);

    }

    private static void play(List<? extends Object> list){

        List<?>[] ls = new ArrayList<?>[10];
    }

    public boolean equals(T value) {
        return false;
    }

}
