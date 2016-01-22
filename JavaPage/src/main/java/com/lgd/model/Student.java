package com.lgd.model;

import java.io.Serializable;
import java.util.Map;

/**
 * 继承Serializable接口，将光标移动到类上面，按alt+enter，自动提示生成serialVersionUID。
 * Created by liguodong on 2016/1/20.
 */
public class Student implements Serializable{

    private static final long serialVersionUID = -7666175621758588758L;

    public Integer id;
    public String name;
    private Integer age;
    private Integer gender;
    private String address;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, Integer gender, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public Student(Map<String,Object> map){
        this.id = (Integer)map.get("id");
        this.name = (String)map.get("name");
        this.age = (Integer)map.get("age");
        this.gender = (Integer)map.get("gender");
        this.address = (String)map.get("address");
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
