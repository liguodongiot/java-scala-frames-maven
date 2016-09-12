package czbk.v12;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by liguodong on 2016/9/12.
 */
public class ReadWriteLockMain {

    public static void main(String[] args) {
        final Queue3 queue3 = new Queue3();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                public void run() {
                    while(true){
                        queue3.get();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                public void run() {
                    while(true){
                        queue3.put(new Random().nextInt(5000));
                    }
                }
            }).start();

        }

    }

}


class Queue3{
    //共享数据，只能有一个线程写数据，但可以有多个线程读数据。
    private Object data = null;

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void get(){
        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"线程准备读取数据。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"线程读取完毕。"+data);
        readWriteLock.readLock().unlock();
    }

    public void  put(Object data){
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"线程准备写数据。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
        System.out.println(Thread.currentThread().getName()+"线程写完毕。");

        readWriteLock.writeLock().unlock();
    }


}