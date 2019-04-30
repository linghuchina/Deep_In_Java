package com.alibaba.java.CollectionFramework;

import java.lang.ref.WeakReference;

/**
 * 首先理解什么是引用
 * 1:什么是强引用
 * 2:什么是若引用
 */
public class WeakReferenceMap {


    public static void main(String[] args) {
        demoWeakHashMap();
    }

    private static void demoWeakHashMap() {
        //强引用
        // value 变量是局部变量，存放在栈
        //"abc" 是常量，在java 8 之前存在perm区域，java 8+是存放发在meta区
        // 在demoWeakHashMap（）方法执行后，value 变量会被立即回收，"abc"常量常驻
        String value = "ABC";
        // 弱引用
        WeakReference<User> userWeakReference = new WeakReference<>(new User("lh"));
        User user =  userWeakReference.get();
    }
    private static class User{
        private String name ;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
