package thrift.lgd.demo;


import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

/**
 * TSimpleServer服务端
 * 简单的单线程服务模型，一般用于测试。
 *
 * Created by liguodong on 2016/12/10.
 */

public class HelloServerDemo {

    public static final int SERVER_PORT = 8090;

    public void startServer() {
        try {

            System.out.println("HelloWorld TSimpleServer start ....");

            //1 创建TProcessor
            TProcessor tprocessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldServiceImpl());

            // HelloWorldService.Processor&lt;HelloWorldService.Iface&gt; tprocessor =
            // new HelloWorldService.Processor&lt;HelloWorldService.Iface&gt;(
            // new HelloWorldServiceImpl());

            // 简单的单线程服务模型，一般用于测试

            //2 创建TServerTransport
            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);

            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.processor(tprocessor);

            //3 创建TProtocol
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            // tArgs.protocolFactory(new TCompactProtocol.Factory());
            // tArgs.protocolFactory(new TJSONProtocol.Factory());

            //简单的单线程服务模型

            //4 创建TServer
            TServer server = new TSimpleServer(tArgs);
            //5 启动Server
            server.serve();

        } catch (Exception e) {
            System.out.println("Server start error!!!");
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        HelloServerDemo server = new HelloServerDemo();
        server.startServer();
    }

}
