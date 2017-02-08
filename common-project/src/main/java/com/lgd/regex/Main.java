package com.lgd.regex;

/**
 * Created by liguodong on 2016/1/28.
 */
public class Main {

    public static String[] logline ={};

    public static String regex = "(deal_id=)([0-9]{0,})";

    public static void main(String[] args) {

        for (int i = 0; i < logline.length; i++) {
            RegexUtils.PatternRegex(logline[i],regex);
        }
    }
}
