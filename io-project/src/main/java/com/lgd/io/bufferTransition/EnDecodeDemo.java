package com.lgd.io.bufferTransition;

import java.io.UnsupportedEncodingException;

public class EnDecodeDemo {
    public static void main(String[] args) {
        test01();
        System.out.println("-----------");
        test02();
    }

    //解码与编码字符集字符集必须相同
    public static  void test01()
    {
        //解码byte-->char
        String str = "中国";//UTF-8
        //编码 char-->byte
        byte[] data = str.getBytes();
        //编码与解码的字符集统一
        System.out.println(new String(data));


        try {
            data  = str.getBytes("gbk");//设定编码字符集    编码
            //不统一字符集，出现乱码
            System.out.println(new String(data));//解码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] data2;
        try {
            //编码
            data2 = "中国".getBytes("GBK");
            //解码
            str = new String(data2,"GBK");
            //str = new String(data2);//不指定 默认解码UTF-8 会出现乱码
            System.out.println(new String(str));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    //字节缺少，长度丢失
    public static  void test02(){
        String str = "中国";
        byte[] data;
        data = str.getBytes();//编码
        //字节数不完整
        System.out.println(new String(data,0,4));

    }
}