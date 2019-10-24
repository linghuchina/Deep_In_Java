package com.alibaba.java.ConcurrentFunction.CASDemo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeUtils {
    private static Unsafe unsafe;
    private UnsafeUtils(){}
    static{
        Field field = null;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            unsafe = (Unsafe) field.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Unsafe getUnsafe(){
        return  unsafe;
    }
}
