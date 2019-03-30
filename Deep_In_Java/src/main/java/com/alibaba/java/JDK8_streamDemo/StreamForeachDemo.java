package com.alibaba.java.JDK8_streamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamForeachDemo {

    public static void main(String[] args) {
        List<User> list  = Arrays.asList(
                new User("张三", 11),
                new User("王五", 20),
                new User("李四", 44)
        );
        // java 8 之前
/*        for (User user:list
             ) {
            System.out.println(user);
        }*/
        // java 8 lambda
      //  list.forEach(user -> System.out.println(user));
        // java 8 Stream
        list.stream().forEach(user -> System.out.println(user));
       // Stream.of(list).forEach(System.out::println);

    }
}
