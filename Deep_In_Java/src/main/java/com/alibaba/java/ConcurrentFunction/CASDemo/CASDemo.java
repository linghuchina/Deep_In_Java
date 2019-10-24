package com.alibaba.java.ConcurrentFunction.CASDemo;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 本议题 通过反射获取了unsafe对象
 * 反射获得 unsafe中 cas 方法
 * 实现了atomicReference类
 * 其他Atomic类都可以类似实现
 */
public class CASDemo<T> {
    private static Unsafe unsafe;
    private volatile T a ;
    private static long valueOffset;
    static{
        //unsafeUtils 是由Spring实现的工具类
        unsafe = UnsafeUtils.getUnsafe();
        try {
            valueOffset = unsafe.objectFieldOffset(CASDemo.class.getDeclaredField("a"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws NoSuchFieldException {
        CASDemo casDemo = new CASDemo();
        casDemo.CASObject(unsafe);
    }

    /**
     *  atomicinteger' 的基本使用
     */
    public static void simpleDemo(){
        AtomicInteger a = new AtomicInteger(10);
        //如果expect 与 主存值一致，则讲update更新
        a.compareAndSet(10,2);

        a.incrementAndGet();


        System.out.println(a);
    }

    /**
     * 手动实现  atomicReference
     * @param unsafe
     * @throws NoSuchFieldException
     */
    public  void CASObject(Unsafe unsafe) throws NoSuchFieldException {
        for(;;) {
            Boolean B = unsafe.compareAndSwapObject(this, valueOffset, a, new Integer(2));
            if(B){
                break;
            }
        }
        System.out.println( "A 的值 ："+a);
    }
}

