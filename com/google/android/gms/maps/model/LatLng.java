package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.p029a.af;

public final class LatLng implements SafeParcelable {
    public static final C0988g CREATOR = new C0988g();
    public final double f1917a;
    public final double f1918b;
    private final int f1919c;

    public LatLng(double d, double d2) {
        this(1, d, d2);
    }

    LatLng(int i, double d, double d2) {
        this.f1919c = i;
        if (-180.0d > d2 || d2 >= 180.0d) {
            this.f1918b = ((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.f1918b = d2;
        }
        this.f1917a = Math.max(-90.0d, Math.min(90.0d, d));
    }

    int m3285a() {
        return this.f1919c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f1917a) == Double.doubleToLongBits(latLng.f1917a) && Double.doubleToLongBits(this.f1918b) == Double.doubleToLongBits(latLng.f1918b);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f1917a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f1918b);
        return (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "lat/lng: (" + this.f1917a + "," + this.f1918b + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (af.m2895a()) {
            C1005y.m3650a(this, parcel, i);
        } else {
            C0988g.m3613a(this, parcel, i);
        }
    }
}
