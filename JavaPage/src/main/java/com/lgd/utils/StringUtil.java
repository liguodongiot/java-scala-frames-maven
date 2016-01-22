package com.lgd.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liguodong on 2016/1/21.
 */
public class StringUtil {

    /**
     * 校验字符串是否是大于0的数字
     * @param string
     * @return
     */
    public static boolean isNum(String string){
        Pattern pattern = Pattern.compile("[1-9]{1}\\d*");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}