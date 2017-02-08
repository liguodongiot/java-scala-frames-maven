package design.pattern.singleton;

import java.io.*;

/**
 * 反序列化破解单例
 * Created by liguodong on 2016/11/3.
 */
public class SerializableCrackSingleton  {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HungryManSingleton hungryManSingleton1 = HungryManSingleton.getInstance();
        HungryManSingleton hungryManSingleton2 = HungryManSingleton.getInstance();
        System.out.println(hungryManSingleton1);
        System.out.println(hungryManSingleton2);

        //通过反序列化的方式构造多个对象
        FileOutputStream fos = new FileOutputStream("D:\\a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(hungryManSingleton1);
        oos.close();
        fos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\a.txt"));
        HungryManSingleton hungryManSingleton3 = (HungryManSingleton)ois.readObject();
        System.out.println(hungryManSingleton3);
    }


}
