package design.pattern.singleton;

import java.io.Serializable;

/**
 * 饿汉式
 * Created by liguodong on 2016/11/3.
 */
public class HungryManSingleton implements Serializable {

    //2 提供静态属性，类初始化，立即加载对象（没有延时加载的优势）。
    //由于加载类时，自然是线程安全的！
    private static HungryManSingleton instance  = new HungryManSingleton();

    //1 私有构造器。
    private HungryManSingleton() {

    }


    //3 提供方法    方法没有同步，调用效率高。
    public static HungryManSingleton getInstance() {
        return instance;
    }

}
