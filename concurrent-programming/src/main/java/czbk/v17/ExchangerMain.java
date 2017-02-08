package czbk.v17;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liguodong on 2016/9/24.
 */
public class ExchangerMain {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Exchanger exchanger = new Exchanger();

        executorService.execute(new Runnable() {
            public void run() {
                try {
                    String  data1 = "zzz";
                    System.out.println("线程"+Thread.currentThread().getName()+
                            "正在把数据"+data1+"换出去。");

                    String data2 = (String) exchanger.exchange(data1);
                    System.out.println("线程"+Thread.currentThread().getName()+
                    "换回的数据为"+data2);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                try {
                    String  data1 = "yyy";
                    System.out.println("线程"+Thread.currentThread().getName()+
                            "正在把数据"+data1+"换出去。");

                    String data2 = (String) exchanger.exchange(data1);
                    System.out.println("线程"+Thread.currentThread().getName()+
                            "换回的数据为"+data2);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

       executorService.shutdown();

    }

}
