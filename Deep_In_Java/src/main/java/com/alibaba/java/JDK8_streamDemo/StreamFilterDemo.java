package com.alibaba.java.JDK8_streamDemo;

import java.util.Arrays;
import java.util.List;

public class StreamFilterDemo {
    public static void main(String[] args) {
        System.out.println("过滤前");
        List<User> list  = Arrays.asList(
                new User("张三", 11),
                new User("李四", 44),
                new User("王五", 20),
                new User("张三", 50),
                new User("李四", 60),
                new User("王五", 70)
        );
        list.forEach(user -> System.out.println(user));

        System.out.println("java 8 之前过滤后");

        //java 8 之前
        for (User user:list
             ) {
            if (user.getAge()>50){
                System.out.println(user);
            }
        }
        //java8 stream
        System.out.println("java 8 stream filter 方法");
        list.stream().filter((User user)->user.getAge()>50).forEach(user -> System.out.println(user));
    }
}
