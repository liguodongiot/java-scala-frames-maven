package com.lgd.jcip.chapter4;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * Created by liguodong on 2016/2/26.
 */
@NotThreadSafe
public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}