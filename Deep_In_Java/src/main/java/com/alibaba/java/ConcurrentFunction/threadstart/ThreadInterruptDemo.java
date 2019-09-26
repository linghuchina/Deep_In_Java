package com.alibaba.java.ConcurrentFunction.threadstart;

/**
 * 结论
 * interrupt 只是一个状态,并非真正的能终止一个线程
 */
public class ThreadInterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(ThreadInterruptDemo::sayHello);

        thread.start();//启动线程
        thread.interrupt();//main 线程 interrupt 子线程,请思考，为什么已经调用了子线程还是执行了
        // interrupt（） 并不能终止线程，但是可以传递状态
        // Thread的join方法其实就是wait方法的实现。
        thread.join();//等待线程结束
    }

    public static void sayHello(){
        if(Thread.currentThread().isInterrupted()){
            System.out.println("中止状态");
        }
        System.out.println("hello,world");
    }
}
