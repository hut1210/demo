package com.example.demo.proxy;

/**
 * @Author: Hut
 * @Date: 2020/04/21 13:34
 **/
public class RealSubject implements Subject,Subject2 {
    @Override
    public void doSomething() {
        System.out.println("doSomething()......");
    }
    @Override
    public void doSomething1() {
        System.out.println("doSomething()1......");
    }
    @Override
    public void doSomething3() {
        System.out.println("doSomething()3......");
    }
    @Override
    public void doSomething4() {
        System.out.println("doSomething()4......");
    }
}
