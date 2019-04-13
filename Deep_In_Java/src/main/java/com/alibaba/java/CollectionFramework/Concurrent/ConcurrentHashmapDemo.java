package com.alibaba.java.CollectionFramework.Concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashmapDemo {
    public static void main(String[] args) {
        final ConcurrentHashMap<Integer, String> chm = new ConcurrentHashMap<Integer, String>();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        newFixedThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i <1000000; i++){
                    chm.put(123, "asd"+i);

                }
            }
        });
        newFixedThreadPool.submit(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(chm.get(123));
                    }
                });
        newFixedThreadPool.shutdown();
    }

}
