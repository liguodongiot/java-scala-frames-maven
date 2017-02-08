package design.pattern.singleton;

import org.junit.Test;

/**
 * Created by liguodong on 2016/11/4.
 */
public class EnumSingletonTests {

    @Test
    public void testEnum(){
        EnumSingleton s1 = EnumSingleton.INSTANCE;

        System.out.println("第一次会加载。。。");

        EnumSingleton s2 = EnumSingleton.INSTANCE;

        System.out.println(s1);
        System.out.println(s2);

        //EnumSingleton s3 = EnumSingleton.INSTANCE(100);
        System.out.println(EnumSingleton.INSTANCE==EnumSingleton.INSTANCE);


        //声明以上的枚举后，
        // 我们可以通过INSTANCE来调用它内部声明的addVar和getVar等方法，
        // 所有的这些都和普通类没有什么区别，除了它的构造函数。
        EnumSingleton.INSTANCE.enumOperation();

        EnumSingleton.INSTANCE.addVar(100);
        EnumSingleton.INSTANCE.addVar(1000);
        System.out.println(EnumSingleton.INSTANCE.getVar());


    }

}
