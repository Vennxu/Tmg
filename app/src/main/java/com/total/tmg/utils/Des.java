package com.total.tmg.utils;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class Des {
    static String DEStext = "fwUgKh220HqlmRofQ05SRUQyMDE1RVJ1aUFQUEFwaU9sZGVyUTbCzHC4B0BGoMOo";

    //加密
   public static String Encrypt(String message)
   	throws Exception {
   		return Encrypt(message,DEStext);
   }
   
   
   //加密
   public static String Encrypt(String message, String sKey)
       throws Exception {
       byte[] tmpKey = sKey.getBytes("UTF8");
       Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

       MessageDigest md5 = MessageDigest.getInstance("MD5");

       tmpKey = new String(md5.digest(tmpKey), "UTF8").substring(0, 8).getBytes("ASCII");

       DESKeySpec desKeySpec = new DESKeySpec(tmpKey);

       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
       SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
       IvParameterSpec iv = new IvParameterSpec(tmpKey);
       cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

       return toHexString(cipher.doFinal(message.getBytes("UTF-8"))).toUpperCase();
   }


   public static void main(String[] args) throws Exception {

       String a = Encrypt("18501376440");

       System.out.println("加密后的数据为:" + a);

       System.out.println("加密后的MD5再加密后数据为:"+MD5.get(a));

   }

   public static String toHexString(byte[] b) {
       StringBuffer hexString = new StringBuffer();

       for (int i = 0; i < b.length; i++) {
           String plainText = Integer.toHexString(0xff & b[i]);

           if (plainText.length() < 2) {
               plainText = "0" + plainText;
           }

           hexString.append(plainText);
       }

       return hexString.toString();
   }
}
