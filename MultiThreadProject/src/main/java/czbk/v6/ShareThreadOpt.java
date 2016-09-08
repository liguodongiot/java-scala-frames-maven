package czbk.v6;

import java.util.Random;

/**
 * 创建线程范围内的数据共享。
 * Created by liguodong on 2016/3/12.
 */
public class ShareThreadOpt {
    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();

   //private static ThreadLocal<MyThreadScopeData> myThreadScopeData = new ThreadLocal<MyThreadScopeData>();


    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new Thread(new Runnable(){
                //@Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()
                            + " has put data :" + data);
                    x.set(data);

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
            int data = x.get();
            System.out.println("A from " + Thread.currentThread().getName()
                    + " get data :" + data);

            MyThreadScopeData temp = MyThreadScopeData.getThreadInstance();
            System.out.println("A from " + Thread.currentThread().getName()
                    + " " + temp.getName()+", Age:"+temp.getAge());

        }
    }

    static class B{
        public void get(){
            int data = x.get();
            System.out.println("B from " + Thread.currentThread().getName()
                    + " get data :" + data);

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

    public static  MyThreadScopeData getThreadInstance(){
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