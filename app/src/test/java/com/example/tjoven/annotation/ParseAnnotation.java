package com.example.tjoven.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParseAnnotation {

    @Test
    public  void main(){
        try{
            Class cl = Class.forName("com.example.tjoven.annotation.Test");
            paraClassAnnotation(cl);
            paraMethodAnnotation(cl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private  void paraMethodAnnotation(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        for(Method method:methods){
            if (method.isAnnotationPresent(TestA.class)){
                Annotation annotation = method.getDeclaredAnnotation(TestA.class);
                TestA testA = (TestA)annotation;
                String name = testA.name();
                int age = testA.age();
                System.out.println("method "+"name "+name+" age "+age);
            }
        }
    }

    private  void paraClassAnnotation(Class cl){
        Annotation[] annotations = cl.getAnnotations();
        for (Annotation annotation: annotations){
            if(annotation instanceof TestA){
                TestA testA = (TestA)annotation;
                String name = testA.name();
                int age = testA.age();
                System.out.println("class "+"name "+name+" age "+age);
            }
        }
    }
}
