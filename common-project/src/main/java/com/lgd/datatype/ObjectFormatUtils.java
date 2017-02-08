package com.lgd.datatype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liguodong on 2016/10/3.
 */
public class ObjectFormatUtils {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(ObjectFormatUtils.class);

    public static String objToStr(Object obj){
        return obj.toString();
    }


    public static void main(String[] args) {

        Object obj = "fds";
        String str = objToStr(obj);
        LOGGER.info(str);
    }


}
