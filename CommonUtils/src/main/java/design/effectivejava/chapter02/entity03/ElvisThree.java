package design.effectivejava.chapter02.entity03;

import java.io.Serializable;

/**
 * Created by liguodong on 2016/12/5.
 */

//公有成员是静态工厂
public class ElvisThree implements Serializable{
    private static final ElvisThree INSTANCE = new ElvisThree();

    private ElvisThree(){
    }

    public static ElvisThree getInstance(){
        return INSTANCE;
    }

    public void leaveTheBuild(){
    }

    //在反序列时，如果定义了readResolve()
    //直接返回此方法指定的对象，而不需要把反序列化那个新对象返回。
    private Object readResolve(){
        return INSTANCE;
    }


}
