package com.alibaba.java.ConcurrentFunction.basic;

public class kejianxin {
    private int a = 0;

    public synchronized  void add(){
        this.a++;
    }
    public int geta(){
        return this.a;
    }

    public static void main(String[] args) {
        kejianxin k = new kejianxin();
        Thread thread = new Thread(()->{
            k.add();
            System.out.println(k.geta());
        });
        Thread thread1 = new Thread(()->{
            k.add();
            System.out.println(k.geta());
        });
        Thread thread2 = new Thread(()->{
            k.add();
            System.out.println(k.geta());
        });
        thread.start();
        thread1.start();
        thread2.start();
    }
}
