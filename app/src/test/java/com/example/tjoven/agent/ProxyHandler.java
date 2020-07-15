package com.example.tjoven.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    Object object;
    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(object, args);
        System.out.println("after");
        System.out.println("subject的Class类是："+proxy.getClass().toString());
        return result;
    }
}
