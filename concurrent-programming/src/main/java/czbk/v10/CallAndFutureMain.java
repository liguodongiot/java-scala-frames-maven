package czbk.v10;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by liguodong on 2016/9/11.
 */
public class CallAndFutureMain {

    public static void main(String[] args)  {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        Future<String> futrue = threadPool.submit(new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(2000);
                return "hello,lady gaga";
            }
        });

        try {
            System.out.println("结果："+futrue.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        threadPool.shutdown();


        //任务组
        //创建线程池
        ExecutorService threadPoolGroup = Executors.newFixedThreadPool(10);

        //把线程池交给他
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPoolGroup);

        for (int i = 0; i < 10; i++) {
            final int seq = i;
            completionService.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return seq;
                }
            });
        }

        System.out.println("等待返回结果：");
        for (int i = 0; i < 10; i++) {
            try {
                //十个任务，拿十次结果，最先拿到运行完的。
                System.out.println(
                        completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }


        System.out.println("执行完毕！！！");
    }



}
