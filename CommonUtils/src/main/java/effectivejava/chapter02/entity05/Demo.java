package effectivejava.chapter02.entity05;

/**
 * Created by liguodong on 2016/12/5.
 */
public class Demo {

    public static void main(String[] args) {

        //Map
        //HashMap


        long sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }

        System.out.println(sum);

    }


}
