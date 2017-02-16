package com.lgd.common;

import java.io.PrintStream;

/**
 * Created by liguodong on 2016/12/29.
 */
public class Demo001 {

    public static void main(String[] args) {

        int a = 10;
        int b = 10;
        //需要在method方法调用后仅打印a=100,b=200,请写出method方法的代码
        method(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);

    }

    public static void method(int a, int b)
    {
        PrintStream myStream = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                if (x.startsWith("a=")) {
                    super.println("a=100");
                } else if (x.startsWith("b=")) {
                    super.println("b=200");
                } else {
                    super.println(x);
                }

            }
        };
        System.setOut(myStream);
    }

}


