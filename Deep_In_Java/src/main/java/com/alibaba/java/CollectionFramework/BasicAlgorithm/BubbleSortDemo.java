package com.alibaba.java.CollectionFramework.BasicAlgorithm;

import org.apache.poi.ss.formula.functions.T;

import java.util.Arrays;

/**
 * 冒泡排序
 * @param <T>
 */
public class BubbleSortDemo<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void Sort(T[] values) {
// Comparable.compareTo
        // < return -1
        // = return 0
        // > return 1

        int size = values.length;

        for (int i = 0; i < size; i++) {
            T t = values[i];
            for (int j=i+1;j<size; j++){
                if (t.compareTo(values[j])==1){
                    values[i]=values[j];
                    values[j]=t;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] values = of(3,1,2,5,6);

        Sort<Integer> sort = new BubbleSortDemo<>();
        sort.Sort(values);
        Arrays.stream(values).forEach(System.out::println);

    }
    private static <T> T[] of(T...values){
        return values;
    }
}
