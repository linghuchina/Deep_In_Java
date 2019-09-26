package com.alibaba.java.ConcurrentFunction.basic;

public class DefinedThreadDemo {
    public static void main(String[] args) {
   MyThread m = new MyThread();
    m.start();

/*    Thread m2 = new Thread(new MyThread1());
    m2.start();*/
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("ThreadID"+Thread.currentThread().getId());
    }
}

class MyThread1 implements  Runnable{
    @Override
    public void run() {
        System.out.println("ThreadID"+Thread.currentThread().getId());
    }
}
