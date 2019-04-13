package com.alibaba.java.basic.java.design;

import java.util.Objects;

/**
 * 不考虑内置类的情况，一个java文件只能有一个类由public 修饰
 *
 */
public class ClassNameDemo {

}

class Data extends Object implements Cloneable{
    private int value;
    private String desc;
    public int getValue(){
        return  value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    /**
     * 重写clone 方法，原生类型没有深浅克隆的概念
     */
    public Data clone() throws CloneNotSupportedException {
        Data copy = (Data)super.clone();
        copy.desc =new String(this.desc);
        return copy;
    }
}