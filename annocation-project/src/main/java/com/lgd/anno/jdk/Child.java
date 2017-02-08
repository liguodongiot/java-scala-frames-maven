package com.lgd.anno.jdk;

/**
 * Created by liguodong on 2016/1/26.
 */
public class Child implements Person {


    @Override  //重写父类的方法
    public String name() {
        return null;
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void sing() {

    }
}
