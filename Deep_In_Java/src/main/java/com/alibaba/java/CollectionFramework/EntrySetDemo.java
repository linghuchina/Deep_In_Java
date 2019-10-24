package com.alibaba.java.CollectionFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class EntrySetDemo {
    public static void main(String[] args) {
        Map<String,String> map =  new ConcurrentHashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");

        System.out.println(map);// 是对table 的遍历 导致它可以顺利的遍历 map 集合
    }


    public void getAll(Map<String,String> map){
        Set<Map.Entry<String,String>> set =  map.entrySet();
        for(Map.Entry<String,String> node :
             set) {
            String name = node.getKey();
            String value = node.getValue();
            System.out.println(name+" : "+value);
        }
    }
}
