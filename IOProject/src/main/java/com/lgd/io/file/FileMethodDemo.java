package com.lgd.io.file;

import java.io.File;
import java.io.IOException;

public class FileMethodDemo {

    public static void main(String[] args) {
        test01();
        System.out.println("========");
        test02();
        System.out.println("========");
        try {
            test03();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件操作失败");
        }
    }

    //1、获取文件名称
    public static void test01()
    {
        //File src = new File("E:/xp/test/2.jpg");
        File src = new File("test/2.txt");
        System.out.println(src.getName());//名称
        //如果是绝对路径，返回完整路径，否则相对路径
        System.out.println(src.getPath());

        //返回绝对路径
        System.out.println(src.getAbsolutePath());

        //返回上一级目录，如果是相对路径，可能返回null；如new File("2.txt");
        System.out.println(src.getParent());
    }

    //2、判断信息    读取相关信息，不是读取内容，而是位置，大小，占用空间，创建时间等属性
    public static void test02()
    {
        //String path = "2.txt";
        String path = "G:/love.txt";
        File src = new File(path);
        System.out.println("文件是否存在："+src.exists());
        //是否可读写
        System.out.println("文件是否可写："+src.canWrite());
        //isFile()、isDirectory()
        if(src.isFile())
        {
            System.out.println("文件");
        }
        else if(src.isDirectory()) {
            System.out.println("文件夹");
        }
        else {
            System.out.println("文件不存在");
        }
        System.out.println("是否为绝对路径："+src.isAbsolute());
        System.out.println("长度为："+src.length());//这个长度是字节数
    }

    //3、创建，删除文件
    public static void test03() throws IOException
    {
        //创建文件
        //con 系统关键字，不能创建成功。
        String path = "D:/100.txt";
        File src = new File(path);
        if(!src.exists())
        {
            boolean flag = src.createNewFile();
            System.out.println(flag?"创建成功":"创建失败");
        }

        //删除文件
        boolean flag = src.delete();
        System.out.println(flag?"删除成功":"删除失败");

        //static createTempFile(前缀3个字节长，后缀默认.temp) 默认临时空间
        //static createTempFile(前缀3个字节长，后缀默认.temp，目录)
        File temp = File.createTempFile("tes", ".temp",new File("D:/"));
        try {
            Thread.sleep(2000);
            temp.deleteOnExit();//退出即删除
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}