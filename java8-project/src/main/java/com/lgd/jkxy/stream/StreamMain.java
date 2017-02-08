package com.lgd.jkxy.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Stream在Java8中被定义为泛型接口
 * Stream接口代表数据流
 * Stream不是一个数据结构，不直接存储数据
 * Stream通过管道操作数据
 * 创建Stream接口实现类对象
 * Created by liguodong on 2016/1/31.
 */
public class StreamMain {


    public static void main(String[] args) {
        streamPerson();

    }


    /**
     * 创建一个元素Person类的集合：people
     * 使用Stream和forEach显示该集合所有元素
     *
     */
    public static void streamPerson(){
        List<Person> persons = createPerson();
        //过滤器
        persons.stream().filter(p->p.getGender()==Person.Sex.FEMALE)
                .forEach(p-> System.out.println(p.toString()));
    }





    //集合初始化
    static List<Person> createPerson(){
        List<Person> people = new ArrayList<>();
        Person p = new Person("张三丰",Person.Sex.MALE,55,1.66);
        people.add(p);
        p = new Person("风清扬",Person.Sex.MALE,88,1.76);
        people.add(p);
        p = new Person("小龙女",Person.Sex.FEMALE,18,1.70);
        people.add(p);
        p = new Person("天山童姥",Person.Sex.FEMALE,99,1.55);
        people.add(p);
        return people;
    }




}
