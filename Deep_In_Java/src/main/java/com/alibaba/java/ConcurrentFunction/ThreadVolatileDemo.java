package com.alibaba.java.ConcurrentFunction;

public class ThreadVolatileDemo {

    private static  class Action{
        private volatile static boolean flag = true;

        private static void action() throws InterruptedException {
            if (flag){
                for (int i = 0; i <10 ; i++) {
                    System.out.println(flag);
                    System.out.println("RUNING.........");Thread.sleep(1000);
                }
            }
        }
        private static void FlagFalse(){
            flag = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                Action.action();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.currentThread().sleep(1000);
        Action.FlagFalse();

    }
}
