package design.pattern.singleton;

/**
 * 静态内部类式
 *
 * Created by liguodong on 2016/11/3.
 */
public class StaticInnerSingleton {

    //静态内部类实现单例
    public static class DemoClassInstance
    {
        //单例对象
        private static final StaticInnerSingleton instance = new StaticInnerSingleton();

        //类加载分为加载、链接、初始化三大步骤
        //其中链接又分为验证、准备和解析三个小步骤
        //类中静态的内容在编译阶段都会被编译到类构造函数<clinit>()中，在初始化步骤调用
        //因此这个代码块的调用标志着内部类被初始化了
        static{
            //该静态块用于验证内部类是否被初始化
            System.out.println("正在加载静态内部类中。。。");
        }

    }

    //私有化构造函数
    private StaticInnerSingleton()
    {
        //判断单例对象是否已经存在，用于控制非法反射单例类的构造函数
        if(DemoClassInstance.instance != null ){
            try{
                throw new IllegalAccessException("单例对象已经被实例化，请不要非法反射构造函数。。。");
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }
    }

    //方法没同步，调用效率高。
    public static StaticInnerSingleton getInstance()
    {
        return DemoClassInstance.instance;
    }

    public static String getOther()
    {

        return "Hello,World...";
    }

}
