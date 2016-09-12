package czbk.v6;

import java.util.Random;

/**
 * 创建线程范围内的数据共享。
 *
 * 多个变量数据共享（更优雅的方式）
 * Created by liguodong on 2016/3/12.
 */
public class ShareThreadOpt {


   //private static ThreadLocal<MyThreadScopeData> myThreadScopeData = new ThreadLocal<MyThreadScopeData>();


    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new Thread(new Runnable(){
                //@Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()
                            + " has put data :" + data);

                    MyThreadScopeData.getThreadInstance().setName("Name: " + data);
                    MyThreadScopeData.getThreadInstance().setAge(data);

                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A{
        public void get(){

            MyThreadScopeData temp = MyThreadScopeData.getThreadInstance();
            System.out.println("A from " + Thread.currentThread().getName()
                    + " " + temp.getName()+", Age:"+temp.getAge());

        }
    }

    static class B{
        public void get(){

            MyThreadScopeData temp = MyThreadScopeData.getThreadInstance();
            System.out.println("B from " + Thread.currentThread().getName()
                    + " " + temp.getName()+",Age:"+temp.getAge());
        }
    }


}

class MyThreadScopeData{

    //private  static MyThreadScopeData instance = null;//new MyThreadScopeData();

    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();

    private MyThreadScopeData(){
    }

    //synchronized不用加线程同步，因为是自己线程去自己线程的数据，
    // 线程之间互不影响。
    public static /*synchronized*/ MyThreadScopeData getThreadInstance(){
        MyThreadScopeData instance = map.get();
        if(instance == null){
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }


    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}