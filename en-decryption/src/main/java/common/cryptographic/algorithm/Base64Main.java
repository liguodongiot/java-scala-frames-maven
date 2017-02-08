package common.cryptographic.algorithm;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
//import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
//import com.sun.org.apache.xml.internal.security.utils.Base64;
//import com.sun.xml.internal.messaging.saaj.util.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by liguodong on 2016/1/16.
 */
public class Base64Main {

    //需要加密的原始的字符串
    public static String src = "liguodong74";



    public static void main(String[] args) throws IOException {

        base64ForJDK();

        //base64ForCommonCodes();

        //base64ForBouncyCastle();
    }

    public static void base64ForJDK() throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();

        //String encode = encoder.encode(src.getBytes());
        String encode = "bGlndW9kb25nNzQ=";

        System.out.println("encode:"+encode);

        BASE64Decoder decoder = new BASE64Decoder();
        System.out.println("decode:"+new String(decoder.decodeBuffer(encode)));
    }


    public static void base64ForCommonCodes() {
        byte[] encode = org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());

        System.out.println("encode:"+new String(encode));

        byte[] decode = org.apache.commons.codec.binary.Base64.decodeBase64(encode);
        System.out.println("decode:"+new String(decode));

    }


    public static void base64ForBouncyCastle(){
        byte[] encode = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());

        System.out.println("encode:" + new String(encode));

        byte[] decode = org.bouncycastle.util.encoders.Base64.decode(encode);

        System.out.println("decode:" + new String(decode));

    }

}
