package me.leon;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Cipher {
    /* renamed from: a */

    public static String stamp = "";

    public static String binary() {

        try {
            // 时间戳
            Date date = new Date();
            String timeStamp = date.getTime() + "";
            stamp = timeStamp;
//            System.out.println("timestamp: " + timeStamp);

            // 20200312
            String dateString = new SimpleDateFormat("yyyyMMdd").format(date);
            // 24个随机字符
            String ramdom24 = random(24);
//            System.out.println("ramdom24: " + ramdom24);
            String origin = ramdom24 + dateString + Encrypt.desEncrypt(timeStamp, ramdom24, dateString);
//            System.out.println("origin: " + origin);
            return binaryString(origin);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    //随机取 指定个数的 字符
    public static String random(int i) {
        String str = "";
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i2 = 0; i2 < i; i2++) {
            str = str + cArr[(int) Math.round(Math.random() * ((double) (cArr.length - 1)))];
        }
        return str;
    }

    /* renamed from: a */
    public static String binaryString(String str) {
        StringBuilder stringBuffer = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != 0) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(Integer.toBinaryString(chars[i]));
        }
//        String[] split = str.split("");
//        for (int i = 0; i < split.length; i++) {
//            if (i != 0) {
//                stringBuffer.append(" ");
//            }
//            stringBuffer.append(Integer.toBinaryString(split[i].charAt(0)));
//        }
        return stringBuffer.toString();
    }
}
