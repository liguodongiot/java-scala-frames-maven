package com.lgd.jcip.chapter4;

import javax.annotation.concurrent.GuardedBy;

/**
 * 通过一个私有锁来保护状态
 * Created by liguodong on 2016/2/26.
 */
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock") Widget widget;

    void someMethod() {
        synchronized (myLock) {
            // Access or modify the state of widget
            //访问或修改Wight的状态
        }
    }

    private class Widget {
    }
}