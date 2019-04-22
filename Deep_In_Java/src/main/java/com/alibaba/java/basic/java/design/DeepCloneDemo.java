package com.alibaba.java.basic.java.design;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeepCloneDemo {
    public static void main(String[] args) {
        ArrayList<String> values = new ArrayList<>();
        values.add("A");
        values.add("B");
        values.add("C");

        System.out.println("Shallow Clone : ");
        // shallow clone

        List<String> shallowClone = (List<String>) values.clone();

  //      displayDiff(values,shallowClone);

        System.out.println("DEEP clone  : ");
        // deep clone
        List<String> deepClone  = deepClone(values);

        displayDiff(values,deepClone);

    }
    private static List<String> deepClone(List<String> source){
        List<String> clone = new ArrayList<>(source.size());
        for (String value : source){
            clone.add(new String(value));
        }
        return clone;
    }
    private static void displayDiff(List<String> values,List<String> clone){
        for (int i=0 ; i< values.size();i++){
            System.out.printf("Objects.equals : %s\n", Objects.equals(values.get(i),clone.get(i)));
            System.out.printf("Objects  == : %s\n", values.get(i)==clone.get(i));

        }
    }
    private static List<String> deepCloneInJavaSerialization(List<String> source) throws Exception {

        ArrayList<String> copy = new ArrayList<>(source);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ObjectOutputStream outputStream1 = new ObjectOutputStream(outputStream);
        //Copy 对象的序列化
        outputStream1.writeObject(copy);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(outputStream.toByteArray());

        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        List<String> clone = (List<String>) objectInputStream.readObject();

        return clone;



    }
}
