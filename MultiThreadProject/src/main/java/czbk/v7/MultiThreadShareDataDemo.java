package czbk.v7;

/**
 * 设计4个线程，启动两个线程每次对j增加1，
 * 另外两个线程每次对j减少1。
 *
 *
 * 本题采用的方式是内部类共享外部类的成员变量
 * Created by liguodong on 2016/3/13.
 */
public class MultiThreadShareDataDemo {

    private int j;

    public static void main(String[] args) {

        MultiThreadShareDataDemo tt = new MultiThreadShareDataDemo();

        Inc inc = tt.new Inc();
        Dec dec = tt.new Dec();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(inc);
            t.start();
            t = new Thread(dec);
            t.start();
        }

    }


    public synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName()+"-inc:"+j);

    }

    public synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName()+"-inc:"+j);

    }

    class Inc implements Runnable{

        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable{

        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }

}
