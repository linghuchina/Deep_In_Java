package com.alibaba.java.CollectionFramework.Concurrent;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranslockDemo {
    //reentrantLock 就是一个锁
    ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {


    }
    public void exportExcel(Map<String,String> map){
        reentrantLock.tryLock();
        Set<Map.Entry<String,String>> set =  map.entrySet();
        for (Map.Entry<String,String> entry : set) {
            entry.getValue();
            entry.getKey();
        }
        //export(map)
        reentrantLock.unlock();

        /*
        * synchronized{
        *
        Set<Map.Entry<String,String>> set =  map.entrySet();
        for (Map.Entry<String,String> entry : set) {
            entry.getValue();
            entry.getKey();
        }
        export(map)

        * }
        * */
    }
}
