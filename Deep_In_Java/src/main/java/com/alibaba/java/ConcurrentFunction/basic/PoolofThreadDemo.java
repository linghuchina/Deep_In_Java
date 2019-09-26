package com.alibaba.java.ConcurrentFunction.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 有返回值的任务必须实现callable接口，而无任务的必须实现Runnable接口。
 * 执行callable任务后，可以获得一个Future对偶像，在该对象上调用get就可以获得Callable任务返回的
 * object了，再结合线程池接口ExecutorService就可以实现返回结果的多线程了
 */
public class PoolofThreadDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //创建多个有返回值的任务
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            Callable callable = new MyCallable(i+"");
            Future f = pool.submit(callable);
            list.add(f);
        }
        pool.shutdown();
        for(Future f : list){
            System.out.println("Results f:"+f.get().toString());
        }
    }
}
class MyCallable implements  Callable{
    private String age;
    public MyCallable(Object object) {
        this.age = (String) object;
    }
    @Override
    public Object call() throws Exception {
        return new String(age);
    }
}
