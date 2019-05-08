package com.alibaba.java.CollectionFramework;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/**
 * 首先理解什么是引用
 * 1:什么是强引用
 * 2:什么是若引用
 *
 * 再思考ReferencehashMap的设计初衷
 * referenceHashMap 是一个伸缩性的数据结构，当hashmap中的对象是弱可达化，会被滞空。
 * 所以达到一个增强性能的特性
 */
public class WeakReferenceMap {


    public static void main(String[] args) {
        demoWeakHashMap();
    }

    private static void demoWeakHashMap() {
        //强引用
        // value 变量是局部变量，存放在栈
        //"abc" 是常量，在java 8 之前存在perm区域，java 8+是存放发在meta区
        // 在demoWeakHashMap（）方法执行后，value 变量会被立即回收，"abc"常量常驻
        String value = "ABC";
        // 弱引用
        WeakReference<User> userWeakReference = new WeakReference<>(new User("lh"));
        //1： weakreference 继承自 reference
        //2:  reference 中有一个ReferenceQueue  队列
        //3: 一个java虚拟机 只有一个referenceQueue
        //所以结论是 weakreference会有可能被弱可达化
        User user =  userWeakReference.get();


        ReferenceQueue queue = new ReferenceQueue();
        WeakReference<User> userWeakReference1 = new WeakReference<>(new User("lh"),queue);
        for (int i = 0; i < 100 ; i++) {
            System.out.println(userWeakReference1.get());
        }
    }
    private static class User{
        private String name ;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }

    }
}
