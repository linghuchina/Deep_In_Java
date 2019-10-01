package com.alibaba.java.LeetCodeDemo;

import java.util.Scanner;

public class PythonLeetCodeDemo {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int Result= 0;
        int count= 0;
        while(true){
            System.out.println("请输入分数");
            String integer = scanner.next();
            if("n".equals(integer)||"N".equals(integer)){
                return;
            }
            if("y".equals(integer)||"Y".equals(integer)){
                System.out.println("总分是 ："+Result);
            }
            if(0>Integer.valueOf(integer)||Integer.valueOf(integer)>100){
                throw new RuntimeException("输入数字不合法");
            }else {
                Result+=Integer.valueOf(integer);
                count++;
                System.out.println("输入结束");
            }

        }
    }
}
