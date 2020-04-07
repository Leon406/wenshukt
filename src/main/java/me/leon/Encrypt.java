package me.leon;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

/* renamed from: com.lawyee.wenshuapp.util.m */
public class Encrypt {
    /* renamed from: a */
    private static String date() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    /* renamed from: a */
    public static String desDecrypt(String str, String str2) throws Exception {
        return desDecrypt(str, str2, date());
    }

    /* renamed from: a */
    public static String desEncrypt(String str, String secretKey , String iv) throws Exception {
        SecretKey generateSecret = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec(secretKey .getBytes()));
        Cipher instance = Cipher.getInstance("desede/CBC/PKCS5Padding");
        instance.init(1, generateSecret, new IvParameterSpec(iv.getBytes()));
        return Base64.getEncoder().encodeToString(instance.doFinal(str.getBytes("utf-8")));
    }

    /* renamed from: b */
    public static String desDecrypt(String str, String secretKey, String iv) throws Exception  {
        SecretKey generateSecret = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec(secretKey.getBytes()));
        Cipher instance = Cipher.getInstance("desede/CBC/PKCS5Padding");
        instance.init(2, generateSecret, new IvParameterSpec(iv.getBytes()));
        return new String(instance.doFinal(Base64.getDecoder().decode(str)), "utf-8");
    }
}
