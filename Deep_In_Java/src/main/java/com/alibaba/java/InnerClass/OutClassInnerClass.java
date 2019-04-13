package com.alibaba.java.InnerClass;

/**
 * 思考内置类的设计初衷
 *
 */
public class OutClassInnerClass {

    static int a ;
    static{
        a+=5;
    }
    static{
        a/=3;
    }
    int b;
    public static void test(){
        System.out.println("outer class static function");
    }
/**
 * 测试方法
 */
    public static void main(String[] args) {
        // 成员test1 和 test2 是可以直接调用类中的静态方法的
        //虽然我们不太建议，避免通过一个类的对象引用访问此类的静态变量或静态方法，无谓增加编译器解析成本，直接用类名来访问即可。
        Test1 test1 = new Test1();
        Test1 test2 = null;
        Test1.hello();
        test2.hello();
        test1.hello();
        //new 一个外部类
        OutClassInnerClass outClassInnerClass = new OutClassInnerClass();
        // 通过外部类的对象new一个非静态的内部类
        OutClassInnerClass.InnerClass  innerClass= outClassInnerClass.new InnerClass();
        // 通过内部类对象调用非静态内部类方法
        System.out.println(innerClass.getKey());
        //普通内部类成员


        //调用静态内部类的静态变量
        System.out.println(OutClassInnerClass.InnerStaticClass.getMessage());

    }
    private class InnerClass{
        //只有在静态内部类中才能够声明或定义静态成员
        //private static String tt = "0";

        private int flag = 0;

        public InnerClass(){
            System.out.println("InnerClass create a:"+a);
            System.out.println("InnerClass create b:"+b);
            System.out.println("InnerClass create flag:"+flag);
            System.out.println("InnerClass call out static function");

            test();
        }

        public String getKey(){
            return "no-static-inner";
        }
    }
    private static class InnerStaticClass{
        // 静态内部类可以有静态成员，而非静态内部类则不能有静态成员。
        private static String static_value = "0";

        private int flag  =0;

        public InnerStaticClass(){
            System.out.println("InnerClass create a:" + a);
            // 静态内部类不能够访问外部类的非静态成员
            // System.out.println("InnerClass create b:" + b);
            System.out.println("InnerStaticClass flag is " + flag);
            System.out.println("InnerStaticClass tt is " + static_value);
        }
        public int getValue(){
            test();
            return 1;
        }
        public static String getMessage(){
            return  "static-inner";
        }
    }
    public OutClassInnerClass(){
        InnerClass ic = new InnerClass();
        System.out.println("OuterClass create");
    }

}
class Test1{
    public static void hello(){
        System.out.println("hello,world");
    }
}


