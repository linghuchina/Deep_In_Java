package com.alibaba.java.ConcurrentFunction.ReentranLockDemo;

public class AcquireAndReleaseDemo {
    public static void main(String[] args) {
        // lock 机制程
        // 获得 Acquire
        // 释放Release


        // 释放的语义 Release
        //1. Object.wait
        //2. thread park - LockSupport.park(object)
        //3. condition# wait
        //4. 运行时异常
        //5. java 9 自旋 Thread.onSpinWait()
        //6. Thread.yield

        //所谓公平(Fair)和非公平(NonFair)
        // 公平 -> 线程FIFO
        // 非
        //  公平->线程随线程调度（最佳实践：在创建线程时，除非必要，不要调整线程的优先级)

    }




}
