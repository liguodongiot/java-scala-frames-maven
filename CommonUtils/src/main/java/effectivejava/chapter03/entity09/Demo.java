package effectivejava.chapter03.entity09;

import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liguodong on 2016/12/8.
 */

public class Demo {
    public static void main(String[] args) {
        Map<PhoneNumber,String> map = new HashMap<>();

        map.put(new PhoneNumber(707,867,5309),"Jenny");
        System.out.println(map.get(new PhoneNumber(707,867,5309)));

        String sa = null;
        map.put(new PhoneNumber(707,867,222),sa);
        System.out.println(map.get(new PhoneNumber(707,867,222)));
        //Integer

        DateTime dateTime = new DateTime("2015-10-10");
        System.out.println(dateTime.toString("yyyy-MM-dd"));

    }
}
