package com.alibaba.java.basic.java.design.ReflectionDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyinvocationHandler implements InvocationHandler {


    private Object target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retVal = method.invoke(target, args);
        return retVal;
    }

    public static Object proxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new MyinvocationHandler(target));
    }
    public MyinvocationHandler(Object target){
        this.target = target;
    }
}
