package com.lgd.endecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by liguodong on 2016/9/30.
 */
public class EnDecoderUtils {

    public final static Logger LOGGER = LoggerFactory.getLogger(EnDecoderUtils.class);

    private EnDecoderUtils(){
    }



    public static String encode(String str,String enc){
        String result = null;

        try {
            result = URLEncoder.encode(str,enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static String doubleEncode(String str,String firEnc,String secEnc){
        String result = null;

        try {
            result = URLEncoder.encode(str,firEnc);
            result = URLEncoder.encode(str,secEnc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static String varEncode(String str,String ...argsEnc){
        String result = str;

        try {
            for (int i = 0; i < argsEnc.length; i++) {
                result = URLEncoder.encode(result,argsEnc[i]);
                LOGGER.info("第{}次：{}编码结果为{}。",i+1,argsEnc[i],result);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 一次解码
     * @param str
     * @param enc
     * @return
     */
    public static String decode(String str,String enc){
        String result = null;

        try {
            result = URLDecoder.decode(str,enc);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("error decode...");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 二次解码
     * @param str
     * @param firEnc
     * @param secEnc
     * @return
     */
    public static String doubleDecode(String str,String firEnc,String secEnc){
        String result = null;

        try {
            result = URLDecoder.decode(str,firEnc);
            LOGGER.info("第一次：{}解码结果为{}。",firEnc,result);
            result = URLDecoder.decode(result,secEnc);
            LOGGER.info("第二次：{}解码结果为{}。",secEnc,result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }


    public static String varDecode(String str,String ...argsEnc){
        String result = str;

        try {
            for (int i = 0; i < argsEnc.length; i++) {
                result = URLDecoder.decode(result,argsEnc[i]);
                LOGGER.info("第{}次：{}解码结果为{}。",i+1,argsEnc[i],result);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }



    public static void main(String[] args) throws UnsupportedEncodingException {
        //%E7%BA%BF%E4%B8%8B
        System.out.println(URLDecoder.decode(URLDecoder.decode("%25E7%25BA%25BF%25E4%25B8%258B","iso-8859-1"),"utf-8"));

        System.out.println(URLDecoder.decode("%25E7%25BA%25BF%25E4%25B8%258B","utf-8"));
        System.out.println(URLDecoder.decode("%25E7%25BA%25BF%25E4%25B8%258B","iso-8859-1"));

    }

}
