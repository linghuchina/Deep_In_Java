package com.alibaba.java.CollectionFramework.BasicAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 请思考，entrySet()方法是如何实现遍历hashmap的
 * 问题的关键在于 entrySet 的 iterator
 * 由于entrySet()方法只是生成一个EntrySet实例,并未进行初始化,注意,
 * 1.为什么以下代码中System.out.println(set); set中有值,是因为entryset 采用懒加载的模式，如果不需要就进行遍历，详细可以参考abstractSet toString()方法
 * 2.第二点是关于 Foreach,增强for循环在hashmap中，或者在entrySet中是基于entrySet自己的Iterator实现的。具体可参照EntryIterator。
 * 这两部分为entrySet懒加载提供了实现(ps:国内的博客呢，真的只是抄来抄去，也不知道在讲什么东西，想真正理解任何一个问题，还是需要去看源码。)
 *
 */
public class hashmapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        System.out.println(map);
        Set<Map.Entry<String,String>> set = map.entrySet();
        System.out.println(set);
        for (Map.Entry<String,String> e :
                set) {
            e.getKey();
            e.getValue();
        }
    }
}
