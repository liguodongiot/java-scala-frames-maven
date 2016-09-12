package czbk.v4;

/**
 * 子线程循环10次，主线程循环50次，再子线程循环10次，主线程循环50次，如此循环50次
 *
 * Created by liguodong on 2016/2/29.
 *
 * 两个线程执行的代码片段要实现同步互斥的效果，他们必须用同一个对象。
 * 锁是上在代表要操作资源的类的内部方法中，而不是线程代码中。
 */
public class TraditionalThreadCommunication {


    public static void main(String[] args) {

       final Business business = new Business();

       new Thread(new Runnable() {
           public void run() {
               for (int i = 1; i <= 50; i++) {
                   business.subThread(i);
               }
           }
       }).start();

        for (int i = 1; i <= 50; i++) {
            business.mainThread(i);
        }



    }



}


class Business{

    private boolean isShouldSub = true;

    //主线程
    public synchronized void mainThread(int i){

        //while(isShouldSub){ //while比if更好
        if(isShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int j = 1; j <= 100; j++) {
            System.out.println("main thread sequece of " + j + ",loop of " + i);
        }

        isShouldSub = true;
        this.notify();
    }

    //子线程
    public synchronized void subThread(int i){

        //while(!isShouldSub){
        if(!isShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int j = 1; j <= 10; j++) {
            System.out.println("sub thread sequece of " + j + ",loop of " + i);
        }
        isShouldSub = false;
        this.notify();
    }
}