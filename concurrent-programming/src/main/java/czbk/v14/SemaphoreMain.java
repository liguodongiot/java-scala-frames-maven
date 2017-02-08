package czbk.v14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by liguodong on 2016/9/21.
 */
public class SemaphoreMain {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                public void run() {

                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //availablePermits 可获得的灯
                    System.out.println("线程："+Thread.currentThread().getName()+
                    "进入，当前已有"+(3-semaphore.availablePermits())+"个线程进入。");

                    try {
                        Thread.sleep((long)(Math.random()*10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程："+Thread.currentThread().getName()+
                    "即将离开。");
                    semaphore.release();

                    //下面代码有时执行不准确，没有合成原子
                    System.out.println("线程："+Thread.currentThread().getName()+
                            "已离开，当前已有"+(3-semaphore.availablePermits())+"个线程进入。");

                }
            };
            executorService.execute(runnable);

        }

        executorService.shutdown();

    }

}
