package com.alibaba.java.ConcurrentFunction.threadstart;

public class JoinAndWaitDemo {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        Thread myThread1 = new Thread(new MyThread());

        myThread1.start();

        myThread.Syjoin();




    }


}
class MyThread implements   Runnable{
    @Override
    public void run() {
        synchronized (this){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello world");
        }

    }

    public synchronized void Syjoin(){
        System.out.println("hello world");
    }
}

