package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.p029a.af;

public final class CircleOptions implements SafeParcelable {
    public static final C0985d CREATOR = new C0985d();
    private final int f1897a;
    private LatLng f1898b;
    private double f1899c;
    private float f1900d;
    private int f1901e;
    private int f1902f;
    private float f1903g;
    private boolean f1904h;

    public CircleOptions() {
        this.f1898b = null;
        this.f1899c = 0.0d;
        this.f1900d = 10.0f;
        this.f1901e = -16777216;
        this.f1902f = 0;
        this.f1903g = 0.0f;
        this.f1904h = true;
        this.f1897a = 1;
    }

    CircleOptions(int i, LatLng latLng, double d, float f, int i2, int i3, float f2, boolean z) {
        this.f1898b = null;
        this.f1899c = 0.0d;
        this.f1900d = 10.0f;
        this.f1901e = -16777216;
        this.f1902f = 0;
        this.f1903g = 0.0f;
        this.f1904h = true;
        this.f1897a = i;
        this.f1898b = latLng;
        this.f1899c = d;
        this.f1900d = f;
        this.f1901e = i2;
        this.f1902f = i3;
        this.f1903g = f2;
        this.f1904h = z;
    }

    int m3265a() {
        return this.f1897a;
    }

    public LatLng m3266b() {
        return this.f1898b;
    }

    public double m3267c() {
        return this.f1899c;
    }

    public float m3268d() {
        return this.f1900d;
    }

    public int describeContents() {
        return 0;
    }

    public int m3269e() {
        return this.f1901e;
    }

    public int m3270f() {
        return this.f1902f;
    }

    public float m3271g() {
        return this.f1903g;
    }

    public boolean m3272h() {
        return this.f1904h;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (af.m2895a()) {
            C1002v.m3647a(this, parcel, i);
        } else {
            C0985d.m3604a(this, parcel, i);
        }
    }
}
