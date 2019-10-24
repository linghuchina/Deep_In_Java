package com.alibaba.java.ConcurrentFunction.concurrentpakage;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayBlockingQueueConcurrentDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (AtomicInteger i = new AtomicInteger(0); i.get() <100 ; i.getAndIncrement()) {
            executorService.submit(()->{
                try {
                    queue.put(i.get()); //写线程1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            executorService.submit(()->{//读线程1
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.awaitTermination(10, TimeUnit.SECONDS);

        executorService.shutdownNow();

    }
}
