package com.alibaba.java.ConcurrentFunction.concurrentpakage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * blockingQueue 必须要用 put
 * 避免使用  offer ， 不要使用 add
 *
 * SynchronousQueue 互斥的生产环境
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        //SynchronousQueue 必须要被其他线程 remove or take
        // size = 0 的 特殊 队列
        BlockingQueue<Integer> blockingQueue = new SynchronousQueue<>();
      //  blockingQueue.add(1);
      //  System.out.println(blockingQueue.size());
        try {//必须要用put,不能使用offer
            blockingQueue.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(blockingQueue.size());

    }
}
