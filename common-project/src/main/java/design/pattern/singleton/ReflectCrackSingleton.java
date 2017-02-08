package design.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射破解单例
 *
 * Created by liguodong on 2016/11/3.
 */
public class ReflectCrackSingleton {

    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        HungryManSingleton singleton1 = HungryManSingleton.getInstance();
        HungryManSingleton singleton2 = HungryManSingleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);

        //反射破解单例
        Class<HungryManSingleton>  clazz = (Class<HungryManSingleton>)Class.forName("design.pattern.singleton.HungryManSingleton");
        Constructor< HungryManSingleton> c = clazz.getDeclaredConstructor(null);
        //反射不能访问私有的成员，可以跳过权限的检查，可以访问私有的。
        c.setAccessible(true);
        HungryManSingleton crackSingleton1  = c.newInstance();
        System.out.println(crackSingleton1);

        HungryManSingleton crackSingleton2  = c.newInstance();
        System.out.println(crackSingleton2);

    }

}




