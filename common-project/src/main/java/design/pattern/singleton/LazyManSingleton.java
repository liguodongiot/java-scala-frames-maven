package design.pattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 懒汉式
 * Created by liguodong on 2016/11/3.
 */
public class LazyManSingleton implements Serializable {

    //2 提供静态属性，类初始化，不加载对象，真正用到再创建。
    private static LazyManSingleton instance;

    //1 私有构造器。
    private LazyManSingleton()
    {
        System.out.println("Lazy loading...");
        //解决方式
        //当再次实例的时候抛出运行时异常。
        if(instance != null)
        {
            throw new RuntimeException();
        }
    }


    //3 提供方法    方法同步，调用效率低。
    public static synchronized LazyManSingleton getInstance()
    {
        System.out.println("懒加载之前。。。");
        if(instance == null)
        {
            instance = new LazyManSingleton();
        }
        System.out.println("懒加载之后。。。");
        return instance;
    }

    //在反序列时，如果定义了readResolve()
    //直接返回此方法指定的对象，而不需要把反序列化那个新对象返回。
    private Object readResolve() throws ObjectStreamException
    {
        return instance;
    }


}
