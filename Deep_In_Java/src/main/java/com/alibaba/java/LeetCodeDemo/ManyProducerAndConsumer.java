package com.alibaba.java.LeetCodeDemo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
//分析CyclicBarrier的语义  可能被循环的阻塞住
public class ManyProducerAndConsumer {
    private   AtomicInteger producerCount=new AtomicInteger(0);
    protected static final ExecutorService pool = Executors.newCachedThreadPool();
    protected final int nTrials,nPairs;
    protected final LinkedBlockingQueue<goods> queue = new LinkedBlockingQueue();
    protected final AtomicInteger consumerCount = new AtomicInteger(0);
    protected CyclicBarrier barrier;

    public static void main(String[] args) {
        new ManyProducerAndConsumer(10,1).test();
        pool.shutdown();
    }

    private void test() {
        try {
            for (int i = 0; i < 10; i++) {
                pool.execute(new Producer());
                pool.execute(new Consumer());
            }
            barrier.await(); // 阻塞主线程，等待所有线程就绪

            barrier.await();// 等待所有线程执行完成，
            // 即生产者和消费者线程中的第二个await执行完
            // 相当于循环使用了两次CyclicBarrier
            System.out.println("producter最终数量"+producerCount);
            System.out.println("consumer最终数量"+consumerCount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ManyProducerAndConsumer( int i1, int i2) {
        this.nTrials = i1;
        this.nPairs = i2;
        this.barrier = new CyclicBarrier(2*i1+1);
    }
    static int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }
    class Producer implements  Runnable{
        @Override
        public void run() {
            try{
                System.out.println("I am waiting 1        "+barrier.getNumberWaiting());
                barrier.await();
                System.out.println("I am waiting 2        "+barrier.getNumberWaiting());
                for (int i = 0; i < 1; i++) {
                    queue.add(new goods(i+""));
                    producerCount.getAndIncrement();
                    System.out.println("已经生产了"+producerCount);
                }

                System.out.println("I am waiting 3         "+barrier.getNumberWaiting());
                barrier.await();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    class Consumer implements  Runnable{

        @Override
        public void run() {
            try{
                System.out.println("I am waiting 1        "+barrier.getNumberWaiting());
                barrier.await();
                System.out.println("I am waiting        2          "+barrier.getNumberWaiting());
                for (int i = 0; i < 1; i++) {
                    queue.add(new goods(i+""));
                    consumerCount.getAndIncrement();
                    System.out.println("在消费,剩余数量为"+consumerCount);
                }

                System.out.println("I am waiting       3        "+barrier.getNumberWaiting());
                //barrier.await();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
class goods{
    private String name;

    public goods(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "goods{" +
                "name='" + name + '\'' +
                '}';
    }
}
