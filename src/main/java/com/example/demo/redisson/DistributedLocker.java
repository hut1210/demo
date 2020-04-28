package com.example.demo.redisson;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Hut
 * @Date: 2020/04/21 17:24
 **/
public interface DistributedLocker {
    RLock lock(String lockKey);

    RLock lock(String lockKey, long timeout);

    RLock lock(String lockKey, TimeUnit unit, long timeout);

    boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime);

    void unlock(String lockKey);

    void unlock(RLock lock);
}
