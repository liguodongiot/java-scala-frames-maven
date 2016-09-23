package czbk.v13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程1执行10次 线程2执行20次，线程3执行30次
 * Created by liguodong on 2016/9/20.
 */

public class ThreeConditionCommunication {


    public static void main(String[] args) {

        final ThreeBusiness business = new ThreeBusiness();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.subThread2(i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.subThread3(i);
                }
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            business.mainThread(i);
        }



    }


}

class ThreeBusiness{

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    private int shouldSub = 1;

    //主线程
    public void mainThread(int i){
        lock.lock();
        try{
            while(shouldSub!=1){
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int j = 1; j <= 10; j++) {
                System.out.println("main thread sequece of " + j + ",loop of " + i);
            }

            shouldSub = 2;
            condition2.signal();
        }finally {
            lock.unlock();
        }

    }

    //子线程
    public void subThread2(int i){
        lock.lock();
        try{
            while(shouldSub!=2){
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int j = 1; j <= 20; j++) {
                System.out.println("sub2 thread sequece of " + j + ",loop of " + i);
            }
            shouldSub = 3;
            condition3.signal(); //通知 线程3
        }finally {
            lock.unlock();
        }

    }

    public void subThread3(int i){
        lock.lock();
        try{
            while(shouldSub!=3){
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int j = 1; j <= 30; j++) {
                System.out.println("sub3 thread sequece of " + j + ",loop of " + i);
            }
            shouldSub = 1;
            condition1.signal(); //通知 线程1
        }finally {
            lock.unlock();
        }

    }

}

