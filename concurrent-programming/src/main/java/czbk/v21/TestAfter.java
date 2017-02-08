
package czbk.v21;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by liguodong on 2016/9/25.
 */
public class TestAfter {

    public static void main(String[] args) {

        final Semaphore semaphore = new Semaphore(1);//信号灯

        //SynchronousQueue 同步队列
        //每个插入操作必须有另一个线程相应的的读取操作
        final SynchronousQueue<String> queue = new SynchronousQueue<String>();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {

                    String input = null;
                    try {
                        semaphore.acquire();
                        input = queue.take(); //从队列中读取

                        String output = TestDo.doSome(input);//消费者
                        System.out.println(Thread.currentThread().getName()+":"+output);

                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

        System.out.println("begin:"+(System.currentTimeMillis()/1000));
        for (int i = 0; i < 10; i++) {//代码不能动
            String input = i + "";//代码不能动 //生产者
            try {
                queue.put(input); //放入同步队列
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}



