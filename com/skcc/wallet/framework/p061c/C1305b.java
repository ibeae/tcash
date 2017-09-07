package com.skcc.wallet.framework.p061c;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class C1305b {
    private final Cipher f2791a;
    private final Cipher f2792b;
    private final SharedPreferences f2793c;

    public static class C1304a extends RuntimeException {
        public C1304a(Throwable th) {
            super(th);
            th.printStackTrace();
        }
    }

    public C1305b(Context context, String str, String str2) {
        try {
            this.f2791a = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f2792b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            m4756a(str2);
            this.f2793c = context.getSharedPreferences(str, 0);
        } catch (Throwable e) {
            throw new C1304a(e);
        } catch (Throwable e2) {
            throw new C1304a(e2);
        }
    }

    private static byte[] m4752a(Cipher cipher, byte[] bArr) {
        try {
            return cipher.doFinal(bArr);
        } catch (IllegalBlockSizeException e) {
            throw e;
        } catch (Throwable e2) {
            throw new C1304a(e2);
        }
    }

    public String m4753a(String str, String str2) {
        if (!m4762e(str)) {
            return str2;
        }
        try {
            String string = this.f2793c.getString(str, str2);
            return string == null ? str2 : m4761d(string);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            m4759c(str, str2);
            throw e;
        }
    }

    protected String m4754a(String str, Cipher cipher) {
        try {
            return Base64.encodeToString(C1305b.m4752a(cipher, str.getBytes("UTF-8")), 2);
        } catch (Throwable e) {
            throw new C1304a(e);
        }
    }

    protected IvParameterSpec m4755a() {
        Object obj = new byte[this.f2791a.getBlockSize()];
        System.arraycopy("fldsjfodasjifudslfjdsaofshaufihadsf".getBytes(), 0, obj, 0, this.f2791a.getBlockSize());
        return new IvParameterSpec(obj);
    }

    protected void m4756a(String str) {
        AlgorithmParameterSpec a = m4755a();
        Key b = m4757b(str);
        this.f2791a.init(1, b, a);
        this.f2792b.init(2, b, a);
    }

    protected SecretKeySpec m4757b(String str) {
        return new SecretKeySpec(m4760c(str), "AES/CBC/PKCS5Padding");
    }

    public void m4758b(String str, String str2) {
        if (str2 != null || "".equals(str2)) {
            this.f2793c.edit().putString(str, m4754a(str2, this.f2791a)).commit();
            return;
        }
        this.f2793c.edit().remove(str).commit();
    }

    public void m4759c(String str, String str2) {
        String string = this.f2793c.getString(str, str2);
        if (string == null || "".equals(string)) {
            Log.d("SecurePreferences", "convertSecureValue is null");
        } else {
            m4758b(str, string);
        }
    }

    protected byte[] m4760c(String str) {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.reset();
        return instance.digest(str.getBytes("UTF-8"));
    }

    protected String m4761d(String str) {
        try {
            return new String(C1305b.m4752a(this.f2792b, Base64.decode(str, 2)), "UTF-8");
        } catch (Throwable e) {
            throw new C1304a(e);
        }
    }

    public boolean m4762e(String str) {
        return this.f2793c.contains(str);
    }
}
