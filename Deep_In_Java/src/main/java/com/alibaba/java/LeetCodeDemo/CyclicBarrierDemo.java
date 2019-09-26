package com.alibaba.java.LeetCodeDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        System.out.println("begin");

        new CyclicBarrierDemo().sayHello();

        cyclicBarrier.await();

        //cyclicBarrier.await();

    }
    public void sayHello(){
        try {
            cyclicBarrier.await();
            System.out.println("hello world bro");
            cyclicBarrier.await();//相当于在同一个线程中设置第二次屏障
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
