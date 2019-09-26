package com.alibaba.java.CollectionFramework.SetFrameWork;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InteratorSetDemo {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();
        hs.add("世界军事");
        hs.add("兵器知识");
        hs.add("舰船知识");
        hs.add("汉和防务");
        System.out.println(hs);
        // [舰船知识, 世界军事, 兵器知识, 汉和防务]
        Iterator iterator = hs.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //理论上实现了Iterable接口的集合都可以使用增强for循环
        for(String name:hs){
            System.out.println(name);
        }

    }
}
