package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.p029a.af;
import com.google.android.gms.p027a.C0651c.C0653a;

public final class MarkerOptions implements SafeParcelable {
    public static final C0990i CREATOR = new C0990i();
    private final int f1923a;
    private LatLng f1924b;
    private String f1925c;
    private String f1926d;
    private C0982a f1927e;
    private float f1928f;
    private float f1929g;
    private boolean f1930h;
    private boolean f1931i;
    private boolean f1932j;
    private float f1933k;
    private float f1934l;
    private float f1935m;
    private float f1936n;

    public MarkerOptions() {
        this.f1928f = 0.5f;
        this.f1929g = 1.0f;
        this.f1931i = true;
        this.f1932j = false;
        this.f1933k = 0.0f;
        this.f1934l = 0.5f;
        this.f1935m = 0.0f;
        this.f1936n = 1.0f;
        this.f1923a = 1;
    }

    MarkerOptions(int i, LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6) {
        this.f1928f = 0.5f;
        this.f1929g = 1.0f;
        this.f1931i = true;
        this.f1932j = false;
        this.f1933k = 0.0f;
        this.f1934l = 0.5f;
        this.f1935m = 0.0f;
        this.f1936n = 1.0f;
        this.f1923a = i;
        this.f1924b = latLng;
        this.f1925c = str;
        this.f1926d = str2;
        this.f1927e = iBinder == null ? null : new C0982a(C0653a.m1383a(iBinder));
        this.f1928f = f;
        this.f1929g = f2;
        this.f1930h = z;
        this.f1931i = z2;
        this.f1932j = z3;
        this.f1933k = f3;
        this.f1934l = f4;
        this.f1935m = f5;
        this.f1936n = f6;
    }

    int m3287a() {
        return this.f1923a;
    }

    public MarkerOptions m3288a(LatLng latLng) {
        this.f1924b = latLng;
        return this;
    }

    IBinder m3289b() {
        return this.f1927e == null ? null : this.f1927e.m3594a().asBinder();
    }

    public LatLng m3290c() {
        return this.f1924b;
    }

    public String m3291d() {
        return this.f1925c;
    }

    public int describeContents() {
        return 0;
    }

    public String m3292e() {
        return this.f1926d;
    }

    public float m3293f() {
        return this.f1928f;
    }

    public float m3294g() {
        return this.f1929g;
    }

    public boolean m3295h() {
        return this.f1930h;
    }

    public boolean m3296i() {
        return this.f1931i;
    }

    public boolean m3297j() {
        return this.f1932j;
    }

    public float m3298k() {
        return this.f1933k;
    }

    public float m3299l() {
        return this.f1934l;
    }

    public float m3300m() {
        return this.f1935m;
    }

    public float m3301n() {
        return this.f1936n;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (af.m2895a()) {
            C1006z.m3651a(this, parcel, i);
        } else {
            C0990i.m3616a(this, parcel, i);
        }
    }
}
