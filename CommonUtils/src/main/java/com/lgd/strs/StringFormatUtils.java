package com.lgd.strs;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liguodong on 2016/9/21.
 */
public class StringFormatUtils {

    private StringFormatUtils(){}

    //字符串转List
    public static List<String> stringToList(String str,String separator){
        return Arrays.asList(str.split(separator));
    }






}
