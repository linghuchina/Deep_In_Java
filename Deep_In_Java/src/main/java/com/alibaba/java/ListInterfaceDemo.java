package com.alibaba.java;

import java.util.LinkedList;
import java.util.List;

public class ListInterfaceDemo {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.get(2));
    }
}
