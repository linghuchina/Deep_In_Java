package com.alibaba.java.LeetCodeDemo;

public class LeetCode4 {

    /**
     * 输入i，进行拆分位数，如果位数相乘为0则 位数和为结果，否则，继续使用乘积为数字进行下一次运算
     * @param i
     */
    public static void  asd(String i){

        String  para = i;
        char[] arr = para.toCharArray();
        int flag = 1;
        int sum =  0;
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
            int a =  arr[j]-48;
            flag*=a;
            sum+=a;
        }
        if(flag==0){
            System.out.println("结果是 ："+sum);
        }else if (flag<10&&flag!=0
        ){
            System.out.println("结果是 ："+flag);
        }else {
            asd(flag+"");
        }
    }


    public static void main(String[] args) {
        asd("113");
    }
}
