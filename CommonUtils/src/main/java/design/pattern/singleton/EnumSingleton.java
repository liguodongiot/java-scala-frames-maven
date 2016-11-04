package design.pattern.singleton;

/**
 * 在Java中，为了强制只实例化一个对象，最好的方法是使用一个枚举量。
 * 这里有几个原因关于为什么在Java中宁愿使用一个枚举量来实现单例模式：
 * 1、 自由序列化；
 * 2、 保证只有一个实例（即使使用反射机制也无法多次实例化一个枚举量）；
 * 3、 线程安全；
 *
 * Created by liguodong on 2016/11/3.
 */
public enum  EnumSingleton {
    //这个枚举元素，本身就是单例对象！
    INSTANCE(100); //定义一个枚举的元素，就代表EnumSingleton的一个实例

    //enum不允许声明public的构造函数，
    //目的是防止程序中随意地实例化枚举对象，但是它可是声明private的构造函数.

    private EnumSingleton(){
        System.out.println("Loading...");
        mInstaceVar=101;
    }

    private int mInstaceVar = 0;

    private EnumSingleton(int var) {
        System.out.println("var:"+var);
        mInstaceVar = var;   // 给变量赋初值
    }

    //添加自己需要的操作
    public void enumOperation()
    {
        //功能处理
        System.out.println("hahaha...");
    }

    public void addVar(int increment) {
        mInstaceVar += increment;
    }

    public int getVar() {
        return mInstaceVar;
    }


}
