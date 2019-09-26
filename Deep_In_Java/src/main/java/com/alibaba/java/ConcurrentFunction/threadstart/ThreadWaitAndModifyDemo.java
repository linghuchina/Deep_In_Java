package com.alibaba.java.ConcurrentFunction.threadstart;

/**
 * https://www.cnblogs.com/xudilei/p/6867045.html
 * https://blog.csdn.net/woniuhtl/article/details/95588673
 */
public class ThreadWaitAndModifyDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(ThreadWaitAndModifyDemo::sayHelloWorld);
        Thread t2 = new Thread(ThreadWaitAndModifyDemo::sayBye);
        t1.setName("T1");

        t1.start();

        t1.join();
        t2.start();
    /*    Thread t2 = new Thread(ThreadWaitAndModifyDemo::sayHelloWorld);
        t1.setName("T2");
        //调用vait()方法的对象，再调用notify的方法也必须是同一对象
        t1.notify();
        t2.notify();*/
    }

    public static void sayHelloWorld(){
        Object monitor =  ThreadWaitAndModifyDemo.class;
        synchronized (monitor){
            System.out.println(Thread.currentThread().getName()+"hello,world");
            System.out.println(Thread.currentThread().isAlive());
            try {
                monitor.wait();
                System.out.println("wait  jie shu ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public static void sayBye(){
        Object monitor =  ThreadWaitAndModifyDemo.class;
        synchronized (monitor){

                System.out.println("ByeBye  jie shu ");

        }

    }
}
