package com.lgd.strs;

import org.junit.Test;

/**
 * Created by liguodong on 2016/9/21.
 */
public class StringFormatUtilsTests {
    String mulDealId = "123,43,546";



    @Test
    public void testStringToList(){
        System.out.println(StringFormatUtils.stringToList(mulDealId,","));
    }

}
