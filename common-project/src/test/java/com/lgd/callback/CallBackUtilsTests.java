package com.lgd.callback;

import com.lgd.service.CallbackService;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by liguodong on 2016/9/11.
 */

public class CallBackUtilsTests {


    @Test
    public void test(){
        CallbackService callbackService = new CallbackService();

        CallBackUtils callBackUtils = new CallBackUtils(callbackService,"printHello","2016-01-01");

        try {
            System.out.println(callBackUtils.callback());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }



}
