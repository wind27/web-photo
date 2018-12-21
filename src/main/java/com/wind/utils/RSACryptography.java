package com.wind.utils;

import com.wind.common.Constant;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * RSACryptography
 *
 * @author qianchun 2018/12/19
 **/
public class RSACryptography {
    private static String UTF8 = "UTF-8";

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * 获取 publicKey
     * 
     * @param publicKey publicKey
     * @return 返回结果
     * @throws Exception
     */
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(publicKey.getBytes(UTF8));
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * 获取 privateKey
     * 
     * @param privateKey privateKey
     * @return 返回结果
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String privateKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(privateKey.getBytes(UTF8));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 加密
     * 
     * @param content 内容
     * @param publicKey publicKey
     * @return 返回结果
     * @throws Exception
     */
    public static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }

    /**
     * 解密
     * 
     * @param content 内容
     * @param privateKey privateKey
     * @return 返回结果
     * @throws Exception
     */
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;

        int inputLen = content.length;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(content, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(content, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }

        return cipher.doFinal(content);
    }

    /**
     * 生成秘钥对
     * 
     * @param keyLength key的长度
     * @return 返回结果
     * @throws Exception
     */
    public static KeyPair genKeyPair(int keyLength) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keyLength);
        return keyPairGenerator.generateKeyPair();
    }

    public static void main(String[] args) throws Exception {
        String data = "hello world !!!))**)";
        byte[] encryptedBytes = null;
        // PublicKey publicKey = getPublicKey(Constant.RSAKey.publicKeyIndex);
        // encryptedBytes = encrypt(data.getBytes(), publicKey);
        // String ba = new String(Base64.getEncoder().encode(encryptedBytes), "UTF-8");
        // System.out.println("加密base64: " + ba);

        // byte[] encryptedBytes =
        // "mZUEP2BXOGiP4KlvEELtgKxOdN9ux+GzQL4fXC9sgsDvYuiCtPjt50ulY8YgEXJ1xrdVROAuIGd6QqthgnRvUcZTHBwUu2JCLQs8rvr9/QAa8anj0HUleMOnZMJ5Eq93+vgIHx4uqb43v8cvxIWdo/eTcVHdWUrE2tKqoikCaF0="
        // .getBytes();

        // String ba = new String(Base64.getEncoder().encode(encryptedBytes), "UTF-8");
        // System.out.println("加密base64: " + ba);
        // encryptedBytes = Base64.getDecoder().decode(encryptedBytes);

        // encryptedBytes = encrypt.getBytes();
        // encryptedBytes = Base64.getEncoder().encode(encrypt.getBytes());

        String encrypt = null;
        encrypt = "V3KpCIwDnSEOFNLoJxH7wEJErDdjo40+J2IvG3FfoS1TRvfs7Ke9l9hFAxNj2ghr06VmH3Vu7RSUDae9+UuFbf5cLHNFuZD6cukZTNaMU0GFIiDW7kPapa1glC+LrEmJhlfkEifZgoyRl8eip9YPutTkE+z8z9KG6aKmLOR6uhs=";
        encryptedBytes = Base64.getDecoder().decode(encrypt.getBytes());
        PrivateKey privateKey = getPrivateKey(Constant.RSAKey.privateKeyIndex);
        byte[] decryptedBytes = decrypt(encryptedBytes, privateKey);
        System.out.println("解密: " + new String(decryptedBytes, UTF8));
    }
}
