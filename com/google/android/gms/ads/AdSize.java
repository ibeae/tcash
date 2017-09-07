package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.dp;
import twitter4j.HttpResponseCode;

public final class AdSize {
    public static final AdSize f815a = new AdSize(320, 50, "320x50_mb");
    public static final AdSize f816b = new AdSize(468, 60, "468x60_as");
    public static final AdSize f817c = new AdSize(320, 100, "320x100_as");
    public static final AdSize f818d = new AdSize(728, 90, "728x90_as");
    public static final AdSize f819e = new AdSize(HttpResponseCode.MULTIPLE_CHOICES, 250, "300x250_as");
    public static final AdSize f820f = new AdSize(160, 600, "160x600_as");
    public static final AdSize f821g = new AdSize(-1, -2, "smart_banner");
    private final int f822h;
    private final int f823i;
    private final String f824j;

    public AdSize(int i, int i2) {
        this(i, i2, (i == -1 ? "FULL" : String.valueOf(i)) + "x" + (i2 == -2 ? "AUTO" : String.valueOf(i2)) + "_as");
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        } else if (i2 >= 0 || i2 == -2) {
            this.f822h = i;
            this.f823i = i2;
            this.f824j = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
    }

    public int m1397a() {
        return this.f823i;
    }

    public int m1398a(Context context) {
        return this.f823i == -2 ? al.m1549b(context.getResources().getDisplayMetrics()) : dp.m2103a(context, this.f823i);
    }

    public int m1399b() {
        return this.f822h;
    }

    public int m1400b(Context context) {
        return this.f822h == -1 ? al.m1548a(context.getResources().getDisplayMetrics()) : dp.m2103a(context, this.f822h);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.f822h == adSize.f822h && this.f823i == adSize.f823i && this.f824j.equals(adSize.f824j);
    }

    public int hashCode() {
        return this.f824j.hashCode();
    }

    public String toString() {
        return this.f824j;
    }
}
