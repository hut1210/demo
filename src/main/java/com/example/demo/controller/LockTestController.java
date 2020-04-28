package com.example.demo.controller;

import com.example.demo.redisson.DistributedLocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @Author: Hut
 * @Date: 2020/04/21 17:30
 **/
@RestController
@RequestMapping("/redisson")
public class LockTestController {
    @Autowired
    private DistributedLocker distributedLocker;

    private static final ThreadPoolExecutor EXEC = new ThreadPoolExecutor(5, Integer.MAX_VALUE, 3, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(5));
    /*ExecutorService EXEC = Executors.newFixedThreadPool(10);*/

    @RequestMapping("/test")
    public void redissonTest() {
        String key = "redisson_key";
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            if (!EXEC.isShutdown()) {
                EXEC.execute(() -> {
                    try {
                        System.err.println("=============线程开启============" + Thread.currentThread().getName() + " " + finalI);

                        /** distributedLocker.lock(key,10L); //直接加锁，获取不到锁则一直等待获取锁
                         * Thread.sleep(100); //获得锁之后可以进行相应的处理
                         * System.err.println("======获得锁后进行相应的操作======"+Thread.
                         * currentThread().getName());
                         * distributedLocker.unlock(key); //解锁
                         * System.err.println("============================="+
                         * Thread.currentThread().getName());*/

                        boolean isGetLock = distributedLocker.tryLock(key, TimeUnit.SECONDS, 5L, 10L); // 尝试获取锁，等待5秒，自己获得锁后一直不解锁则10秒后自动解锁
                        if (isGetLock) {
                            System.out.println("线程:" + Thread.currentThread().getName() + ",获取到了锁");
                            Thread.sleep(100); // 获得锁之后可以进行相应的处理
                            System.err.println("======获得锁后进行相应的操作======" + Thread.currentThread().getName());
                            distributedLocker.unlock(key);
                            System.err.println("===============解锁==============" + Thread.currentThread().getName());
                        }
                    /*System.out.println("线程池中线程数目：" + EXEC.getPoolSize() + "，队列中等待执行的任务数目：" +
                            EXEC.getQueue().size() + "，已执行玩别的任务数目：" + EXEC.getCompletedTaskCount());*/
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }
        EXEC.shutdown();
        /*for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.err.println("=============线程开启============" + Thread.currentThread().getName());

                        *//**distributedLocker.lock(key, 10L); //直接加锁，获取不到锁则一直等待获取锁
         *Thread.sleep(100); //获得锁之后可以进行相应的处理
         *System.err.println("======获得锁后进行相应的操作======" + Thread.
         * currentThread().getName());
         *distributedLocker.unlock(key); //解锁
         *System.err.println("=============================" +
         * Thread.currentThread().getName());*//*

                        boolean isGetLock = distributedLocker.tryLock(key, TimeUnit.SECONDS, 5L, 10L); // 尝试获取锁，等待5秒，自己获得锁后一直不解锁则10秒后自动解锁
                        if (isGetLock) {
                            System.out.println("线程:" + Thread.currentThread().getName() + ",获取到了锁");
                            Thread.sleep(100); // 获得锁之后可以进行相应的处理
                            System.err.println("======获得锁后进行相应的操作======" + Thread.currentThread().getName());
                            distributedLocker.unlock(key);
                            System.err.println("=============解锁================" + Thread.currentThread().getName());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }*/
    }

}
