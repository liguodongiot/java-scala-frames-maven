package com.lgd.generate.sql;

import com.lgd.random.GenerateRandomUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by liguodong on 2016/10/3.
 */
public class TypeFormat {

    private GenerateRandomUtils generateRandomUtils;
    private String methodName;
    private Integer range;

    public TypeFormat(GenerateRandomUtils generateRandomUtils, String methodName, Integer range) {
        this.generateRandomUtils = generateRandomUtils;
        this.methodName = methodName;
        this.range = range;
    }

    public  Object getTypeFormatValue() {
        try {
            return generateRandomUtils.getClass()
                    .getMethod(methodName,Integer.class)
                    .invoke(generateRandomUtils,range);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;

    }


/*


public Object getTypeFormatValue(String method, int min, int max) {

        try {
            return generateRandomUtils.getClass()
                    .getMethod(method,Integer.class,Integer.class)
                    .invoke(generateRandomUtils,min,max);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;

    }


    public Object getTypeFormatValue(String method, double min, double max, int decimalDigit) {

        try {
            return generateRandomUtils.getClass()
                    .getMethod(method,Double.class,Double.class,Integer.class)
                    .invoke(generateRandomUtils,min,max,decimalDigit);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Object getTypeFormatValue(String method, double range, int decimalDigit) {

        try {
            return generateRandomUtils.getClass()
                    .getMethod(method,Double.class,Integer.class)
                    .invoke(generateRandomUtils,range,decimalDigit);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;

    }
*/

}
