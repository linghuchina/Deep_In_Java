package com.alibaba.java.JDK8_streamDemo.FunctionalInterface;

import java.util.function.Supplier;

public class SupplierDesignDemo {
    public static void main(String[] args) {
        echo("hello,world");
        //字节码提升的方式
        echo(SupplierDesignDemo::getMessage);
        //最原始的匿名内之类的方式
        echo(new Supplier<String>() {
            @Override
            public String get() {
                return getMessage();
            }
        });
        // lambda方式
        echo(()->{
            return getMessage();
        });



        //常规的从接口中获取一个字符串
         getMessage();
        //用 supplier接口的方式的好处是 可以再获取的时候进行处理
        Supplier<String> stringSupplier = SupplierDesignDemo::getMessage;//此时是待执行
        stringSupplier.get();//执行

    }




    private  static String getMessage(){
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        return "hello,world";
    }

    private  static void echo(String str){
        System.out.println(str);
    }
    private static void echo(Supplier<String> message){
        System.out.println(message.get());
    }

}

