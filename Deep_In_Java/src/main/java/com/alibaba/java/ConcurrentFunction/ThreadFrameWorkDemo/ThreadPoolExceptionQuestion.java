package com.alibaba.java.ConcurrentFunction.ThreadFrameWorkDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//官方提供的处理未捕获异常的实现方式
public class ThreadPoolExceptionQuestion implements Thread.UncaughtExceptionHandler {
    public static void main(String[] args) {
       // ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 也提供了第二种方式
/*        Thread.setDefaultUncaughtExceptionHandler((thread,throwable)->{
            System.out.printf("线程【%s】遇到了异常，详细信息:%s",thread.getName(),throwable.getMessage());
        });*/

        Thread t1 = new Thread(()->{
            throw new RuntimeException("自定义的异常");
        },"t1");
        t1.setUncaughtExceptionHandler(new ThreadPoolExceptionQuestion());
        t1.start();

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("线程【%s】遇到了异常，详细信息:%s",t.getName(),e.getMessage());
    }
}
