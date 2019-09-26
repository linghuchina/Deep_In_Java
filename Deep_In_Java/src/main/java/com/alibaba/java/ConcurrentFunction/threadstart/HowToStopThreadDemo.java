package com.alibaba.java.ConcurrentFunction.threadstart;

public class HowToStopThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        StoppableAction action = new StoppableAction();
        Thread thread = new Thread(action);
        //线程不一定立即执行
        thread.start();
        // main线程调整stop状态
        action.stop();
       // thread.join();
    }

    private static class  StoppableAction implements Runnable{
       private boolean stoped= false;


        @Override
        public void run() {
            if(stoped){
                //通过异常的方式可以kill 当前线程，这是最通用的一种方案
                System.out.println("Action stoped");
                return;
            }
            System.out.println("Action start");
        }
        public void stop() throws InterruptedException {
            Thread.currentThread().sleep(100);
            this.stoped = true;
        }
    }
}
