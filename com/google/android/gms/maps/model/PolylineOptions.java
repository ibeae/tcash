package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.p029a.af;
import java.util.ArrayList;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final C0992k CREATOR = new C0992k();
    private final int f1946a;
    private final List<LatLng> f1947b;
    private float f1948c;
    private int f1949d;
    private float f1950e;
    private boolean f1951f;
    private boolean f1952g;

    public PolylineOptions() {
        this.f1948c = 10.0f;
        this.f1949d = -16777216;
        this.f1950e = 0.0f;
        this.f1951f = true;
        this.f1952g = false;
        this.f1946a = 1;
        this.f1947b = new ArrayList();
    }

    PolylineOptions(int i, List list, float f, int i2, float f2, boolean z, boolean z2) {
        this.f1948c = 10.0f;
        this.f1949d = -16777216;
        this.f1950e = 0.0f;
        this.f1951f = true;
        this.f1952g = false;
        this.f1946a = i;
        this.f1947b = list;
        this.f1948c = f;
        this.f1949d = i2;
        this.f1950e = f2;
        this.f1951f = z;
        this.f1952g = z2;
    }

    int m3311a() {
        return this.f1946a;
    }

    public List<LatLng> m3312b() {
        return this.f1947b;
    }

    public float m3313c() {
        return this.f1948c;
    }

    public int m3314d() {
        return this.f1949d;
    }

    public int describeContents() {
        return 0;
    }

    public float m3315e() {
        return this.f1950e;
    }

    public boolean m3316f() {
        return this.f1951f;
    }

    public boolean m3317g() {
        return this.f1952g;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (af.m2895a()) {
            ab.m3596a(this, parcel, i);
        } else {
            C0992k.m3622a(this, parcel, i);
        }
    }
}
