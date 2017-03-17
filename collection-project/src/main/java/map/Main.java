package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by liguodong on 2017/3/16.
 */
public class Main {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("1",1);
        map.put("2","33");
        System.out.println(map.toString());

        System.out.println(Double.parseDouble("111.0"));
    }

}
