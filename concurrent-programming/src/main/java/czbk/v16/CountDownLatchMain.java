package czbk.v16;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liguodong on 2016/9/24.
 */
public class CountDownLatchMain {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        System.out.println("线程"+Thread.currentThread().getName()+
                        "正准备接受命令。");
                        cdOrder.await(); //等待计数器为0，则继续向下执行。
                        System.out.println("线程"+Thread.currentThread().getName()+
                                "已接受命令。");
                        Thread.sleep((long)(Math.random()*10000));

                        cdAnswer.countDown();
                        System.out.println("线程"+Thread.currentThread().getName()+
                                "回应命令处理结果。");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
        }

        try {
            Thread.sleep((long)(Math.random()*10000));
            System.out.println("线程"+Thread.currentThread().getName()+
                    "即将发布命令。");
            cdOrder.countDown();  //一个线程通知多个线程
            System.out.println("线程"+Thread.currentThread().getName()+
                    "已发布命令，正在等待结果。");


            cdAnswer.await();  //一个线程等待多个线程结束
            System.out.println("线程"+Thread.currentThread().getName()+
                    "已收到所有相应结果。");

        }catch (Exception e){
            e.printStackTrace();
        }
        executorService.shutdown();
    }


}
