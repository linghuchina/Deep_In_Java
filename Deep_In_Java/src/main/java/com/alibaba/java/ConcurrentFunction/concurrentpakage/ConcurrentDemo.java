package com.alibaba.java.ConcurrentFunction.concurrentpakage;

public class ConcurrentDemo {
    public   int  a = 0 ;
    public  void  dosomething1(){

        // System.out.println(Thread.currentThread().getName()+"线程内数据 : "+a);
        System.out.println(Thread.currentThread().getName()+" : "+a);
    }
    public  void  dosomething(){
            a=a+10;
            System.out.println(Thread.currentThread().getName()+"线程内数据："+a);
           // System.out.println(Thread.currentThread().getName()+"线程内数据 : "+a);

        /**
         * 有个非常重要的问题在于，如果线程缓存中已经有了抓取主存过来的数据，如果在时间片回来的时候，再一次读取这个数据，是取缓存
         * 还是取主存？  随之而来的问题在于 volatile 关键字 的作用到底是什么？
         *
         * 答案：https://www.cnblogs.com/dolphin0520/p/3920373.html
         * 1、观察结果 发现大数据之后会有一个a是小数出现，i却大很多，，i是从缓存中抓过来的数据，为什么？
         * 因为，即便是另外一个线程不断的更新着i这个数据，但是只要这个值不刷新到主存，所有i是可能在一堆大数中出现一个小数的，
         * 但是至于一个a后面跟着的i不一样甚至更小的问题？
         * 这里笔者就要引入第二个问题，所谓的volatile关键字，号称可以保证读的可见性，但是在上述计算中有个问题 就是任何一个数字计算
         * 都不是一个原子性的操作，这意味着 我们计算时 必须 先读  后计算  最后回写， 所以有意思的地方在于如果我们读之后被抢夺了时间
         * 片，等时间片轮转回来之后是否还能保证读的可见性呢？  答案是否定的、volatile 虽然能保证读的可见性，但是不能保证非原子性操作
         * 中一定的安全
         *
         *
         * 缓存一致性协议。最出名的就是Intel 的MESI协议，MESI协议保证了每个缓存中使用的共享变量的副本是一致的。
         * 它核心的思想是：当CPU写数据时，如果发现操作的变量是共享变量，即在其他CPU中也存在该变量的副本，
         * 会发出信号通知其他CPU将该变量的缓存行置为无效状态，因此当其他CPU需要读取这个变量时，
         * 发现自己缓存中缓存该变量的缓存行是无效的，那么它就会从内存重新读取。
         *
         *
         * */
    }
    public static void main(String[] args) {
        //问题的关键在于，我们多线程在操作同一个非volilate修饰的属性时
        //需要将这个属性压进栈空间，运算完之后 并不会立即将计算结果或运行结果立刻刷新到主线程
        // 问题的关键就在这里，如果运行完之后未刷新到主存，而切换到其他线程，其他线程对值进行了修改并且刷新了值到主存
        // 问题的关键在于两点我个人认为
        /**
         * 1.线程调度的随机性，你并不能确定线程一定要在什么时间切换，这意味着 treadcache 数据未刷新到主存之前就可能被切换时间片，
         * volatile的作用就是要每次更新完属性之后强制刷新到主存中一次
         * 2.线程隔离区的缓冲区刷新到主存是有规则的，计算机在执行命令时，会先去寄存器和cache缓存中去查找是否存在这个变量，不存在
         * 就去主内存取，之后先保存在cache中，cache行积累到一定程度才会刷新到主内存
         *  这就会导致两个问题{A线程将共享内存的数据修改后未来得及刷新到主内存，B线程就读取到了共享变量之前未修改的值，此时就产生了线程内存
         *  不可见的问题
         *  }
         */
        // 那么问题来了，可能会出现一种情况，就是会输出两个同样的属性值
        ConcurrentDemo concurrentDemo = new ConcurrentDemo();
        Thread thread1 = new Thread(()->{
           for (int i=0;i<=10;i++){
               concurrentDemo.dosomething1();
           }
        },"线程1");

        Thread thread2 = new Thread(()->{
            for (int i=0;i<=10;i++){
                concurrentDemo.dosomething();

            }
        },"线程2");

        thread1.start();
        thread2.start();
    }
    /**
     * 有一个经典的问题 hashmap 多线程情况下扩容可能会导致死循环的问题
     * 1.假设有线程1 2 两个线程，
     */

}
