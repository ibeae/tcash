package com.google.android.gms.internal;

import android.os.Parcel;
import com.facebook.widget.PlacePickerFragment;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class jh implements SafeParcelable {
    public static final eu CREATOR = new eu();
    private final int f1645a;
    private final String f1646b;
    private final long f1647c;
    private final short f1648d;
    private final double f1649e;
    private final double f1650f;
    private final float f1651g;
    private final int f1652h;
    private final int f1653i;
    private final int f1654j;

    public jh(int i, String str, int i2, short s, double d, double d2, float f, long j, int i3, int i4) {
        m2674a(str);
        m2673a(f);
        m2672a(d, d2);
        int a = m2671a(i2);
        this.f1645a = i;
        this.f1648d = s;
        this.f1646b = str;
        this.f1649e = d;
        this.f1650f = d2;
        this.f1651g = f;
        this.f1647c = j;
        this.f1652h = a;
        this.f1653i = i3;
        this.f1654j = i4;
    }

    private static int m2671a(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    private static void m2672a(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    private static void m2673a(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    private static void m2674a(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    private static String m2675b(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    public int m2676a() {
        return this.f1645a;
    }

    public short m2677b() {
        return this.f1648d;
    }

    public double m2678c() {
        return this.f1649e;
    }

    public double m2679d() {
        return this.f1650f;
    }

    public int describeContents() {
        eu euVar = CREATOR;
        return 0;
    }

    public float m2680e() {
        return this.f1651g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof jh)) {
            return false;
        }
        jh jhVar = (jh) obj;
        return this.f1651g != jhVar.f1651g ? false : this.f1649e != jhVar.f1649e ? false : this.f1650f != jhVar.f1650f ? false : this.f1648d == jhVar.f1648d;
    }

    public String m2681f() {
        return this.f1646b;
    }

    public long m2682g() {
        return this.f1647c;
    }

    public int m2683h() {
        return this.f1652h;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f1649e);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f1650f);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f1651g)) * 31) + this.f1648d) * 31) + this.f1652h;
    }

    public int m2684i() {
        return this.f1653i;
    }

    public int m2685j() {
        return this.f1654j;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{m2675b(this.f1648d), this.f1646b, Integer.valueOf(this.f1652h), Double.valueOf(this.f1649e), Double.valueOf(this.f1650f), Float.valueOf(this.f1651g), Integer.valueOf(this.f1653i / PlacePickerFragment.DEFAULT_RADIUS_IN_METERS), Integer.valueOf(this.f1654j), Long.valueOf(this.f1647c)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        eu euVar = CREATOR;
        eu.m2460a(this, parcel, i);
    }
}
