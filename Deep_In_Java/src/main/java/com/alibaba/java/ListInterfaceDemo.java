package com.alibaba.java;

import java.util.LinkedList;
import java.util.List;

public class ListInterfaceDemo {
    static int i;
   public static final void intDemo(){}
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(i);
        System.out.println(list.get(2));

        System.out.println(~10);
    }
}
