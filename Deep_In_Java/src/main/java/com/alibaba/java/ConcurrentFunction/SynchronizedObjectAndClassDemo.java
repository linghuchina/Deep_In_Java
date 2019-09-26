package com.alibaba.java.ConcurrentFunction;

public class SynchronizedObjectAndClassDemo {
    public static void main(String[] args) {
        Object object = new Object();

        synchronized (object){
            //Monitor -> Object
            //对象存在于Heap中
        }

        synchronized (Object.class){
            //java对象存在于MetaData 区域 或者 Perm区域(方法区)（java7之前）
        }

        Object objectclass = Object.class;
    }

}
