package com.lgd.datatype;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liguodong on 2016/9/21.
 */
public class StringFormatUtils {

    private StringFormatUtils(){}


    public static int strToInt(String str){
        return Integer.parseInt(str);
    }

    public static String intToStr(int i){
        return String.valueOf(i);
    }

    public static double strToDouble(String str){
        return Double.parseDouble(str);
    }

    public static String doubleToStr(double d){
        return String.valueOf(d);
    }

    public static boolean strToBoolean(String str){
        return Boolean.valueOf(str);
    }

    public static String booleanToStr(boolean b){
        return String.valueOf(b);
    }


//    public static Date strToDate(String str){
//        return DateFormat.parse(str);
//    }


    //字符串转List
    public static List<String> strToList(String str, String separator){
        return Arrays.asList(str.split(separator));
    }

    //字符串转数组
    public static String[] strToArr(String str,String separator){
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(str);
        String result = m.replaceAll("");
        return result.split(separator);
    }






}
