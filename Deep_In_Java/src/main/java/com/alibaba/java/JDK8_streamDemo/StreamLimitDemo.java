package com.alibaba.java.JDK8_streamDemo;

import java.util.Arrays;
import java.util.List;

public class StreamLimitDemo {
    public static void main(String[] args) {
        List<User> list  = Arrays.asList(
                new User("张三", 11),
                new User("李四", 44),
                new User("王五", 20),
                new User("张三", 50),
                new User("李四", 60),
                new User("王五", 70)
        );
        System.out.println("截断前");
        list.forEach(user -> System.out.println(user));
        System.out.println("截断后");
        // java 8 前
        System.out.println("java 8 前");
        // 只输出前三个
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));
        }

        System.out.println("java 8 之后");
        //java 8 stream 先输出前三个  再跳出前两个
        list.stream().limit(3).skip(2).forEach(user -> System.out.println(user));
    }
}
