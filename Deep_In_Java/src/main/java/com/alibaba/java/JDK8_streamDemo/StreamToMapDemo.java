package com.alibaba.java.JDK8_streamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * map 映射 Stream 新特性
 */
public class StreamToMapDemo {
    public static void main(String[] args) {
        List<User> list  = Arrays.asList(
                new User("张三", 11),
                new User("李四", 44),
                new User("王五", 20),
                new User("张三", 50),
                new User("李四", 60),
                new User("王五", 70)
        );
        // 只输出所有人的年龄
        list.stream().forEach(user -> System.out.println(user));
        System.out.println("映射后");
       Map map =  list.stream().collect(Collectors.toMap(
                (e)->e.getAge(),
                (e)->e.getName()
        ));

        List<Integer> listint= list.stream().map(user -> user.getAge()).collect(Collectors.toList());
        listint.stream().forEach(integer -> System.out.println(integer));
        // Stream 小写转大写
        List<String> words = Arrays.asList("aaa", "vvvv", "cccc");
        List<String> newwords = words.stream().map(word -> word.toUpperCase()).collect(Collectors.toList());
        newwords.stream().forEach(System.out::println);
    }
}
