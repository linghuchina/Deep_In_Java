package com.alibaba.java.ConcurrentFunction.concurrentpakage;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
       // demoAddMethod(arrayBlockingQueue);
        //Queue 添加操作中offer 要多于 add方法（安全性考虑）
        demoofferMethod(arrayBlockingQueue);
        System.out.println(arrayBlockingQueue);

        // BlockingQueue 要使用put方法多余offer方法（使其满足阻塞的语义）
        demoputMethod(arrayBlockingQueue);
    }
    private static void demoofferMethod(BlockingQueue queue){
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        //如果超过3个 无效
        queue.offer(4);
    }
    private static void demoAddMethod(BlockingQueue queue){
        queue.add(1);
        queue.add(2);
        queue.add(3);
        //如果超过3个 报错  Queue full
        queue.add(4);
    }
    private static void demoputMethod(BlockingQueue queue) throws InterruptedException {
        queue.put(1);
        queue.put(2);
        queue.put(3);
        //如果超过3个 报错  Queue full
        queue.put(4);
    }

}
