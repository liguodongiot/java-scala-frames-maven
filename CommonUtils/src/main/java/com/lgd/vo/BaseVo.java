package com.lgd.vo;

/**
 * Created by liguodong on 2016/7/11.
 */
public class BaseVo {

    public String name;
    public int age;
    public double price;
    public Float discount;

    public BaseVo() {
    }

    public BaseVo(String name, int age, double price, Float discount) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.discount = discount;
    }

    /**
     * BaseVo{name='null', age=0, price=0.0, discount=null}
     * BaseVo{(\w+?)=(.+?), (\w+?)=(.+?), (\w+?)=(.+?), (\w+?)=(.+?)
     *
     * @return
     */

    @Override
    public String toString() {
        return "BaseVo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
