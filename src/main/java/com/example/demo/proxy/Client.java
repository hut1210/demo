package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: Hut
 * @Date: 2020/04/21 13:38
 **/
public class Client {
    public static void main(String[] args) {
        //Subject sub = new RealSubject();
        Subject sub = new RealSubject2();
        InvocationHandler handler = new MyInvocationHandler(sub);
        Subject proxy = (Subject) Proxy.newProxyInstance(sub.getClass().getClassLoader(),
                sub.getClass().getInterfaces(),handler
        );

        Subject2 sub2 = new RealSubject2();
        Subject2 proxy2 = (Subject2) Proxy.newProxyInstance(sub2.getClass().getClassLoader(),
                sub2.getClass().getInterfaces(),handler
        );
        proxy.doSomething();
        proxy.doSomething1();

        proxy2.doSomething3();
        proxy2.doSomething4();
    }
}
