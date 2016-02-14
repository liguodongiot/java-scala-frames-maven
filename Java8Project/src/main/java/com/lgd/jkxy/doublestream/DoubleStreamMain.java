package com.lgd.jkxy.doublestream;

import com.lgd.jkxy.stream.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * DoubleStream接口表示元素类型是double的数据源
 * 常用方法：
 * stream.max().getAsDouble():获取流中数据集的最大值
 * stream.min().getAsDouble():获取流中数据集的最小值
 * stream.average():获取流中数据集的平均值
 * Created by liguodong on 2016/1/31.
 */
public class DoubleStreamMain {

    public static void main(String[] args) {
        doubleStreamTest();
    }

    /**
     * 统计people集合中姓名中包含“菲”字的平均身高
     */
    public static void doubleStreamTest(){
        List<Person> persons = createPerson();
        //过滤器
        double avgHeight = persons.stream()
                .filter(p->p.getName().indexOf("菲")>=0)
                .mapToDouble(p->p.getHeight())
                .average()
                .getAsDouble();
        System.out.println("包含菲字的所有人的身高是："+avgHeight+"米");
    }

    //集合初始化
    static List<Person> createPerson(){
        List<Person> people = new ArrayList<>();
        Person p = new Person("巴菲特",Person.Sex.MALE,55,1.66);
        people.add(p);
        p = new Person("风清扬",Person.Sex.MALE,88,1.76);
        people.add(p);
        p = new Person("王菲",Person.Sex.FEMALE,18,1.70);
        people.add(p);
        p = new Person("刘亦菲",Person.Sex.FEMALE,99,1.55);
        people.add(p);
        return people;
    }
}


