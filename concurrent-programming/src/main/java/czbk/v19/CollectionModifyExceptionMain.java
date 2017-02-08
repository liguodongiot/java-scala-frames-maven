package czbk.v19;

import entity.User;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by liguodong on 2016/9/25.
 */
public class CollectionModifyExceptionMain {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("liguodong",123);

        //java5之前 线程安全的map
        Collections.synchronizedMap(map).get("111");


        //java5 之前，迭代是不能删除元素
        //Collection users = new ArrayList();


        //java5之后
        Collection users = new CopyOnWriteArrayList();

        users.add(new User("liguodong",2));
        users.add(new User("li",3));
        users.add(new User("dd",4));
        users.add(new User("gg",5));

        Iterator iterator =  users.iterator();

        while(iterator.hasNext()){
            User user = (User)iterator.next();
            if("gg".equals(user.getName())){
                users.remove(user);//迭代中不要删除元素，有异常
            }else {
                System.out.println(user);
            }

        }


    }


}
