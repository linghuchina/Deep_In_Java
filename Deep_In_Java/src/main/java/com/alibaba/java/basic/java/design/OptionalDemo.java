package com.alibaba.java.basic.java.design;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalDemo {
    public static void main(String[] args) {
            theParamIsNullandthen();
    }
    public static void theParamIsNullandthen(){
        //静态方法中创建内部类对象必须是静态的内部类吗
        // 不行，静态方法中的内部类不能为静态的，主要与类加载有关
        User1 notnulluser = new User1();
        notnulluser.setAge("100");
        notnulluser.setName("linghu");
        Optional<User1> optionalUser = Optional.ofNullable(notnulluser);
        optionalUser.isPresent();

        Consumer<User1> consumer = OptionalDemo::sayHi;

        optionalUser.ifPresent(consumer);
         class Demoinnerclass{

        }
    }
    public  void theParamIsNullandthen2(){
          int i = 10;

        abstract class Demoinnerclass{

            }
    }
    public static void sayHi(User1 user){
        System.out.println(user);
    }
    static class User1{
        private  String name;
        private  String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
