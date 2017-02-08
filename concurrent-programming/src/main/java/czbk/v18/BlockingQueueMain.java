package czbk.v18;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by liguodong on 2016/9/25.
 */
public class BlockingQueueMain {

    public static void main(String[] args) {

        final BlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        //两个线程放，一个线程取
        for (int i = 0; i < 2; i++) {
            new Thread(){
                public void run(){
                    while(true){
                        try{
                            Thread.sleep((long)(Math.random()*1000));
                            System.out.println(Thread.currentThread().getName()+
                            "准备放数据。");
                            blockingQueue.put(1);
                            System.out.println(Thread.currentThread().getName()+
                            "已经放了数据，"+"队里目前有"+blockingQueue.size()+"个数据。");



                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

        new Thread(){
            public void run(){
                while(true){
                    try {
                        //将此处的睡眠时间分别改为100和1000，观察运行结果。
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+
                                "准备取数据。");
                        blockingQueue.take();

                        System.out.println(Thread.currentThread().getName()+
                                "已经取走数据，"+ "队列目前有"+blockingQueue.size()+"个数据。");


                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }



}
