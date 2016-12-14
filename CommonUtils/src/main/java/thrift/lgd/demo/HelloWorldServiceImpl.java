package thrift.lgd.demo;

import org.apache.thrift.TException;

/**
 * 实现接口Iface
 * Created by liguodong on 2016/12/10.
 */


public class HelloWorldServiceImpl implements HelloWorldService.Iface{

    public HelloWorldServiceImpl() {
    }

    @Override
    public String sayHello(String username) throws TException {
        return "Hi," + username + " welcome to my blog www.lgd.com";
    }
}
