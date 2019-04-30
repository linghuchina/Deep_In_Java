package com.alibaba.java.CollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * checkedlist（）方法是为了解决什么问题而产生，
 * 问题的关键还在与 java 1.5之后出现了范型来规约代码，但是范型的本质是编译时检测，运行时擦写。
 * 我们是有办法饶过编译器检查的，所以如果我们需要在运行时依然按照规约，则需要用到checkList；
 */
public class CheckTypeCollectionDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        // list.add("1");
        // 范型是编译时检查，运行时擦写。
        // 运行时的数据， List<Integer> == List<Object> == List
        // list.add("A") 运行时时允许的
        List referencedValues = list;
        referencedValues.add("A");
        System.out.println(list);

        List<Integer> checkedTypeValues = Collections.checkedList(list,Integer.class);

        referencedValues  = checkedTypeValues;
        System.out.println(referencedValues==list);
        //在编译时运用java范型，运行时使用checkList 约束，——>强约束
        referencedValues.add("B");// 用于弥补范型擦写的漏洞

    }
}
