package com.lgd.io.bufferTransition;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理流（字节缓冲流）
 * 字节流文件拷贝+缓冲流，提高性能
 * 缓冲流（节点流）
 */


public class ByteBufferDemo {
    public static void main(String[] args) {
        String srcPath = "D:/temp/dododo.jpg";
        String destPath = "D:/try/dododo.jpg";
        Long start = System.currentTimeMillis();

        try {
            copyFile(srcPath,destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Long end = System.currentTimeMillis();

        System.out.println("Time:"+(end-start));

    }
    public static void copyFile(String srcPath,String destPath) throws IOException
    {

        int index = destPath.lastIndexOf("/");
        System.out.println(index);
        System.out.println(destPath.substring(0,index));
        File destDir = new File(destPath.substring(0,index));

        if(!destDir.isDirectory())//如果不是文件夹
        {
            //确保目标文件夹存在
            destDir.mkdirs();
        }

        //1、建立联系  源存在(且为文件)+目的地(文件可以不存在)
        File src = new File(srcPath);
        File dest = new File(destPath);
        if(!src.isFile())
        {
            System.out.println("只能拷贝文件");
            throw new IOException("只能拷贝文件");
        }

        //2、选择流 缓冲流(字节输入流)
        InputStream is = new BufferedInputStream(new FileInputStream(src));
        OutputStream os =new BufferedOutputStream(new FileOutputStream(dest)) ;

        //3、文件拷贝  循环+读取+写出
        byte[] flush = new byte[1024];
        int len = 0;
        while(-1!=(len = is.read(flush)))
        {
            //写出
            os.write(flush,0,len);
        }
        os.flush();//强制刷出
        //关闭流 先打开后关闭
        os.close();
        is.close();
    }
}