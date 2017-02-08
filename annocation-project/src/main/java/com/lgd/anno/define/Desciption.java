package com.lgd.anno.define;

import java.lang.annotation.*;

/**
 * 使用 @interface关键字定义注解
 * 成员类型是受限的，和发的类型包括原始类型及
 * String,Class,Annotation,Enumeration
 *
 * 如果注解只有一个成员，
 * 则成员名必须取名为value(),在使用时可以忽略成员名和赋值号（=）。
 *
 * 注解类可以没有成员，没有成员的注解称为标识注解
 * Created by liguodong on 2016/1/27.
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Desciption {

    String desc(); //成员以无参无异常方式声明

    String author();

    int age() default 18; //可以用default为成员定义默认值
}

