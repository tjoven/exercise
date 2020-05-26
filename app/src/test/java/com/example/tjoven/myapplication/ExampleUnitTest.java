package com.example.tjoven.myapplication;

import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        test();

    }

    public void test() throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        ArrayList arrayList3=new ArrayList<>();
        arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer
//        arrayList3.add("ss");
        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
        for (int i=0;i<arrayList3.size();i++) {
            System.out.println(arrayList3.get(i).getClass());
        }

        Object[] arr = new Object[10];
        arr[0] = 1;
        arr[1] = "asdad";

        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i].getClass());
        }
        ArrayList list = new ArrayList<String>();
        list.add(22);


    }

}

