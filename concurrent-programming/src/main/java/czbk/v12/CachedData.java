package czbk.v12;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 利用重入来执行升级缓存后的锁降级
 *
 * Created by liguodong on 2016/9/14.
 */
public class CachedData {

    Object data;
    volatile boolean cacheValid;
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    void processCachedData() {
        rwl.readLock().lock();
        if (!cacheValid) {
            //写锁之前必须释放读锁
            // Must release read lock before acquiring write lock
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            // Recheck state because another thread might have acquired
            //   write lock and changed state before we did.
            if (!cacheValid) {
                data = 5;
                cacheValid = true;
            }
            //更新锁
            // Downgrade by acquiring read lock before releasing write lock
            rwl.readLock().lock();
            rwl.writeLock().unlock(); // Unlock write, still hold read
        }

        use(data);
        rwl.readLock().unlock();
    }


    public void use(Object obj){
        System.out.println("obj:"+obj);
    }


}
