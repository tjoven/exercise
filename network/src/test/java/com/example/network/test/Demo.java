package com.example.network.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Demo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put(null,"1");
        hashMap.put("2",null);
//        System.out.println(hashMap.get(null));
        System.out.println(hashMap.get("2"));
        System.out.println(hashMap.containsKey(null));

        ArrayList list = new ArrayList();
        list.add(null);
        System.out.println(list.get(0));

        HashSet set = new HashSet();
        set.add(null);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//        concurrentHashMap.put()

    }


}
