package com.demo.thrift.example;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * 创建Server启动类：Server.java
 * @author MYONERAY
 *
 */
public class Server {

    public static final int SERVER_PORT = 8090;

    public void startServer() throws TTransportException {
        System.out.println("Server start ....");
        TProcessor tprocessor = new DemoService.Processor<DemoService.Iface>(new ServerImpl());
        TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
        TServer.Args tArgs = new TServer.Args(serverTransport);
        tArgs.processor(tprocessor);
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
        TServer server = new TSimpleServer(tArgs);
        server.serve();

    }

    public static void main(String[] args) throws TTransportException {
        Server server = new Server();
        server.startServer();

    }

}