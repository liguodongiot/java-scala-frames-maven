package czbk.v7;

/**
 *
 * 将这些执行不同代码的Runnable对象作为内部类。内部类能够共享外部类成员变量。
 *
 *
 * Created by liguodong on 2016/3/13.
 */
public class MultiThreadShareData2 {

    private static ShareData3 data3 = new ShareData3();

    public static void main(String[] args) {


        //final ShareData3 data3 = new ShareData3();

        //Runnable作为内部类
        new Thread(new Runnable() {
            public void run() {
                data3.decrement();
            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                data3.increment();
            }
        }).start();
    }


}


class ShareData3 {
    private int j=0;
    public synchronized void increment(){
        j++;
        System.out.println("++"+j);
    }

    public synchronized void decrement(){
        j--;
        System.out.println("--"+j);
    }
}