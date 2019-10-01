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

//此时联想一下，uncaughtException 是何时被调用的
//当一个Uncaught Exception发生时，jvm试图寻找这个线程的异常处理器，可以使用上面的方式 setUncaughtExceptionHandler的方式，注入一个异常处理器。
//如果这个线程属于一个线程组，且线程级别并未指定异常处理器，则使用线程组的异常处理器
