package com.google.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import twitter4j.HttpResponseCode;

@Deprecated
public final class C0632b {
    public static final C0632b f752a = new C0632b(-1, -2, "mb");
    public static final C0632b f753b = new C0632b(320, 50, "mb");
    public static final C0632b f754c = new C0632b(HttpResponseCode.MULTIPLE_CHOICES, 250, "as");
    public static final C0632b f755d = new C0632b(468, 60, "as");
    public static final C0632b f756e = new C0632b(728, 90, "as");
    public static final C0632b f757f = new C0632b(160, 600, "as");
    private final AdSize f758g;

    private C0632b(int i, int i2, String str) {
        this(new AdSize(i, i2));
    }

    public C0632b(AdSize adSize) {
        this.f758g = adSize;
    }

    public int m1302a() {
        return this.f758g.m1399b();
    }

    public int m1303a(Context context) {
        return this.f758g.m1400b(context);
    }

    public int m1304b() {
        return this.f758g.m1397a();
    }

    public int m1305b(Context context) {
        return this.f758g.m1398a(context);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0632b)) {
            return false;
        }
        return this.f758g.equals(((C0632b) obj).f758g);
    }

    public int hashCode() {
        return this.f758g.hashCode();
    }

    public String toString() {
        return this.f758g.toString();
    }
}
