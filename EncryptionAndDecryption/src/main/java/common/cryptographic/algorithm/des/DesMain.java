package common.cryptographic.algorithm.des;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by liguodong on 2016/1/23.
 */
public class DesMain {

    public static String password = "liguodong";

    public static void main(String[] args) {
        //DesForJdk();
        DesForBouncyCastle();
    }


    public static void DesForJdk(){

        try {
            //生成KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");

            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();

            byte[] bytesKey = secretKey.getEncoded();

            //KEY转换
            DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
            //参数是指定它的加密方式
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");

            SecretKey convertSecretKey =secretKeyFactory.generateSecret(desKeySpec);

            //加密
            /**
             * 第一个 加解密算法
             * 第二个 工作方式
             * 第三个 填充方式
             */
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);

            byte[] result = cipher.doFinal(password.getBytes());
            System.out.println("JDK DES ENCRYPT:" + Hex.encodeHexString(result));


            //解密
            cipher.init(Cipher.DECRYPT_MODE,convertSecretKey);
            result = cipher.doFinal(result);
            System.out.println("JDK DES DECRYPT:" + new String(result));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void DesForBouncyCastle(){


        try {
            Security.addProvider(new BouncyCastleProvider());

            //生成KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES", "BC");

            //Provider provider = keyGenerator.getProvider();

            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();

            byte[] bytesKey = secretKey.getEncoded();

            //KEY转换
            DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
            //参数是指定它的加密方式
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");

            SecretKey convertSecretKey =secretKeyFactory.generateSecret(desKeySpec);

            System.out.println("SecretKey:" + new String(convertSecretKey.getEncoded()));



            //加密
            /**
             * 第一个 加解密算法
             * 第二个 工作方式
             * 第三个 填充方式
             */
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);

            byte[] result = cipher.doFinal(password.getBytes());
            System.out.println("BC DES ENCRYPT:" + Hex.encodeHexString(result));



            //解密
            cipher.init(Cipher.DECRYPT_MODE,convertSecretKey);
            result = cipher.doFinal(result);
            System.out.println("BC DES DECRYPT:" + new String(result));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
