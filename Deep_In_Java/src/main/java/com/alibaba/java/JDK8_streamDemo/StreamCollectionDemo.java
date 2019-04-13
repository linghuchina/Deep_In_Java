package com.alibaba.java.JDK8_streamDemo;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectionDemo {
    public static void main(String[] args) {
        List<Integer> values = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toList());

        System.out.println(values.getClass());

        List<Integer> values2 = Stream.of(6,7,8,9,10).collect(Collectors.toList());
        /**collect(supplier,accumulator,combiner)
         * @param supplier 生产者，规定了新生成的集合的类型
         * @param accumulator 串行的合并操作
         * @param combiner parallel并行化会先执行 accumulator的合并操作，最后 合并
         */
        values = Stream.of(1, 2, 3, 4, 5).parallel()
                .collect(LinkedList::new, List::add, List::addAll);



        System.out.println(values);
        System.out.println(values.getClass());
    }
}
