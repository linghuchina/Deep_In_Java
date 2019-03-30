package com.alibaba.java.JDK8_streamDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamDistinctDemo {
    public static void main(String[] args) {
        //Stream去重
        List<User> list = Arrays.asList(
                new User("张三", 11),
                new User("李四", 20),
                new User("李四", 20),
                new User("张三", 50),
                new User("李四", 60),
                new User("王五", 70)
        );

        List<User> users = new ArrayList(list);
        System.out.println("-----去重前-----");
        users.forEach(user -> System.out.println(user));
        System.out.println("-----去重后-----");
        // java 8 前
        System.out.println("java 8 前");
        for (int i = 0; i < users.size() - 1; i++) {
            for (int j = users.size() - 1; j > i; j--) {
                if (users.get(j).getAge() == users.get(i).getAge() && users.get(j).getName()
                        .equals(users.get(i).getName())) {
                    users.remove(i);
                }
            }
        }
        for (User user : users) {
            System.out.println(user);
        }




        // java 8 stream 使用 必须重写对应泛型的hashCode()和equals()方法
        System.out.println("java 8 后 stream");
        users.stream().distinct().forEach(user -> System.out.println(user));



        // 去重+按照年龄>40以后从小到大+只取前2
        System.out.println("去重+按照年龄>40以后从小到大+只取前2");
        users.stream().distinct().filter((User user)->user.getAge()>40).
                sorted(Comparator.comparing(User::getAge)).limit(2).
                forEach(user -> System.out.println(user));
    }
}
