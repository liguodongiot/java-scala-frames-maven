package com.lgd.random;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by liguodong on 2016/7/14.
 */
public class GenerateRandomUtils {


    /**
     * 生成随机长度的字符和数字
     * @param length
     * @return
     */

    public static String generateRandomStrInt(int length) { //length表示生成字符串的长度

        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        Random random = new Random();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成随机长度的字符
     *
     * @param length
     * @return
     */

    public static String generateRandomStr(int length) { //length表示生成字符串的长度

        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        Random random = new Random();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


    /**
     * 生成0~range范围的整数
     *
     * @param range
     * @return
     */
    public static int generateRandomInt(int range){
        Random random = new Random();

        return random.nextInt(range);
    }


    /**
     * 取某个范围的任意整数
     *
     * @param min
     * @param max
     * @return
     */
    public static int generateRandomRangeInt(int min, int max)
    {
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;

    }


    public static Double generateRandomDouble(int range)
    {
        Random random = new Random();

        return random.nextDouble()*range;
    }

    public static Float generateRandomFloat(int range)
    {
        Random random = new Random();

        return random.nextFloat()*range;
    }


    /**
     * 生成指定时间段的日期
     * generateRandomDate("2012-06-01", "2012-12-12")
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static String generateRandomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);// 开始日期
            Date end = format.parse(endDate);// 结束日期

            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            Date resultDate = new Date(date);
            return format.format(resultDate);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtnn = begin + (long) (Math.random() * (end - begin));
        if (rtnn == begin || rtnn == end) {
            return random(begin, end);
        }
        return rtnn;
    }




    public static void main(String[] args) {

        System.out.println(generateRandomStrInt(10));
        System.out.println(generateRandomStr(10));
        System.out.println(generateRandomInt(50));
        System.out.println(generateRandomRangeInt(100, 200));
        System.out.println(generateRandomDouble(50));
        System.out.println(generateRandomFloat(50));



        String randomDate = generateRandomDate("2012-06-01", "2012-12-12");

        System.out.println(randomDate);

    }

}
