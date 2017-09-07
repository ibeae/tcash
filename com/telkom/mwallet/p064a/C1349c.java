package com.telkom.mwallet.p064a;

import android.util.Base64;
import com.skcc.wallet.core.p057a.C1216a;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class C1349c {
    public static byte[] f2907a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};

    public static String m4915a(String str, String str2) {
        C1216a.m4519a("CRYPTO - token key", str);
        C1216a.m4519a("CRYPTO - time", str2);
        return C1349c.m4917a(C1349c.m4919a(new SecretKeySpec(C1349c.m4925b(str.getBytes()), "AES"), str2));
    }

    public static String m4916a(PublicKey publicKey, String str) {
        return C1349c.m4917a(C1349c.m4920a(publicKey, str.getBytes()));
    }

    public static String m4917a(byte[] bArr) {
        return Base64.encodeToString(bArr, 0).trim();
    }

    public static byte[] m4918a(String str) {
        return Base64.decode(str, 0);
    }

    private static byte[] m4919a(Key key, String str) {
        Cipher instance = Cipher.getInstance("AES");
        instance.init(1, key);
        return instance.doFinal(str.getBytes());
    }

    public static byte[] m4920a(PublicKey publicKey, byte[] bArr) {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, publicKey);
        return instance.doFinal(bArr);
    }

    public static byte[] m4921a(byte[] bArr, String str) {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(2, secretKeySpec);
        return instance.doFinal(C1349c.m4918a(str));
    }

    public static String m4922b(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(str.getBytes());
        return C1349c.m4917a(messageDigest.digest());
    }

    public static String m4923b(String str, String str2) {
        return new String(C1349c.m4924b(new SecretKeySpec(C1349c.m4925b(str.getBytes()), "AES"), str2));
    }

    private static byte[] m4924b(Key key, String str) {
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, key);
        return instance.doFinal(C1349c.m4918a(str));
    }

    private static byte[] m4925b(byte[] bArr) {
        Object obj = new byte[16];
        if (bArr.length >= 16) {
            System.arraycopy(bArr, 0, obj, 0, 16);
        } else {
            Arrays.fill(obj, (byte) 0);
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
        }
        return obj;
    }

    public static String m4926c(String str, String str2) {
        return new String(C1349c.m4921a(C1349c.m4925b(str.getBytes()), str2));
    }

    public static String m4927d(String str, String str2) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update((str + str2).getBytes());
        return C1349c.m4917a(messageDigest.digest());
    }
}
