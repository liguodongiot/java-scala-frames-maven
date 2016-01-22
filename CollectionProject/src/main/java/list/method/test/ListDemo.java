package list.method.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liguodong on 2016/1/19.
 */

public class ListDemo {
    public static void main(String[] args) {
        addAllTests();

    }

    public static void addAllTests(){
        List<String> list1 = new ArrayList<String>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        List<String> list2 = new ArrayList<String>();
        list2.add("eee");
        list2.add("ddd");
        list2.add("ccc");


        List<String> listAll = new ArrayList<String>();
        listAll.addAll(list1);
        listAll.addAll(list2);
        System.out.println(listAll.size());
        System.out.println(listAll.toString());
    }

}
