package com.example.tjoven.agent;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 通过实现 InvocationHandler 接口创建自己的调用处理器；
 * 通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
 * 通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
 * 通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入
 *

 */
public class Agent {

    @Test
    public  void test() {
        Person person = new Student();
        InvocationHandler handler = new ProxyHandler(person);
        Person proxy = (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(),person.getClass().getInterfaces(),handler);
        proxy.study();

        System.out.println("----------------------");
        System.out.println( proxy instanceof  Proxy);
        System.out.println("subject的Class类是："+proxy.getClass().toString());
    }
}
