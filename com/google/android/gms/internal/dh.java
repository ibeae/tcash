package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Locale;

public final class dh {
    private static final Object f1319a = new Object();
    private static String f1320b;

    public static String m2054a() {
        String str;
        synchronized (f1319a) {
            str = f1320b;
        }
        return str;
    }

    public static String m2055a(Context context, String str, String str2) {
        String str3;
        synchronized (f1319a) {
            if (f1320b == null && !TextUtils.isEmpty(str)) {
                m2056b(context, str, str2);
            }
            str3 = f1320b;
        }
        return str3;
    }

    private static void m2056b(Context context, String str, String str2) {
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str.split(",");
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (dk.m2076a(classLoader, cls, split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            f1320b = String.format(Locale.US, "%X", new Object[]{bigInteger2});
        } catch (Throwable th) {
            f1320b = "err";
        }
    }
}
