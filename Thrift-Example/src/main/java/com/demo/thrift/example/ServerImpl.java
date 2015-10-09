package com.demo.thrift.example;

import org.apache.thrift.TException;

/**
 * 创建服务端 创建server的实现类：ServerImpl.java
 * 
 * @author MYONERAY
 *
 */
public class ServerImpl implements DemoService.Iface {

    public String getNameById(int id) throws TException {
        System.out.println("Your username is MYONERAY");
        return "MYONERAY";
    }

}