package com.lgd.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liguodong on 2016/1/28.
 */
public class RegexUtils {

    public static void PatternRegex(String line, String regex){

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);



        if (matcher.find()){
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }

    }



}
