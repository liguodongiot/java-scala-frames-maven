package design.pattern.singleton;

import java.io.*;

/**
 * 防止反序列化破解单例
 *
 * 可以通过定义readResolve() 防止获得不同对象。
 * 反序列化时，如果对象所在类定义了readReslove(),实际上是一种回调，定义返回那个对象。
 * Created by liguodong on 2016/11/3.
 */
public class SloveSerializableSingleton {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LazyManSingleton lazyManSingleton1 = LazyManSingleton.getInstance();
        System.out.println(lazyManSingleton1);


        //通过反序列化的方式构造多个对象
        FileOutputStream fos = new FileOutputStream("D:\\a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(lazyManSingleton1);
        oos.close();
        fos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\a.txt"));
        LazyManSingleton lazyManSingleton2 = (LazyManSingleton)ois.readObject();
        System.out.println(lazyManSingleton2);
    }

}
