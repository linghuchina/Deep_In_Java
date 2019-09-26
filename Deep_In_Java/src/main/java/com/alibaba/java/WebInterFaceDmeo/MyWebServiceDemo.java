package com.alibaba.java.WebInterFaceDmeo;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 基于apache asmx 实现的客户端
 */
public class MyWebServiceDemo {

    public static void main(String[] args) throws MalformedURLException {
    //1使用原生jdk调用方式
        URL url = new URL("localhost:8080//services/HelloWorld?wsdl");

        QName qname = new QName("");
    }
}
