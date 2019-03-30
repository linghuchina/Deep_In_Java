package com.alibaba.java.JDK8_streamDemo;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class StreamMathDemo {
    public static void main(String[] args) {
        List<User> list  = Arrays.asList(
                new User("张三", 11),
                new User("李四", 44),
                new User("王五", 20),
                new User("张三", 50),
                new User("李四", 60),
                new User("王五", 70)
        );
        IntSummaryStatistics intSummaryStatistics  = list.stream().mapToInt(user->user.getAge()).summaryStatistics();
        System.out.println("总人数:"+ intSummaryStatistics.getCount());
        System.out.println("平均年龄:"+ intSummaryStatistics.getAverage());
        System.out.println("最大年龄:"+ intSummaryStatistics.getMax());
        System.out.println("总人数:"+ intSummaryStatistics.getMin());
        System.out.println("年龄之和:"+ intSummaryStatistics.getSum());
    }
}
