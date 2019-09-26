package com.alibaba.java.CollectionFramework.BasicAlgorithm;

/**
 * 快排：
 * 1： 先找到一个数组的最后一位，以此为比较轴
         * 2： 根据轴做一个分区
         * @param <T>
 */
public class QuickSort<T extends Comparable<T>> implements Sort{
    @Override
    public void Sort(Comparable[] values) {
        int size = values.length;
        Sort(values,0,size-1);
    }
    public void Sort(Comparable[] values,int lowP , int highP) {
        int size = values.length;
        int high = highP;
        int low = lowP;
        int  position = partition((T[]) values,low,high);
        System.out.println(position);
        if(position-1>lowP){
            Sort(values,lowP,position-1);
        }
        if (highP>position+1){
            Sort(values,position+1,highP);
        }

    }

    /**
     * 获取分区索引
     * @param values 数组对象
     * @param low 低位索引
     * @param high 高位索引
     * @return 分区索引
     */
    int partition(T[] values, int low,int high){
        T position  =  values[high];
        int i = low;
        int j = high;
        while(i<j){
            while(position.compareTo(values[i])>=1&&j>i) i++;
            while(position.compareTo(values[j])<=1&&j>i) j--;
            if(i<j){
                T temp = values[i];
                values[i] = values[j];
                values[j]=temp;
            }
        }
         return  i;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,4,2,5,10,0};
        Sort sort = new QuickSort();
        for (Integer a : arr
             ) {
            System.out.println(a);
        }
    }
}
