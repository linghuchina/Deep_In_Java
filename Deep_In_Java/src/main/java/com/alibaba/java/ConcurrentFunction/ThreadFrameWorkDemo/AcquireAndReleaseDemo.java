package com.alibaba.java.ConcurrentFunction.ThreadFrameWorkDemo;

public class AcquireAndReleaseDemo {
    public static void main(String[] args) {
        //lock 机制
        //获得 Acquire
        // Thread 进入 Synchronized ——>获得锁
        // 释放 Release的几种方式
        // 1. 当Thread(hold lock),调用Object#wait()时候，释放锁
        // 2. 运行时异常，Thread消亡
        // 3. java9 自旋锁 Thread.onSpinWait()
        // 4. Thread park->lockSupport.park(Object)
        // 5. Condition#wait
        // 6. Thread.yield()
        // 所谓的公平(Fair) 和非公平(NoFair)
        // 公平（Fair）线程FIFO
        // 非公平(NonFair)线程随线程调度

    }
}
