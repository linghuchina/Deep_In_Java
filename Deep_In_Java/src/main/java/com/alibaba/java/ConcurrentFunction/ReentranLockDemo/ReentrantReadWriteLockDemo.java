package com.alibaba.java.ConcurrentFunction.ReentranLockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock =  new ReentrantReadWriteLock();

        Lock readLock  = reentrantReadWriteLock.readLock();
        try{
            readLock.lock();

        }finally {

        }

    }
}
