package czbk.v15;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by liguodong on 2016/9/24.
 */
public class CyclicBarrierMain {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        Thread.sleep((long)Math.random()*10000);
                        System.out.println("线程"+ Thread.currentThread().getName()+
                        "即将到达集合地点1，当前已有"+(cyclicBarrier.getNumberWaiting()+1)+ "个人已经达到，"
                                +(cyclicBarrier.getNumberWaiting()==2?"都到齐了，继续走吧":"正在等候。"));

                        cyclicBarrier.await();
                        Thread.sleep((long)Math.random()*10000);
                        System.out.println("线程"+ Thread.currentThread().getName()+
                                "即将到达集合地点2，当前已有"+(cyclicBarrier.getNumberWaiting()+1)+"个人已经达到，"
                                +(cyclicBarrier.getNumberWaiting()==2?"都到齐了，继续走吧":"正在等候。"));
                        cyclicBarrier.await();
                        Thread.sleep((long)Math.random()*10000);
                        System.out.println("线程"+ Thread.currentThread().getName()+
                                "即将到达集合地点3，当前已有"+(cyclicBarrier.getNumberWaiting()+1)+"个人已经达到，"
                                +(cyclicBarrier.getNumberWaiting()==2?"都到齐了，继续走吧":"正在等候。"));
                        cyclicBarrier.await();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };

            service.execute(runnable);

        }
        service.shutdown();


    }

}
