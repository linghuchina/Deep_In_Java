package com.alibaba.java.CollectionFramework.Concurrent;

import java.util.HashMap;
import java.util.Map;
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

        Map<String,String> map = new HashMap<String,String>();
        map.put("1","1");
        map.put("2",null);
        System.out.println(map.get("3"));
        System.out.println(map.get("2"));
    // answer
       // 问题的关键在于什么？ 个人认为此问题在于一个设计上的考量，
        // 为什么这么说，因为hashmap本质上是一个单线程数据结构，在get 和 put 操作的时候，是有一个containskey 和 containsValues操作来保证
        // 数据结构中是否包含 该key或者 value ，由此不会造成一个误会，什么误会？即我们在get之后获得null，那么这个null是因为没有真正的没有这个数值从而
        // 返回null，还是有这个值，这个值就是null呢？

        //而 concurrenthashmap   hashtable 作为线程安全的框架，在运行时，即使在调用containskey 或者 containsvalue时，也不能保证当前的数据结构是不变的


    }

}
