package com.alibaba.java.CollectionFramework.QueueOfJava;

import java.util.LinkedList;
import java.util.List;

public class UnsafeLinkedList {

    private static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                list.add(i);
            }

        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                list.add(i);
            }

        });
        Thread t3 = new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                list.add(i);
            }

        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(list.size());
    }
}
