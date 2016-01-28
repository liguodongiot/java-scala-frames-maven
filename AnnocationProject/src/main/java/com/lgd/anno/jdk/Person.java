package com.lgd.anno.jdk;

/**
 * Created by liguodong on 2016/1/26.
 */
public interface Person {

    public String name();

    public int age();

    @Deprecated //表示该方法已经过时
    public void sing();

}
