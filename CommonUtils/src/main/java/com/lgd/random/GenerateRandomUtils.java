package com.lgd.random;

import com.lgd.datatype.ObjectFormatUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by liguodong on 2016/7/14.
 */
public class GenerateRandomUtils {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(GenerateRandomUtils.class);

    private final static String baseCharInt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private final static String baseChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * 生成随机长度的字符和数字
     *
     * @param length
     * @return
     */
    public String generateRandomStrInt(Integer length) { //length表示生成字符串的长度
        Random random = new Random();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(baseCharInt.length());
            sb.append(baseCharInt.charAt(number));
        }
        return "\'".concat(sb.toString()).concat("\'");
    }

    /**
     * 生成随机长度的字符
     *
     * @param length
     * @return
     */
    public static String generateRandomStr(Integer length) { //length表示生成字符串的长度
        Random random = new Random();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(baseChar.length());
            sb.append(baseChar.charAt(number));
        }
        return sb.toString();
    }


    /**
     * 生成0~range范围的整数
     *
     * @param range
     * @return
     */
    public int generateRandomInt(Integer range){
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
    public static int generateRandomRangeInt(Integer min, Integer max) {
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }

    /**
     * 随机double类型数据
     *
     * @param range
     * @return
     */
    public static Double generateRandomDouble(Integer range){
        Double dRange = range.doubleValue();
        return generateRandomRangeDouble(0D,dRange);
    }

    /**
     * 随机范围double类型数据
     *
     * @param min
     * @param max
     * @return
     */
    public static Double generateRandomRangeDouble(Double min, Double max) {
        Random random = new Random();
        return min + ((max - min) * random.nextDouble());
    }

    /**
     * 随机float类型数据
     *
     * @param range
     * @return
     */
    public static Float generateRandomFloat(Float range) {
        return generateRandomRangeFloat(0F,range);
    }

    /**
     * 随机范围float类型数据
     *
     * @param min
     * @param max
     * @return
     */
    public static Float generateRandomRangeFloat(Float min,Float max) {
        Random random = new Random();
        return min + ((max - min) * random.nextFloat());
    }

    /**
     * 随机时间类型数据
     *
     * @param range
     * @return
     */
    public static String generateRandomDate(Integer range) {
        DateTime dateTime = DateTime.now();
        Random random = new Random();
        int day = random.nextInt(range);
        LOGGER.info("day:"+day);
        String dateString = dateTime.minusDays(day).toString("yyyy-MM-dd");

        return "\'".concat(dateString).concat("\'");
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

        //System.out.println(generateRandomStrInt(10));
        System.out.println(generateRandomStr(10));
        //System.out.println(generateRandomInt(50));
        System.out.println(generateRandomRangeInt(100, 200));
        //System.out.println(generateRandomDouble(50));
        //System.out.println(generateRandomFloat(50));



        String randomDate = generateRandomDate("2012-06-01", "2012-12-12");

        System.out.println(randomDate);

    }

}
