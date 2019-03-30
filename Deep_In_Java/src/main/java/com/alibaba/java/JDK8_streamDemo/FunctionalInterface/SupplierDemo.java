package com.alibaba.java.JDK8_streamDemo.FunctionalInterface;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) throws Exception {

        Supplier<Long> supplier = getLong();

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
            return  getHelloWorld();
            }
        };
        System.out.println(callable.call());
        Callable<String> callable1 = SupplierDemo::getHelloWorld;
        Callable<String> callable2 = ()->{
            return SupplierDemo.getHelloWorld();
        };
    }
    public static String getHelloWorld(){
        return "hello,world";
    }
    public static Supplier<Long>getLong(){
        return ()->{
            return  System.currentTimeMillis();
        };
/*        return System::currentTimeMillis;*/
    }
    public static Supplier<Long> getway(){
        return new Supplier<Long>() {
            @Override
            public Long get() {
                return System.currentTimeMillis();
            }
        };
    }
}
