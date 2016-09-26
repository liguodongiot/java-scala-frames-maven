package czbk.v22;

/**
 * Created by liguodong on 2016/9/25.
 */


public class TestDoBefore {

    private TestDoBefore(){}

    private static TestDoBefore _instance = new TestDoBefore();

    public static TestDoBefore getInstance(){
        return _instance;
    }



    public void doSome(Object key,String value){
        //以大括号内的是需要局部同步的代码，不能改动
        {
            try {
                Thread.sleep(1000);
                System.out.println(key+":"+value+":"+
                        (System.currentTimeMillis()/1000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }



    }

}
