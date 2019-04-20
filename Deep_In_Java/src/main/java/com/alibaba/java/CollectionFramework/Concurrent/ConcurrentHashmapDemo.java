package com.alibaba.java.CollectionFramework.Concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashmapDemo {
    public static void main(String[] args) {
    //思考 为什么concurrentHashmap的value 不能为null
        // 而hashmap 可以 让value 为null
        ConcurrentHashMap<String,String>  concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1","1");
        System.out.println(concurrentHashMap.get("2"));
    }

}
