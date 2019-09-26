package com.alibaba.java.ConcurrentFunction.threadstart;

import org.apache.poi.ss.formula.functions.T;

/**
 * 由java线程状态需要关注一下线上排查问题时的一些问题
 * blocked 是指同步阻塞时被Monitor锁住时自动状态
 * 通常出现在文件系统中比较多，blocked多的程序需要关注，因为block本身就是对cpu性能的浪费
 */
public class NewThreadDemo {
    public static void main(String[] args) {
        //如果没有实现runnable 接口，则线程空转
/*        Thread thread = new Thread();
        thread.start();*/
        Thread thread = new Thread(()->{
            System.out.println("线程ID ："+Thread.currentThread().getId()+"hello，world！");
        });
        thread.start();

    }
}
