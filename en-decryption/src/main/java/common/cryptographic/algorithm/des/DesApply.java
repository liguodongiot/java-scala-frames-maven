package common.cryptographic.algorithm.des;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by liguodong on 2016/1/23.
 */
public class DesApply {

    public static void main(String[] args) throws UnsupportedEncodingException {

        List<String> list = new ArrayList<String>();

        System.out.println("请输入一个或两个参数：");
        Scanner scanner = new Scanner(System.in);

        String temp = null;

        while(!(temp=scanner.nextLine()).equals("")){
            list.add(temp);
        }

        if (list.size()==1){
            KeyAndEncrypt(list.get(0));
        } else{
            //System.out.println(list.get(0)+":" +list.get(1));
            JudgeWhetherSuccessful(list.get(0), list.get(1));
        }

    }

    public static void KeyAndEncrypt(String password) throws UnsupportedEncodingException {

        String secretKey = getSecretKey();
        System.out.println(secretKey);

        SecretKey convertsecretKey = convertSecretKey(secretKey);

        String result = ENCRYPT(password, convertsecretKey);
        System.out.println(result);

        System.out.println(DECRYPT(convertsecretKey,result));

    }

    public static void JudgeWhetherSuccessful(String secretKey,
                                              String result){

        System.out.println(secretKey);

        SecretKey convertsecretKey = convertSecretKey(secretKey);

        System.out.println(result);

        System.out.println(DECRYPT(convertsecretKey,result));

    }


    public static String getSecretKey(){

        byte[] bytesKey = null;
        try {

            //生成KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");

            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();

            bytesKey = secretKey.getEncoded();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return new String(bytesKey);
    }



    public static SecretKey convertSecretKey(String bytesKeyString){
        byte[] bytesKey = bytesKeyString.getBytes();

        SecretKey convertSecretKey = null;

        try {
            //KEY转换
            DESKeySpec desKeySpec = new DESKeySpec(bytesKey);

            //参数是指定它的加密方式
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");

            convertSecretKey = secretKeyFactory.generateSecret(desKeySpec);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return convertSecretKey;
    }




    public static String ENCRYPT(String password,SecretKey convertSecretKey) throws UnsupportedEncodingException {

        Cipher cipher = null;

        byte[] result = null;

        try {
            cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE,convertSecretKey);

            result = cipher.doFinal(password.getBytes());

            //System.out.println("BC DES ENCRYPT:" + Hex.encodeHexString(result));

        } catch (Exception e) {
            e.printStackTrace();

        }
        return new String(result,"ISO-8859-1");
    }



    public static String DECRYPT(SecretKey convertSecretKey,String resultInput){

        Cipher cipher = null;
        byte[] resultOutput = null;

        try {
            cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE,convertSecretKey);

            resultOutput = cipher.doFinal(resultInput.getBytes("ISO-8859-1"));

            //System.out.println("BC DES DECRYPT:" + new String(resultOutput));


        } catch (Exception e) {
            e.printStackTrace();
        }

        return new String(resultOutput);
    }

}
