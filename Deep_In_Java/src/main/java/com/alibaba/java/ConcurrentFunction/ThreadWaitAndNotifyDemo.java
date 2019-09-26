package com.alibaba.java.ConcurrentFunction;

/**
 * 总结一下notify 和 notifyAll 与 wait 方法的关系，
 * 原则上 wait notify notifyAll 都必须在取得monitor锁时才能执行，否则就会抛出ilegal异常
 *
 * 其次，wait 和notify notifyAll 调用的对象应该是同一个。
 *
 * 最后 notify 只能根据os 选择恢复 monitor 等待池中的一个线程
 * 而 notifyAll 可以恢复monitor 等待池中的全部线程
 * 所以原则上 notifyAll 可以保证完整的恢复线程
 */
public class ThreadWaitAndNotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        // Thread 实现 Runnable
        // 如果没有传递 Runnable 对象实现，空执行
        // wait() 语义：在同步（互斥）场景下

        // Lock 场景： T1、T2，互斥访问资源 R
        // T1 获取 L(T1) -> T2 获取 L(T2)
        // T1.wait() T2.wait() 都要被阻塞（停顿）

        Thread t1 = new Thread(ThreadWaitAndNotifyDemo::sayHelloWorld); // 方法引用
        t1.setName("T1");
        // 启动线程

        Thread t2 = new Thread(ThreadWaitAndNotifyDemo::sayHelloWorld);
        t2.setName("T2");
        t2.start();
        t1.start();

        System.out.println("Thread t1 t2 started");
        // Object.wait() 与 Thread.join() 看起来效果类似
        // 实际上 Thread.join() 方法就是调用了 Thread 对象 wait(int) 方法

        // 调用 wait() 方法的对象，再调用 notify() 方法必须是同一对象
        // 因此以下调用时错误的示范
        Object monitor = ThreadWaitAndNotifyDemo.class;
/*        synchronized (monitor) {
//            t1.notify();
//            t2.notify();
        }*/

        //Thread.currentThread().sleep(5000);
        // 正确的写法：
        synchronized (monitor) {
            // 为什么 monitor.notify() 不能保证完全释放
            //问题出现在这里，如果notify的是线程二时，会造成线程二一直在等待。
            //  测试发现不管是notify 还是notifyall都会导致死锁，原因是如果时间片在到达  t1和t2 之前已经完成了notify动作，可能线程永远都无法被唤醒，所以 和notifyall 与notify 没什么区别
            monitor.notifyAll();
            //monitor.notifyAll();
        }
        // 第三方可以（条件）控制 T1 或者 T2 释放

        // Java 5+ : Condition 条件，await() 等待，signal() 通知
    }

    public static void sayHelloWorld() {

        Thread currentThread = Thread.currentThread();

        Object monitor = ThreadWaitAndNotifyDemo.class;

        synchronized (monitor) {
            try {
                System.out.printf("线程[%s] 准备进入等待状态...\n", currentThread.getName());
                monitor.wait();
                System.out.printf("线程[%s] 进入等待状态...\n", currentThread.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("线程[%s] 恢复执行...\n", currentThread.getName());
            System.out.printf("线程[%s] : Hello,World!\n", currentThread.getName());
        }
        System.out.printf("线程[%s] : 执行完成\n", currentThread.getName());
    }

}
