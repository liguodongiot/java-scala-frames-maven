package com.lgd.io.byteChar;

import org.joda.time.DateTime;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * 拷贝文件
 * 1、建立联系 File对象 源头 目的地
 * 2、选择流
 *      文件输入流
 *      文件输出流
 * 3、操作  拷贝
 *      byte[] flush = new byte[1024];
 *      int len = 0;
 *      while(-1!=(len=输入流.read(flush)))
 *      {
 *          输出流.write(flush,0,len);
 *      }
 *      输出流.flush
 * 4、释放资源：关闭两个流
 */

public class FileCopyByteDemo {

    final static String pathsrc = "D:/temp/dododo.jpg";
    final static String pathdest = "D:/forever/forever.jpg";

    public static void main(String[] args) {

        int index = pathdest.lastIndexOf("/");
        System.out.println(index);
        System.out.println(pathdest.substring(0,index));

        Long start = System.currentTimeMillis();

        try {
            copyFile(pathsrc, pathdest);//源-->目的地
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("拷贝文件失败|关闭输出流失败");
        }

        Long end = System.currentTimeMillis();

        System.out.println("Time:"+(end-start));
    }

    /**
     * 文件的拷贝
     */
    public static void copyFile(String srcPath, String destPath)
            throws FileNotFoundException, IOException {


        int index = pathdest.lastIndexOf("/");
        System.out.println(index);
        System.out.println(pathdest.substring(0,index));
        File destDir = new File(pathdest.substring(0,index));

        if(!destDir.isDirectory())//如果不是文件夹
        {
            //确保目标文件夹存在
            destDir.mkdirs();
        }

        //1、建立联系  源存在(且为文件)+目的地(文件可以不存在)
        File src = new File(srcPath);
        File dest = new File(destPath);
        if (!src.isFile()) {
            System.out.println("只能拷贝文件");
            throw new IOException("只能拷贝文件");
        }


        //2、选择流
        InputStream is = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dest);

        //3、文件拷贝  循环(读取+写出)
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush)))//读入
        {
            //写出
            os.write(flush, 0, len);
        }
        os.flush();//强制刷出
        //关闭流 先打开后关闭
        os.close();
        is.close();
    }
}