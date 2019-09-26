package com.alibaba.java.basic.java.design;

/**
 * 有一天有一个人问我， 为什么A类中的静态工厂方法必须要static，其实和A有关系，编译时如果A不是static的话，内部的静态方法不可见、
 */
public class StaticClassDemo {
    public static void main(String[] args) {

    }

       static class A{
        private  A(){}

        public static  A getAinstance(){
            return new A();
        }
    }
}
