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
    }

    /**
     * 获取分区索引
     * @param values 数组对象
     * @param low 低位索引
     * @param high 高位索引
     * @return 分区索引
     */
    int partition(T[] values, int low,int high){
        return 0;
    }
}
