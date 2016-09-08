package czbk.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by liguodong on 2016/3/3.
 */
public class ThreadScopeShareDataTest {

    private static int data = 0;
    private static Map<Thread,Integer> threadData = new HashMap<Thread, Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                //@Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() +
                            " has put data: " + data);
                    threadData.put(Thread.currentThread(),data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }



    }

    static class A{
        public void get(){
            data = threadData.get(Thread.currentThread());
            System.out.println("A from "+Thread.currentThread().getName()
                    + " has put data: " + data);
        }
    }

    static class B{
        public void get(){
            data = threadData.get(Thread.currentThread());
            System.out.println("B from "+Thread.currentThread().getName()
                    + " has put data: " + data);
        }
    }
}
