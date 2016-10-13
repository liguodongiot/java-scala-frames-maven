package com.lgd.io.bufferTransition;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流：字节转为字符
 * 1、输出流OutputStreamWriter  编码
 * 2、输入流InputStreamReader  解码
 */

public class ConverDemo {

    public static void main(String[] args) throws IOException {
        //输入文件  解码 (字节到字符)   读取  要显示
        //指定解码字符集    BufferedReader字符流--InputStreamReader转换流--FileInputStream字节流
        BufferedReader br = new BufferedReader
                (
                        new InputStreamReader
                                (
                                        new FileInputStream(new File("D:/writer.txt")),"UTF-8"
                                )
                );//指定字符解码集

        //写出文件     编码（字符到字节）
        BufferedWriter bw = new BufferedWriter
                (
                        new OutputStreamWriter
                                (
                                        new FileOutputStream(new File("D:/abdec.txt")),"UTF-8"
                                )
                );

        String info = null;
        while(null!=(info = br.readLine()))
        {
            System.out.println(info);
            bw.write(info+"\r\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}