package com.alibaba.java.basic.java.design;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public abstract class EunmClassDemo {
    public static void main(String[] args) {
        Stream.of(EunmClassDemo.values())
                .forEach(System.out::println);
    }

    public static final EunmClassDemo ONE= new EunmClassDemo(1) {
        @Override
        public String valuesAsString() {
            return String.valueOf(this.getCount());
        }
    };
    public static final EunmClassDemo TWO= new EunmClassDemo(2) {
        @Override
        public String valuesAsString() {
            return String.valueOf(this.getCount());
        }
    };
    public static final EunmClassDemo THREE= new EunmClassDemo(3) {
        @Override
        public String valuesAsString() {
            return String.valueOf(this.getCount());
        }
    };
    public static final EunmClassDemo FOUR= new EunmClassDemo(4) {
        @Override
        public String valuesAsString() {
            return String.valueOf(this.getCount());
        }
    };
    public static final EunmClassDemo FIVE= new EunmClassDemo(5) {
        @Override
        public String valuesAsString() {
            return String.valueOf(this.getCount());
        }
    };

    private int count;
    public abstract String valuesAsString();
    private EunmClassDemo( int value){
        this.count = value;
    }
    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "EunmClassDemo{" +
                "count=" + count +
                '}';
    }

    /**
     * 模拟实现jvm为我们Eunm字节码提升实现的values方法，遍历输出内部所有成员
     * @return
     */
    public static EunmClassDemo[] values(){
        return Stream.of(EunmClassDemo.class.getDeclaredFields()).filter(field -> {
            int modifiers = field.getModifiers();
          return  Modifier.isPublic(modifiers)&&Modifier.isStatic(modifiers)&&Modifier.isFinal(modifiers);
        }).map(field -> {
            try {
                return (EunmClassDemo)field.get(null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }).collect(Collectors.toList()).toArray(new EunmClassDemo[0]);
    }
}
