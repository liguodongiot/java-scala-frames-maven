package com.lgd.anno.jdk;

/**
 * Created by liguodong on 2016/1/26.
 */
public class Main {
    public static void main(String[] args) {

    }

    //忽略过时警告
    @SuppressWarnings("deprecation")
    public static void sing(){
        Person p = new Child();
        p.sing();
    }
}
