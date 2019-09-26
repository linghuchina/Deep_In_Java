package com.alibaba.java.ConcurrentFunction;

public class SynchronizedMethodAndBlockDemo {
    public static void main(String[] args) {
        // synchronized 保证互斥
        // 当某个线程获得锁（1），重新又见到Synchronized +1
        echo("hello,world");//echo 到底重进入了几次   3
        //echo -> Println-> newline
        doEcho("hello,world");//doEcho 到底进入了几次  4
     }

    private static void doEcho(String message){
        Object object = new Object();
        synchronized (object){
            echo(message);
        }
    }
    /**
     * Synchronized修饰方法
     * @param message
     */
    private synchronized  static void  echo(String message){
        System.out.println(message);
    }
}
