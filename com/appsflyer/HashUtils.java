package com.appsflyer;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.Map;

public class HashUtils {
    private static String byteToHex(byte[] bArr) {
        Formatter formatter = new Formatter();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            formatter.format("%02x", new Object[]{Byte.valueOf(bArr[i])});
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    public static String toMD5(String str) {
        String str2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            str2 = byteToHex(instance.digest());
        } catch (Exception e) {
            AFLogger.afLog(e.toString());
        }
        return str2;
    }

    public static String toSHA1(String str) {
        String str2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            str2 = byteToHex(instance.digest());
        } catch (Exception e) {
            AFLogger.afLog(e.toString());
        }
        return str2;
    }

    public String getHashCode(Map<String, String> map) {
        String str = (String) map.get(ServerParameters.TIMESTAMP);
        return toSHA1(((String) map.get(ServerParameters.AF_DEV_KEY)).substring(0, 7) + ((String) map.get(ServerParameters.AF_USER_ID)).substring(0, 7) + str.substring(str.length() - 7));
    }

    public native String getNativeCode(String str, String str2, String str3);
}
