package com.alibaba.java.CollectionFramework;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 对自己严格： 对所有返回接口类型的方法禁止返回null
 * 对别人宽容： 要做非null 判断（尤其在rpc场景下）
 *
 *
 * 集合入参
 * 1。如果能用Iterable就用
 * 2。其次是Collection
 * 3。最后是Abstract 级别的list set 或者别的
 * 原因在于越抽象的实现，兼容性越好。
 */
public class EmptyCollectionDemo {
    public static void main(String[] args) {
        //
    }

    public static List<String> getIdsList(String name){
        if(name==null||name.length()<1){
            // 返回一个只读的empty list
            return Collections.emptyList();
        }
        //只读 emptylsit
        //实现java 序列化
        return  Collections.EMPTY_LIST;
    }
}
