package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;

public class bn {
    private Object f1037a;
    private final Context f1038b;

    public bn(Context context) {
        this.f1038b = context;
    }

    public int m1733a(String str, String str2) {
        try {
            Class loadClass = this.f1038b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("consumePurchase", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.f1037a), new Object[]{Integer.valueOf(3), str, str2})).intValue();
        } catch (Throwable e) {
            dq.m2118c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return 5;
        }
    }

    public Bundle m1734a(String str, String str2, String str3) {
        try {
            Class loadClass = this.f1038b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(loadClass.cast(this.f1037a), new Object[]{Integer.valueOf(3), str, str2, "inapp", str3});
        } catch (Throwable e) {
            dq.m2118c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return null;
        }
    }

    public void m1735a() {
        this.f1037a = null;
    }

    public void m1736a(IBinder iBinder) {
        try {
            this.f1037a = this.f1038b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{iBinder});
        } catch (Exception e) {
            dq.m2120e("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
        }
    }

    public Bundle m1737b(String str, String str2) {
        try {
            Class loadClass = this.f1038b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getPurchases", new Class[]{Integer.TYPE, String.class, String.class, String.class}).invoke(loadClass.cast(this.f1037a), new Object[]{Integer.valueOf(3), str, "inapp", str2});
        } catch (Throwable e) {
            dq.m2118c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return null;
        }
    }
}
