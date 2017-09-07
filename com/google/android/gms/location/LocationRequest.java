package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ej;

public final class LocationRequest implements SafeParcelable {
    public static final C0856c CREATOR = new C0856c();
    int f1812a;
    long f1813b;
    long f1814c;
    boolean f1815d;
    long f1816e;
    int f1817f;
    float f1818g;
    private final int f1819h;

    public LocationRequest() {
        this.f1819h = 1;
        this.f1812a = 102;
        this.f1813b = 3600000;
        this.f1814c = 600000;
        this.f1815d = false;
        this.f1816e = Long.MAX_VALUE;
        this.f1817f = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f1818g = 0.0f;
    }

    LocationRequest(int i, int i2, long j, long j2, boolean z, long j3, int i3, float f) {
        this.f1819h = i;
        this.f1812a = i2;
        this.f1813b = j;
        this.f1814c = j2;
        this.f1815d = z;
        this.f1816e = j3;
        this.f1817f = i3;
        this.f1818g = f;
    }

    public static String m2805a(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case 104:
                return "PRIORITY_LOW_POWER";
            case 105:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    int m2806a() {
        return this.f1819h;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.f1812a == locationRequest.f1812a && this.f1813b == locationRequest.f1813b && this.f1814c == locationRequest.f1814c && this.f1815d == locationRequest.f1815d && this.f1816e == locationRequest.f1816e && this.f1817f == locationRequest.f1817f && this.f1818g == locationRequest.f1818g;
    }

    public int hashCode() {
        return ej.m2329a(Integer.valueOf(this.f1812a), Long.valueOf(this.f1813b), Long.valueOf(this.f1814c), Boolean.valueOf(this.f1815d), Long.valueOf(this.f1816e), Integer.valueOf(this.f1817f), Float.valueOf(this.f1818g));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[").append(m2805a(this.f1812a));
        if (this.f1812a != 105) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.f1813b + "ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.f1814c + "ms");
        if (this.f1816e != Long.MAX_VALUE) {
            long elapsedRealtime = this.f1816e - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime + "ms");
        }
        if (this.f1817f != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            stringBuilder.append(" num=").append(this.f1817f);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0856c.m2813a(this, parcel, i);
    }
}
