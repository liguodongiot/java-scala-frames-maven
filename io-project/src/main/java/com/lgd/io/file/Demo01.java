package com.lgd.io.file;

import java.io.File;

/**
 * 两个常量
 * 1、路径分隔符  ;
 * 2、名称分隔符     \ (windows)    /(linux等)
 */

@SuppressWarnings("all")
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        //路径表示形式
        String path = "E:\\xp\\test\\2.jpg"; //不推荐

        //适合动态生成时使用
        path = "E:"+File.pathSeparator+"win7"+File.separator+"test"+File.separator+"2.jpg";
        path = "E:/win7/test/2.jpg";//推荐使用
    }
}
