package com.lgd.jkxy.lambda;

/**
 * Created by liguodong on 2016/1/31.
 */
public class LambdaMain {

    public static void main(String[] args) {
        runnableTest();
        defineTest();
    }

    /**
     * 用lambda简化Runnable接口的实现方式
     * 使用lambda可以直接使用外部的变量，但不运行修改外部变量的值，
     * 如果使用之前的匿名内部类的话，外部必须改为常量使用。
     */
    public static void runnableTest(){
        new Runnable(){
            @Override
            public void run() {
                System.out.println("匿名内部类实现runnable接口");
            }
        }.run();

        int i=1;
        Runnable r=()->{
            System.out.println("用lambda简化Runnable接口");
            System.out.println("i="+i);
        };

        r.run();
    }

    /**
     * lambda实现自定义接口，模拟登陆操作
     */
    public static void defineTest(){

        new Action(){
            @Override
            public void execute(String content) {
                System.out.println(content);
            }
        }.execute("Jdk8以前的匿名内部类方式实现登陆操作");


        Action login=(String content)->{
            System.out.println(content);
        };
        login.execute("Jdk8使用lambda方式实现登陆操作");


    }

    static interface Action{
        void execute(String content);
    }



}
