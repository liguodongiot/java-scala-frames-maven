package czbk.v3;

/**
 * Created by liguodong on 2016/2/28.
 */
public class TraditionalThreadSynchronized {

    //在静态方法中，不能new内部类的实例对象
    //因为内部类，能够访问外部类的成员变量，一旦能够访问外部类的成员变量，
    //那么肯定存在外部类实例对象，因为静态方法可以不用new实例对象出来。
    public static void main(String[] args) {

        new TraditionalThreadSynchronized().init();

        /**
         * output:
         *
         *  liguodong
         *  liguodonearth
         *  g
         *  earth
         */


    }


    public void init(){
        final OutPuter outPuter = new OutPuter();

        new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPuter.output("liguodong");
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPuter.output3("earth");
                }
            }
        }).start();
    }


    static class OutPuter{
        String xxx="";
        public void output(String name){
            int len = name.length();
            synchronized (OutPuter.class) //类的字节码也是一个对象
            //synchronized (this) //同样的效果
            //synchronized (xxx)//必须是锁同一个对象
            {
                for (int i=0;i<len;i++){
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }

        }

        public synchronized void output2(String name){
            int len = name.length();

            for (int i=0;i<len;i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        //静态方法只有与类的字节码关联
        public static synchronized void output3(String name){
            int len = name.length();

            for (int i=0;i<len;i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();

        }

    }

}
