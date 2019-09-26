package com.alibaba.java.CollectionFramework.QueueOfJava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class ConsumerAndProducer {

    BlockingDeque<String> basket = (BlockingDeque<String>) new ArrayBlockingQueue<String>(3);

    public void produce() throws InterruptedException{
        basket.put("An apple");
    }

    public String consume() throws InterruptedException{
        String apple = basket.take();
        return apple;
    }

    public int getAppleNum(){
        return basket.size();
    }
}
