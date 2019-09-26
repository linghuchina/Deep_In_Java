package com.alibaba.java.ConcurrentFunction;

public class ThreadDumpDemo {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        //thread dump
        thread.dumpStack();

        Throwable throwable = new Throwable();
        throwable.printStackTrace(System.out);
    }
}
