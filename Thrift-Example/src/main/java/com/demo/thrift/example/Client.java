package com.demo.thrift.example;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * 创建客户端 创建Client.java：
 * 
 * @author MYONERAY
 *
 */
public class Client {

    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 8090;
    public static final int TIMEOUT = 30000;

    public void startClient() throws TException {
        TTransport transport = null;

        transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
        // 协议要和服务端一致
        TProtocol protocol = new TBinaryProtocol(transport);
        // TProtocol protocol = new TCompactProtocol(transport);
        // TProtocol protocol = new TJSONProtocol(transport);
        DemoService.Client client = new DemoService.Client(protocol);
        transport.open();
        String result = client.getNameById(1);

    }

    public static void main(String[] args) throws TException {
        Client client = new Client();
        client.startClient();

    }

}