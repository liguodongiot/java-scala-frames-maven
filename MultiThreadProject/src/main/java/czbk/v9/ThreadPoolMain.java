package czbk.v9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by liguodong on 2016/9/11.
 */
public class ThreadPoolMain {

    public static void main(String[] args) {

        //固定的线程数
        //ExecutorService threadPool = Executors.newFixedThreadPool(3);//3个线程

        //多态变化的线程数
        ExecutorService threadPool = Executors.newCachedThreadPool();

        //创建单一线程池  好处：线程死了之后能够重新创建一个新的线程。
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();


        //把十个任务扔进线程池，只有3个任务执行。
        for (int i = 0; i < 10; i++) {//每一次循环往池子里面扔一个任务
            final int task = i;
            threadPool.execute(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+" loop "+j+" task "+task);
                    }
                }
            });
        }
        System.out.println("十个任务被提交。");

        //关闭所有线程
        threadPool.shutdown(); //事情干完了结束
        //threadPool.shutdownNow();//线程没干完就结束掉

        //定时器
        Executors.newScheduledThreadPool(3).schedule(
                new Runnable() {
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            System.out.println("bong..."+i);
                        }
                    }
                },
                10, //时间
                TimeUnit.SECONDS  //单位
        );

        //每隔多久执行一次
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(
                new Runnable() {
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            System.out.println("bong..."+i);
                        }
                    }
                },
                10, //时间
                2, //每个多少秒执行一次
                TimeUnit.SECONDS  //单位
        );




    }




}


