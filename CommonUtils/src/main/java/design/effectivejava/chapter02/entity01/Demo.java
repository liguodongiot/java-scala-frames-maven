package design.effectivejava.chapter02.entity01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by liguodong on 2016/12/2.
 */
public class Demo {

    public static final Boolean TRUE = new Boolean(true);
    public static final Boolean FALSE = new Boolean(false);

    //Boolean
    public static Boolean valueOf(boolean b) {
        return (b ? TRUE : FALSE);
    }

    public static void main(String[] args) {

        //BigInteger.probablePrime

        //Collection

        //ArrayList
        List<String> list = new ArrayList<>();

        //-128至127 缓存在IntegerCache 的 Integer数组中
        Integer.valueOf(1);



    }

}
