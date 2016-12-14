package effectivejava.chapter02.entity03;

/**
 * Created by liguodong on 2016/12/5.
 */

//公有成员是静态工厂
public class ElvisTwo {
    private static final ElvisTwo INSTANCE = new ElvisTwo();

    private ElvisTwo(){
    }

    public static ElvisTwo getInstance(){
        return INSTANCE;
    }

    public void leaveTheBuild(){
    }


}
