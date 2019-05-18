package com.alibaba.java.CollectionFramework.BasicAlgorithm;

import java.util.Arrays;

/**
 * 插入排序 最快O（n），最慢O（N^2）
 * eg：与冒泡排序刚好相反，是与已排好序的数组比较，而冒泡是与未排的数组比较。
 * 思考：冒泡排序和插入排序的意义
 * 若不追求时间的复杂度了，冒泡排序和插入排序都是IN-PLAVCE的排序方式。所以在小内存使用的场景会很广泛。
 * @param <T>
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {


    @Override
    public void Sort(T[] values) {
        int size = values.length;
        for (int i = 1; i < size; i++) {
            T P  = values[i]; //高位的值
            for (int j = 0 ; j < i ; j++) {
                if(values[j].compareTo(values[i])>0){
                    values[i]= values[j];
                    values[j] = P;

                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1,5,2,4,6};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.Sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
