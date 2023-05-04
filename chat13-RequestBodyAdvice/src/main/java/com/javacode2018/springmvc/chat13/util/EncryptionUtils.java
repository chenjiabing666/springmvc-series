package com.javacode2018.springmvc.chat13.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * 公众号：码猿技术专栏，专注于java干货分享
 * 个人博客：https://www.java-family.cn
 * 已推出的系列有：【spring系列】、【java高并发系列】、【MySQL系列】、【MyBatis系列】、【Maven系列】
 *
 */

/**
 * 加密工具类
 */
public class EncryptionUtils {

    private static String key = "abcdef0123456789";

    public static void main(String[] args) throws Exception {
        m1();
        m2();
    }

    private static void m1() {
        String body = "{\"name\":\"路人\",\"age\":30}";
        String encryptBody = EncryptionUtils.encrypt(body);
        System.out.println(encryptBody);
        String desEncryptBody = EncryptionUtils.desEncrypt(encryptBody);
        System.out.println(desEncryptBody);
    }

    private static void m2() {
        String body = "[{\"name\":\"路人\",\"age\":30},{\"name\":\"springmvc高手系列\",\"age\":30}]";
        String encryptBody = EncryptionUtils.encrypt(body);
        System.out.println(encryptBody);
        String desEncryptBody = EncryptionUtils.desEncrypt(encryptBody);
        System.out.println(desEncryptBody);
    }

    private static String AESTYPE = "AES/CBC/PKCS5Padding";

    /**
     * 加密明文
     *
     * @param plainText 明文
     * @return
     * @throws Exception
     */
    public static String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance(AESTYPE);
            byte[] dataBytes = plainText.getBytes("utf-8");
            byte[] plaintext = new byte[dataBytes.length];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(key.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.getEncoder().encode(encrypted), "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密密文
     *
     * @param encryptData 密文
     * @return
     * @throws Exception
     */
    public static String desEncrypt(String encryptData) {
        try {
            Cipher cipher = Cipher.getInstance(AESTYPE);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(key.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptData.getBytes("UTF-8")));
            return new String(original, "utf-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}