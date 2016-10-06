package com.lgd.guava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liguodong on 2016/10/6.
 */
public class OnlyReadList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("liyanan");
        list.add("likexin");
        list.add("tangzhizhang");

        //对原有的List进行包装，相当于原有List的视图，快照,不够安全.
        List<String> readList = Collections.unmodifiableList(list);
        //java.lang.UnsupportedOperationException
        //readList.add("d");//报错
        list.add("d");//改变原有List   视图也一起改变  不报错
        System.out.println(readList);

        //Guava
        //对比查看  初始化List guava为只读设置安全可靠 并且相对简单
        List<String> immutableList = ImmutableList.of("a","b","c");
        //java.lang.UnsupportedOperationException
        //immutableList.add("d");//报错
        System.out.println(immutableList);
    }

}
