package czbk.v7;

/**
 * 多线程之间共享数据的方式
 *
 *
 * Created by liguodong on 2016/3/13.
 *
 * Note:
 * 一、每个线程执行的代码相同
 * 如果每个线程执行的代码相同，可以使用同一个Runnable对象，
 * 此Runnable对象存在共享数据,
 * 如: 卖票程序可以这么做，因为都是执行减少的过程
 *
 *
 * 二、每个线程执行的代码不相同
 * 方法1：将需要共享的数据封装成一个对象，将该对象传给执行不同代码的Runnable对象。
 * 方法2：将这些执行不同代码的Runnable对象作为内部类。
 * 如：有4个线程，其中有2个线程对每次对j+1，有2个线程对每次对j-1。
 * 加减操作无顺序。
 */
public class MultiThreadShareData {

    //执行的代码相同
    /*
    public static void main(String[] args) {
        ShareData1 data1 = new ShareData1();
        new Thread(data1).start();
        new Thread(data1).start();
    }*/


    public static void main(String[] args) {
        final ShareData2 data2 = new ShareData2();

        new Thread(new MyRunnable1(data2)).start();
        new Thread(new MyRunnable2(data2)).start();



        /*new Thread(new Runnable() {
            public void run() {
                data2.decrement();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                data2.increment();
            }
        }).start();*/
    }

}

//////////////////////////////////
//执行的代码相同
class ShareData1 implements Runnable{


    private int count = 1000;

    public void run() {
        while(count>0){
            count--;
            System.out.println("当前线程："+
                    Thread.currentThread().getName()+
                    ",还剩"+count+"张。");
        }
    }
}


//////////////////////////////////
//执行的代码不同

/**
 * 将需要共享的数据封装成一个对象，
 * 将该对象传给执行不同代码的Runnable对象。
 */

class ShareData2 {
    private int j=0;
    public synchronized void increment(){
        j++;
    }

    public synchronized void decrement(){
        j--;
    }
}

class MyRunnable1 implements Runnable{

    private final ShareData2 data2;

    public MyRunnable1(ShareData2 data2){
        this.data2 = data2;
    }

    public void run() {
        data2.decrement();
    }
}

class MyRunnable2 implements Runnable{

    private final ShareData2 data2;

    public MyRunnable2(ShareData2 data2){
        this.data2 = data2;
    }

    public void run() {
        data2.increment();
    }
}

//////////////////////////////////