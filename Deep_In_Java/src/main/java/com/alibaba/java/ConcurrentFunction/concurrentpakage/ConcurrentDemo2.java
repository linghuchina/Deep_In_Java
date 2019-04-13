package com.alibaba.java.ConcurrentFunction.concurrentpakage;

public class ConcurrentDemo2 {
    volatile int  a = 1;
    volatile int  b = 2;

        public void change(){
            a = 3;
            b = a;
        }

        public void print(){
            System.out.println("b="+b+";a="+a);
        }

        public static void main(String[] args) {
            while (true){
                final ConcurrentDemo2 test = new ConcurrentDemo2();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        test.change();
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        test.print();
                    }
                }).start();

            }

    }
}
