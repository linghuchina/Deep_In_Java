package com.alibaba.java.JDK8_streamDemo;

import java.util.Arrays;
import java.util.List;

public class StreamSkipDemo {
    public static void main(String[] args) {
        List<User> list  = Arrays.asList(
                new User("张三", 11),
                new User("李四", 44),
                new User("王五", 20),
                new User("张三", 50),
                new User("李四", 60),
                new User("王五", 70)
        );
        //跳过前三个 从第四个开始输出
        //java 8 之前
        System.out.println("java 8  之前");
        for (int i=3 ;i<list.size();i++){
            System.out.println(list.get(i));
        }

        //java 8 之后Stream 的使用
        System.out.println("java 8 之后Stream 的使用");
        list.stream().skip(3).forEach(user -> System.out.println(user));
    }
}
