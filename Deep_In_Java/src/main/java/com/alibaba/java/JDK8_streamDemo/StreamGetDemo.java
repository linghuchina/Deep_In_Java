package com.alibaba.java.JDK8_streamDemo;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamGetDemo {
    public static void main(String[] args) {
        //1数组
        String[] arr = new String[]{"Hello, world","LH","HXY"};
        // 1可以直接获得Stream构造方法 Stream stream =  Stream.of(arr);
        // 2可以用Arrays工具类将String[]封装成array对象再获得Stream   Stream<String> arrStream = Arrays.stream(arr)
        //2 集合
        //List<String> list = Arrays.asList("ab", "cd", "ef");
        //list.stream();
        //3 普通值
        Stream<String> stream = Stream.of("1","2","3","4");
        //遍历输出
        //stream.forEach(System.out::println);
        //Arrays.stream(arr).forEach(System.out::println);
    }
}
