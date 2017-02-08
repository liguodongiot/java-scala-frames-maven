package design.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 防止反射破解单例
 * Created by liguodong on 2016/11/3.
 */
public class SloveReflectSingleton {

    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException, InterruptedException {
        LazyManSingleton singleton1 = LazyManSingleton.getInstance();
        System.out.println(singleton1);


        //解决反射破解单例
        Class<LazyManSingleton>  clazz = (Class<LazyManSingleton>)Class.forName("design.pattern.singleton.LazyManSingleton");
        Constructor< LazyManSingleton> c = clazz.getDeclaredConstructor(null);


        //反射不能访问私有的成员，可以跳过权限的检查，可以访问私有的。
        c.setAccessible(true);

        //第二次访问抛出运行时异常
        //LazyManSingleton crackSingleton1  = c.newInstance();
        //System.out.println(crackSingleton1);



    }

}
