package czbk.v21;

/**
 * Created by liguodong on 2016/9/25.
 */

//不能改动此TestDo类
public class TestDo {

    public static String doSome(String input){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        String output = input + ":" + (System.currentTimeMillis()/1000);
        return output;
    }

}
