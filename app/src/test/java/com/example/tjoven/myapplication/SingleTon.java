package com.example.tjoven.myapplication;

public class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 1;

    private SingleTon() {
        count1++;
        count2++;
        System.out.println("SingleTon");
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}

