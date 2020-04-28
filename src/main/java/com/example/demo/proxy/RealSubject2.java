package com.example.demo.proxy;

/**
 * @Author: Hut
 * @Date: 2020/04/21 13:35
 **/
public class RealSubject2 implements Subject,Subject2 {
    @Override
    public void doSomething() {
        System.out.println("Subject2doSomething()......");
    }
    @Override
    public void doSomething1() {
        System.out.println("Subject2doSomething()1......");
    }
    @Override
    public void doSomething3() {
        System.out.println("Subject2doSomething()3......");
    }
    @Override
    public void doSomething4() {
        System.out.println("Subject2doSomething()4......");
    }
}
