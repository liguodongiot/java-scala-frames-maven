package czbk.v21;

/**
 * Created by liguodong on 2016/9/25.
 */
public class TestBefore {

    public static void main(String[] args) {
        System.out.println("begin:"+(System.currentTimeMillis()/1000));
        for (int i = 0; i < 10; i++) {//代码不能动
            String input = i + "";//代码不能动    //生产者
            String output = TestDo.doSome(input);//消费者
            System.out.println(Thread.currentThread().getName()+":"+output);
        }
    }

}



