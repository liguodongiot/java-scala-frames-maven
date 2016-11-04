package design.pattern.singleton;

import org.junit.Test;

/**
 * Created by liguodong on 2016/11/3.
 */

public class StaticInnerSingletonTests {

    @Test
    public void test(){
        System.out.println(StaticInnerSingleton.getOther());

        StaticInnerSingleton.getInstance();

    }


}


