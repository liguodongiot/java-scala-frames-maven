package com.lgd.maven;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by liguodong on 2016/1/18.
 */

public class HelloWorldTest {

    @Test
    public void testSayHello(){
        Assert.assertEquals("liguodong",new HelloWorld().sayHello("liguodong"));
    }
}
