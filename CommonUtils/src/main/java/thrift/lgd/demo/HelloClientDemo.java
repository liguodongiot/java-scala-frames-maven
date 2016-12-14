package thrift.lgd.demo;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by liguodong on 2016/12/10.
 */

public class HelloClientDemo {

    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 8090;
    public static final int TIMEOUT = 30000;

    /**
     *
     * @param userName
     */
    public void startClient(String userName) {
        TTransport transport = null;
        try {

            //1 创建Transport
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            // 协议要和服务端一致
            //2 创建TProtocol
            TProtocol protocol = new TBinaryProtocol(transport);
            // TProtocol protocol = new TCompactProtocol(transport);
            // TProtocol protocol = new TJSONProtocol(transport);

            //3 基于TTransport和TProtocol创建 Client
            HelloWorldService.Client client = new HelloWorldService.Client(protocol);
            transport.open();

            //4 调用Client的相应方法
            String result = client.sayHello(userName);
            System.out.println("Thrify client result =: " + result);



        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        HelloClientDemo client = new HelloClientDemo();
        client.startClient("Michael");

    }

}