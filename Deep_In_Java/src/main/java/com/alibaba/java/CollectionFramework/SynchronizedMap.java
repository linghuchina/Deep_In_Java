package com.alibaba.java.CollectionFramework;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 早期的并发实现
 */
public class SynchronizedMap {
    public static void main(String[] args) {
        //看源码的时候，如果return中出现view 的时候，说明返回的一定是只读的
        Map<String,String> map  = new HashMap<>();
        Collections.synchronizedMap(map);

    }
}
