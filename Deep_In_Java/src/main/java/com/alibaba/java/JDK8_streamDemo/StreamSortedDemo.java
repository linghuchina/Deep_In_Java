package com.alibaba.java.JDK8_streamDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamSortedDemo {
    public static void main(String[] args) {
        List<User> list  = Arrays.asList(
                new User("张三", 11),
                new User("李四", 44),
                new User("王五", 20),
                new User("张三", 50),
                new User("李四", 60),
                new User("王五", 70)

        );
        /**
         * 排序算法
         */
        System.out.println("排序前");
        list.forEach(user -> System.out.println(user));
        System.out.println("排序后");
        //java 8 前
 /*       Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        list.forEach(user -> System.out.println(user));
*/
        // java 8 Stream 方法引用
        list.stream().sorted(Comparator.comparing(User::getAge)).forEach(user -> System.out.println(user));

    }
}
