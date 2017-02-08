package czbk.v9;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by liguodong on 2016/9/11.
 */
public class TimeMain {

    public static void main(String[] args) {

        //启动三个线程
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(3);

        for (int i = 0; i < 10; i++) {
            TimeTask timeTask = new TimeTask(i);
            scheduledExecutorService.schedule(timeTask,2, TimeUnit.SECONDS);
        }

        scheduledExecutorService.shutdown();
    }
}

class TimeTask implements Runnable {

    private int task;

    public TimeTask(){
    }

    public TimeTask(int task) {
        this.task = task;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("bong..."+ i + " task " + task);
        }
    }
}