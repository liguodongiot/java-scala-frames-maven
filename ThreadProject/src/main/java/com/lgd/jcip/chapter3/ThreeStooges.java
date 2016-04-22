package com.lgd.jcip.chapter3;

import javax.annotation.concurrent.Immutable;
import java.util.HashSet;
import java.util.Set;

/**
 * 在可变对象的基础上构建不可变类
 * Created by liguodong on 2016/2/26.
 */

@Immutable
public final class ThreeStooges {
    private final Set<String> stooges = new HashSet<String>();

    public ThreeStooges(){
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooge(String name){
        return stooges.contains(name);
    }


}
