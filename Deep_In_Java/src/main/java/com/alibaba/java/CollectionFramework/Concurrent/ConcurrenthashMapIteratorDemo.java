package com.alibaba.java.CollectionFramework.Concurrent;

import org.apache.poi.ss.formula.functions.T;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 关于Concurrent 包下各个collection 的iterator是满足弱一致性的（not-fast_fail）
 * 顺带简单说下关于，concurrenthashmap 的一些基本设计原理
 * 所谓弱一致性的由来。
 *
 */
public class ConcurrenthashMapIteratorDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<String,String> map =  new ConcurrentHashMap<String,String>();
        map.put("1","1");
        map.put("2","1");
        map.put("3","1");
        map.put("4","1");

        Iterator iterator = map.entrySet().iterator();
        Thread t1 = new Thread(()->{
        IteratorDemo(iterator);
        });
        t1.start();
        Thread t2 = new Thread(()->{
            try {
                sout(map);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        t1.join();
        t2.join();
    }

    public static void IteratorDemo(Iterator<Map.Entry<String,String>> iterator){
        while(iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            if(entry.getKey()=="1"){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                iterator.remove();
            }
            System.out.println(entry);
        }
    }
    public static void sout(Map<String,String> map) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(map);
    }
}
