package czbk.v2;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * quartz
 *
 * Created by liguodong on 2016/2/27.
 */
public class TraditionalTimerTest {


    public static void main(String[] args) {

        //定时器，10s以后会爆炸,之后每3s炸一下
        /*new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing");
            }
        },10000,3000);*/


        new Timer().schedule(new MyTimerTask(),2000);


        while(true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}


class MyTimerTask extends TimerTask{
    static int count = 0;

    @Override
    public void run() {

        count = (count+1)%2;

        System.out.println("bombing");

        new Timer().schedule(new MyTimerTask(),2000+2000*count);
    }
}