package com.alibaba.java.basic.java.design;

/**
 * 思考？ 何为深克隆 何为浅克隆
 */
public class CloneableDemo {

    public static void main(String[] args) {
        //1 若实现了cloneable接口  实现了clone方法
        Date date =new Date();
        date.setAnInt(1);
        date.setMessage("copy?");

        try {
          Date date1 =  (Date)date.clone();
            System.out.println("copy is deep？："+ (date1==date));
            System.out.println(date1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }



}

class Date implements Cloneable{
    private int anInt;
    private String message;

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Date{" +
                "anInt=" + anInt +
                ", message='" + message + '\'' +
                '}';
    }
    /**
     * 1.原生类型克隆不谈深浅
     * 2、包装类型克隆若直接重写生成的native clone 方法，则 方法为浅copy，原因是虚拟机会为我们开辟一个独立空间，并在原始的被
     *    克隆对象的堆区检索其属性，直接赋值给copy对象，
     *
     *    而若我们想去做一个浅度copy时，那么只需要将被copy对象的引用直接传递给copy对象，为什么？
     *    因为深度copy不会去开辟新的内存空间，只需要开辟一个栈空间，存储这个对象的引用，
     *    补充：4。21。02。13   所谓的真正意义上的深度copy应当递归的去扫描对象中的属性，挨个copy属性，而不应当仅仅重新分配引用给别的
     */
/*    @Override 浅拷贝
    protected Object clone() throws CloneNotSupportedException {
        Date copy  = new Date();
        copy.setAnInt(this.getAnInt());
        copy.setMessage(this.getMessage());
        return copy;
    }*/
    // 实现一个深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Date date=null;
        return date = this;
    }

}
