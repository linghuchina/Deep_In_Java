package com.alibaba.java.basic.java.design;

public class ForDemo {
    public static void main(String[] args) {
/*        for(int i = 0;;){
            System.out.println(i);
        }*/
        //相当于while(true);


        outer: for (;;) {
            System.out.println(1);
        }
    }
}
