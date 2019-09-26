package com.alibaba.java.LeetCodeDemo;

import java.util.concurrent.CountDownLatch;


public class SoutOneTwoThreeDemo {

    public static void main(String[] args) {
        ZeroEvenOdd z  =  new ZeroEvenOdd(10);
        Thread t1 = new Thread(()->{
            try {
                z.even();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                z.odd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                z.zero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

}
class ZeroEvenOdd {
    private int n;
    private CountDownLatch countDownLatchA = new CountDownLatch(0);
    private CountDownLatch countDownLatchB = new CountDownLatch(1);
    private CountDownLatch countDownLatchC = new CountDownLatch(1);
    public ZeroEvenOdd(int n) {
        this.n = n;

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            countDownLatchA.await();
            System.out.println(0);
            countDownLatchA = new CountDownLatch(1);
            if(i%2==0){
                countDownLatchB.countDown();
            }else{
                countDownLatchC.countDown();
            }
        }
    }

    public void even() throws InterruptedException {
        for (int i = 1; i < n; i=i+2) {

                countDownLatchB.await();
                System.out.println(i);
                countDownLatchB = new CountDownLatch(1);
                countDownLatchA.countDown();
        }
    }

    public void odd() throws InterruptedException {
        for (int i = 2; i < n; i=i+2) {
                countDownLatchC.await();
                System.out.println(i);
                countDownLatchC = new CountDownLatch(1);
                countDownLatchA.countDown();
        }

    }
    public static void soutMath(int i) {
        System.out.println("method  :  "+i );
    }
}
