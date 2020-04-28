package com.example.demo.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: Hut
 * @Date: 2020/04/21 13:35
 **/
public class MyInvocationHandler implements InvocationHandler {

    private Object object = null;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法前....");
        return method.invoke(object, args);
    }
}
