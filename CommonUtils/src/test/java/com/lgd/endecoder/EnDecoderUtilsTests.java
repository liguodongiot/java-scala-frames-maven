package com.lgd.endecoder;

import org.junit.Test;

/**
 * Created by liguodong on 2016/10/2.
 */
public class EnDecoderUtilsTests {

    @Test
    public void test(){

        String result = EnDecoderUtils.doubleDecode("%25E7%25BA%25BF%25E4%25B8%258B","iso-8859-1","utf-8");

        String resultvar = EnDecoderUtils.varDecode("%25E7%25BA%25BF%25E4%25B8%258B","iso-8859-1","utf-8","utf-8");


        String res = EnDecoderUtils.varEncode("线下","utf-8","iso-8859-1");
        EnDecoderUtils.varDecode(res,"iso-8859-1","utf-8");
    }


}
