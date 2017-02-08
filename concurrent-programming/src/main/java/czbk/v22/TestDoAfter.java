package czbk.v22;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by liguodong on 2016/9/25.
 */


public class TestDoAfter {

    private TestDoAfter(){}

    private static TestDoAfter _instance = new TestDoAfter();

    public static TestDoAfter getInstance(){
        return _instance;
    }



    //private ArrayList keys = new ArrayList();//线程不安全
    private CopyOnWriteArrayList keys = new CopyOnWriteArrayList();
    public void doSome(Object key,String value){

        Object o = key;
        if(!keys.contains(o)){
            keys.add(o);
        }else{
            for (Iterator iterator = keys.iterator();iterator.hasNext();){
                Object oo = iterator.next();
                if(oo.equals(o)){
                    o = oo;
                }
            }
        }

        synchronized (o)
        //以大括号内的是需要局部同步的代码，不能改动
        {
            try {
                Thread.sleep(1000);
                System.out.println(key+":"+value+":"+
                        (System.currentTimeMillis()/1000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }



    }

}
