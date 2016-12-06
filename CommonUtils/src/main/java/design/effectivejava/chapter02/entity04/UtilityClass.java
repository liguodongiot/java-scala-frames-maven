package design.effectivejava.chapter02.entity04;

/**
 * Created by liguodong on 2016/12/5.
 */
//不可实例化工具类
public class UtilityClass {

    //强制默认的构造器不可实例化
    private UtilityClass(){
        //断言错。用来指示一个断言失败的情况。
        throw new AssertionError();
    }


}
