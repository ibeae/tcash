package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.internal.bx.C0708a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class bp extends C0708a {
    private String f1052a;
    private Context f1053b;
    private String f1054c;
    private ArrayList<String> f1055d;

    public bp(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.f1054c = str;
        this.f1055d = arrayList;
        this.f1052a = str2;
        this.f1053b = context;
    }

    private void m1756b() {
        try {
            this.f1053b.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(null, new Object[]{this.f1053b, this.f1054c, "", Boolean.valueOf(true)});
        } catch (ClassNotFoundException e) {
            dq.m2120e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            dq.m2120e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Throwable e3) {
            dq.m2118c("Fail to report a conversion.", e3);
        }
    }

    protected int m1757a(int i) {
        return i == 0 ? 1 : i == 1 ? 2 : i == 4 ? 3 : 0;
    }

    public String mo933a() {
        return this.f1054c;
    }

    protected String m1759a(String str, HashMap<String, String> hashMap) {
        Object obj;
        Object obj2 = "";
        try {
            obj = this.f1053b.getPackageManager().getPackageInfo(this.f1053b.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            dq.m2118c("Error to retrieve app version", e);
            obj = obj2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - dd.m2036d().m2046a();
        for (String str2 : hashMap.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{str2}), String.format("$1%s$2", new Object[]{hashMap.get(str2)}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sessionid"}), String.format("$1%s$2", new Object[]{dd.f1298a})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{AppsFlyerProperties.APP_ID}), String.format("$1%s$2", new Object[]{r2})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"osversion"}), String.format("$1%s$2", new Object[]{String.valueOf(VERSION.SDK_INT)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sdkversion"}), String.format("$1%s$2", new Object[]{this.f1052a})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appversion"}), String.format("$1%s$2", new Object[]{obj})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"timestamp"}), String.format("$1%s$2", new Object[]{String.valueOf(elapsedRealtime)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{""})).replaceAll("@@", "@");
    }

    public void mo934b(int i) {
        if (i == 1) {
            m1756b();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(i));
        hashMap.put("sku", this.f1054c);
        Iterator it = this.f1055d.iterator();
        while (it.hasNext()) {
            new C0750do(this.f1053b, this.f1052a, m1759a((String) it.next(), hashMap)).m1741e();
        }
    }

    public void mo935c(int i) {
        if (i == 0) {
            m1756b();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("google_play_status", String.valueOf(i));
        hashMap.put("sku", this.f1054c);
        hashMap.put("status", String.valueOf(m1757a(i)));
        Iterator it = this.f1055d.iterator();
        while (it.hasNext()) {
            new C0750do(this.f1053b, this.f1052a, m1759a((String) it.next(), hashMap)).m1741e();
        }
    }
}
