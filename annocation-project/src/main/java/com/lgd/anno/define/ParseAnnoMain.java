package com.lgd.anno.define;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by liguodong on 2016/1/27.
 */

public class ParseAnnoMain {

    public static void main(String[] args) {

        try {
            //1.使用类加载器加载类
            Class c = Class.forName("com.lgd.anno.define.EyeColor");

            //2.找到类上面的注解
            boolean isExist = c.isAnnotationPresent(Desciption.class);
            if(isExist){
                //3.拿到注解实例
                Desciption d = (Desciption) c.getAnnotation(Desciption.class);
                System.out.println(d.desc()+"<--->"+d.author()+"<--->"+d.age());

                //4.找到方法上的注解
                Method[] ms = c.getMethods();
                for(Method m:ms){
                    boolean isMExist = m.isAnnotationPresent(Desciption.class);
                    if(isMExist){
                        Desciption dm = (Desciption) m.getAnnotation(Desciption.class);
                        System.out.println(dm.desc()+"<--->"+dm.author()+"<--->"+dm.age());
                    }
                }

                //另外一种解析方法
                for(Method m:ms){
                    Annotation[] as = m.getAnnotations();
                    for (Annotation a:as){
                        if(a instanceof Desciption){
                            Desciption dm2 = (Desciption)a;
                            System.out.println(dm2.desc()+"<--->"+dm2.author()+"<--->"+dm2.age());

                        }
                    }
                }

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
