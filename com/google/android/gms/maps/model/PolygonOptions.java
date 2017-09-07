package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.p029a.af;
import java.util.ArrayList;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final C0991j CREATOR = new C0991j();
    private final int f1937a;
    private final List<LatLng> f1938b;
    private final List<List<LatLng>> f1939c;
    private float f1940d;
    private int f1941e;
    private int f1942f;
    private float f1943g;
    private boolean f1944h;
    private boolean f1945i;

    public PolygonOptions() {
        this.f1940d = 10.0f;
        this.f1941e = -16777216;
        this.f1942f = 0;
        this.f1943g = 0.0f;
        this.f1944h = true;
        this.f1945i = false;
        this.f1937a = 1;
        this.f1938b = new ArrayList();
        this.f1939c = new ArrayList();
    }

    PolygonOptions(int i, List<LatLng> list, List list2, float f, int i2, int i3, float f2, boolean z, boolean z2) {
        this.f1940d = 10.0f;
        this.f1941e = -16777216;
        this.f1942f = 0;
        this.f1943g = 0.0f;
        this.f1944h = true;
        this.f1945i = false;
        this.f1937a = i;
        this.f1938b = list;
        this.f1939c = list2;
        this.f1940d = f;
        this.f1941e = i2;
        this.f1942f = i3;
        this.f1943g = f2;
        this.f1944h = z;
        this.f1945i = z2;
    }

    int m3302a() {
        return this.f1937a;
    }

    List m3303b() {
        return this.f1939c;
    }

    public List<LatLng> m3304c() {
        return this.f1938b;
    }

    public float m3305d() {
        return this.f1940d;
    }

    public int describeContents() {
        return 0;
    }

    public int m3306e() {
        return this.f1941e;
    }

    public int m3307f() {
        return this.f1942f;
    }

    public float m3308g() {
        return this.f1943g;
    }

    public boolean m3309h() {
        return this.f1944h;
    }

    public boolean m3310i() {
        return this.f1945i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (af.m2895a()) {
            aa.m3595a(this, parcel, i);
        } else {
            C0991j.m3619a(this, parcel, i);
        }
    }
}
