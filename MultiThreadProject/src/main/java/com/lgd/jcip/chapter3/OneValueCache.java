package com.lgd.jcip.chapter3;

import javax.annotation.concurrent.Immutable;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 对数值及其因数分解结果进行缓存的不可变容器类
 * Created by liguodong on 2016/2/26.
 */
@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i,
                         BigInteger[] factors) {
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i))
            return null;
        else
            return Arrays.copyOf(lastFactors, lastFactors.length);
    }
}