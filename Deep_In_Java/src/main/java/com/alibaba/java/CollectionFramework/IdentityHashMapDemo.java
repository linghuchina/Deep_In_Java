package com.alibaba.java.CollectionFramework;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {

        //hashmap 的实现是服从 由key 的hashcode 方法和 equals 方法共同完成的
        //1：重写的equals 方法也必须要重写 hashcode方法吗
        //答：不强制覆盖，建议实现，注意不要将hashcode方法作为 equals 方法的实现，可参考
        // Object.hash(Object...) / Arrays.hashCode(Object[]), hashcode（）是一个计算较重的实现，equals方法通常是做对象属性的比较
        //2：如果重写的Object 的hashcode 方法，那么也必须要重写equlas 方法吗
        //答： Hashcode（）是用于hash计算，比如普通的hashmap，由于不同对象的hashcode（）方法可能返回相同的数据，
        // 原因一： int 范围
        // 原因二： hashcode（）方法计算问题
        // 当不同对象hashcode（）相同时，在做什么对象的equals方法比较就至关重要了
        DemoHashMap();

        //场景 需要对对象本身做鉴别,简而言之IndentityhashMap中的hashcode方法遵循的是System.IndentityHashcode  而并非 key的hashcode方法
        //当然java7之后有一个类似的实现提供， Methodhandler
        demoIdentityHashMap();
    }

    private static void demoIdentityHashMap() {
        demoMap(new IdentityHashMap<>());

    }

    private static void demoMap(Map<String,Integer> map) {
        map.put("zhangsan",1);
        map.put(new String("zhangsan"),2);
        System.out.println(map.size());

        System.out.println("A"==new String("A"));
        System.out.println("A".equals(new String("A")));
        System.out.println("A".hashCode()==new String("A").hashCode());
    }


    private static void DemoHashMap() {
        demoMap(new HashMap<>());


    }
}
