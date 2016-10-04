package com.lgd.service;

import com.lgd.generate.sql.GenerateSqlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liguodong on 2016/9/11.
 */

public class CallbackService {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(CallbackService.class);

    public String printHello(String dateTime){
        LOGGER.info("datetime:"+dateTime);
        return "Hello--"+dateTime;
    }

}
