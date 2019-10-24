package com.alibaba.java.CollectionFramework.BasicAlgorithm;

public class SelectionsSort {
    public static void main(String[] args) {
        Integer[] arr={1,3,2,45,65,33,12};
        System.out.println("交换之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }
        SelectionSort(arr);
    }

    public static void SelectionSort(Integer[] arr){
        for (int i = 0; i < arr.length ; i++) {
            int temp = (int) arr[i];
            for (int j = i; j < arr.length; j++) {
                if(temp>(int)arr[j]){
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("交换之后：");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }

}
