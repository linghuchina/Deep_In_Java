package com.alibaba.java.CollectionFramework;

import java.util.Arrays;

/**
 * 简单说下这个例子的本意：
 * 本意是为了证明数组 arrays.copyOf();
 *  方法是浅度copy，这没问题
 *  但是如果copy 的对象（包装类型）是final的时候，会发现copy后的数据修改之后原数据未改变，这是不满足浅copy原意的。
 *  其实这里是一个特别的例子，final修饰的属性是不允许改变的，如果修改了，其实是替换了一个新的对象
 *  结论：
 *  1。 数组的 arrays.copyof 是浅拷贝的
 *  2。 若想得到一个只读的数组，则需要深度copy
 */
public class ImmutableArrayCopyDemo {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,4,5};

        Integer[] valuescopy = Arrays.copyOf(array,array.length);

        valuescopy[0]=300;

        //数组的copy 和 对象的clone 是一致的（浅克隆）
        for (int i = 0; i <array.length ; i++) {
            System.out.println("array[i]==valuescopy[i]     "+(array[i]==valuescopy[i])+"     "+array[i]+" :  "+valuescopy[i]);
        }
        //User[] users = of("1","2","3","4","5");
        User[] users = of(1,2,3,4,5);
        User[] userscopy = Arrays.copyOf(users,users.length);
        System.out.println(users[0]);
        for (int i = 0; i <users.length ; i++) {
            System.out.println("users[i]==userscopy[i]     "+(users[i]==userscopy[i]));
        }
        // 如果需要只读数组，需要自己实现深度copy
        User user = userscopy[0];
        user.id=10;
        System.out.println("users[i]==userscopy[i]     "+(users==userscopy)+"   "+users[0]+" :  "+userscopy[0]);
    }




    public static User[]  of(Integer...users){
        User[] users1=new User[users.length];
        for (int i = 0; i < users.length; i++) {
            users1[i] = new User(users[i]);
        }
        return  users1;
    }
}
 class User{
//    public  final String id ;
     public  Integer id ;
    User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                '}';
    }
}