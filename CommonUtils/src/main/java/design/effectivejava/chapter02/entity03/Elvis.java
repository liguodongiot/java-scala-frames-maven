package design.effectivejava.chapter02.entity03;

/**
 * 私有构造器强化单例
 * Created by liguodong on 2016/12/5.
 */

//第一种 final域
//Singleton with public final field
public class Elvis {

    public static final Elvis INSTANCE = new Elvis();

    private Elvis(){

    }

    public void leaveTheBuild(){

    }
}
