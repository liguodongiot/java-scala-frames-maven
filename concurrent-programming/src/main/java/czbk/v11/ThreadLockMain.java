package czbk.v11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liguodong on 2016/2/28.
 */

public class ThreadLockMain {

    //在静态方法中，不能new内部类的实例对象
    //因为内部类，能够访问外部类的成员变量，一旦能够访问外部类的成员变量，
    //那么肯定存在外部类实例对象，因此，静态方法可以不用new实例对象出来。
    public static void main(String[] args) {

        new ThreadLockMain().init();

        /**
         * 不上锁，字符串会被打乱的
         * output:
         *  liguodong
         *  liguodonearth
         *  g
         *  earth
         */
    }


    public void init(){
        final OutPuter outPuter = new OutPuter();

        //线程1
        new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPuter.output("liguodong");
                }
            }
        }).start();


        //线程2
        new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPuter.output("earth");
                }
            }
        }).start();
    }


    class OutPuter{

        Lock lock = new ReentrantLock();

        public void output(String name){
            int len = name.length();
            lock.lock();//上锁
            try {
                for (int i=0;i<len;i++){
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }finally {
                lock.unlock();//无论如何都要释放锁
            }
        }

    }
}
