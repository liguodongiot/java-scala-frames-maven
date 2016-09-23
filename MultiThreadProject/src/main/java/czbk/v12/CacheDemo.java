package czbk.v12;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by liguodong on 2016/9/17.
 */
public class CacheDemo {

    private Map<String,Object> cache = new HashMap<String,Object>();

    public static void main(String[] args) {

    }


    /*
    public synchronized Object getData(String key){
        Object value = cache.get(key);
        if(value == null){
            value = "......";
        }

        return value;
    }*/

    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    public Object getData(String key){
        rwl.readLock().lock();
        Object value = null;
        try{
            value = cache.get(key);
            if(value == null){
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try{
                    if(value == null){
                        value = "......";
                    }
                }finally {
                    rwl.writeLock().unlock();
                }
            }
        }finally {
            rwl.readLock().unlock();
        }
        return value;
    }

}
