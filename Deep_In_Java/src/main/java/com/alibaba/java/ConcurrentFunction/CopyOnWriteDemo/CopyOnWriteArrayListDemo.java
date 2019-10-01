package com.alibaba.java.ConcurrentFunction.CopyOnWriteDemo;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        List<String> list= new CopyOnWriteArrayList<>();
        //main线程插入三条数据
        //安装thread id
        list.add("1");
        //当前的线程ID==main.threadId
        list.add("2");
        list.add("3");
        // copy

        //JDK两大核心性能提升
        //1:数组
        //2:String
        Iterator iterator = list.iterator();
        //concurrentModificationException
        int times = 0;
        while(iterator.hasNext()&&times<100){
            iterator.next();
            list.add("2");
           // iterator.remove();
            times++;
        }

    }
}
