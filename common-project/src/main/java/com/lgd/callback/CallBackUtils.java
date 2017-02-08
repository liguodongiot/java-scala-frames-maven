package com.lgd.callback;

import com.lgd.service.CallbackService;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by liguodong on 2016/9/11.
 */

public class CallBackUtils {

    private CallbackService callbackService;
    private String methodName;
    private String dateTime;

    public CallBackUtils(CallbackService callbackService,
                         String methodName,String dateTime) {
        this.callbackService = callbackService;
        this.methodName = methodName;
        this.dateTime = dateTime;
    }

    public Object callback() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("callbackService.getClass() ---> : "+callbackService.getClass());
        System.out.println("callbackService.getClass().getMethod(methodName,String.class) ---> : "
                +callbackService.getClass().getMethod(methodName,String.class));

        return callbackService.getClass().getMethod(methodName,String.class).invoke(callbackService,dateTime);

    }
}
