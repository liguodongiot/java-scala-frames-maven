package czbk.v18;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 两个具有一个空间的队列来实现同步通知功能。
 * Created by liguodong on 2016/9/25.
 */
public class BlockingQueueCommunication {

    public static void main(String[] args) {
        final Bussiness bussiness = new Bussiness();

        new Thread(
                new Runnable() {

                    public void run() {
                        for (int i = 0; i < 50; i++) {
                            bussiness.sub(i);
                        }
                    }
                }
        ).start();


        for (int i = 0; i < 50; i++) {
            bussiness.main(i);
        }
    }

    static class Bussiness{
        BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(1);
        BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1);

        //匿名构造方法，在任何构造方法之前运行。
        {
            try {
                queue2.put(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }


        public void sub(int i){

            try{
                queue1.put(1);
            }catch(InterruptedException e){
               e.printStackTrace();
            }


            for (int j = 0; j < 10; j++) {
                System.out.println("sub "+"j:"+j+",i:"+i);
            }

            try {
                queue2.take();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        public void main(int i){

            try{
                queue2.put(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }


            for (int j = 0; j < 100; j++) {
                System.out.println("main "+"j:"+j+",i:"+i);
            }

            try{
                queue1.take();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }

}
