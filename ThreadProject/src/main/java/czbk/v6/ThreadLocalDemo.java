package czbk.v6;


import java.util.Random;

/**
 *
 * ThreadLocal实现线程范围的共享变量
 *
 * 总结：一个ThreadLocal代表一个变量，故其中只能放一个数据，你有两个变量都要线程范围内共享，
 * 则要定义两个ThreadLocal对象，
 * 如果有100个变量要线程共享呢？那请先定义一个对象来装这100个变量，然后在ThreadLocal中存储这一个对象。
 * Created by liguodong on 2016/3/3.
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();

    private static ThreadLocal<MyThreadScopeData> myThreadScopeData = new ThreadLocal<MyThreadScopeData>();


    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new Thread(new Runnable(){
                //@Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()
                            + " has put data :" + data);
                    x.set(data);

                    MyThreadScopeData myData = new ThreadLocalDemo().new MyThreadScopeData();
                    myData.setName("Name:"+data);
                    myData.setAge(data);
                    myThreadScopeData.set(myData);

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

            MyThreadScopeData temp = myThreadScopeData.get();
            System.out.println(temp.getName()+", Age:"+temp.getAge());

        }
    }

    static class B{
        public void get(){
            int data = x.get();
            System.out.println("B from " + Thread.currentThread().getName()
                    + " get data :" + data);

            MyThreadScopeData temp = myThreadScopeData.get();
            System.out.println(temp.getName()+"Age:"+temp.getAge());
        }
    }

    class MyThreadScopeData{
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


}



