package com.alibaba.java.JDK8_streamDemo.FunctionalInterface;

import java.io.File;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<File> predicate = new Predicate() {
            @Override
            public boolean test(Object o) {
                return false;
            }
        };
        Predicate<File> predicate1 = file -> false;
    }
}
