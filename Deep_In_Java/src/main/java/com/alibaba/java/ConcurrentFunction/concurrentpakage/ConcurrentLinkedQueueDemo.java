package com.alibaba.java.ConcurrentFunction.concurrentpakage;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 本demo用于调试concurrentlinkedQueue 元素添加时代码流程
 * 意外发现一个concurrentlinkedqueue 的bug offer代码没有按照实际断点走
 */
public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {
        MyConcurrentLinkedQueue concurrentLinkedQueue = new MyConcurrentLinkedQueue<User>();
        concurrentLinkedQueue.offer(new User("linghu"));
        concurrentLinkedQueue.offer(new User("xueyao"));
        concurrentLinkedQueue.offer(new User("xiaomage"));
        System.out.println(concurrentLinkedQueue);
    }


}
class User{
    private String name;
    public User(String name){this.name = name;}
}
