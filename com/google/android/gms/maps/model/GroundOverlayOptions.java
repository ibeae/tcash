package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.p029a.af;
import com.google.android.gms.p027a.C0651c.C0653a;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final C0986e CREATOR = new C0986e();
    private final int f1905a;
    private C0982a f1906b;
    private LatLng f1907c;
    private float f1908d;
    private float f1909e;
    private LatLngBounds f1910f;
    private float f1911g;
    private float f1912h;
    private boolean f1913i;
    private float f1914j;
    private float f1915k;
    private float f1916l;

    public GroundOverlayOptions() {
        this.f1913i = true;
        this.f1914j = 0.0f;
        this.f1915k = 0.5f;
        this.f1916l = 0.5f;
        this.f1905a = 1;
    }

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.f1913i = true;
        this.f1914j = 0.0f;
        this.f1915k = 0.5f;
        this.f1916l = 0.5f;
        this.f1905a = i;
        this.f1906b = new C0982a(C0653a.m1383a(iBinder));
        this.f1907c = latLng;
        this.f1908d = f;
        this.f1909e = f2;
        this.f1910f = latLngBounds;
        this.f1911g = f3;
        this.f1912h = f4;
        this.f1913i = z;
        this.f1914j = f5;
        this.f1915k = f6;
        this.f1916l = f7;
    }

    IBinder m3273a() {
        return this.f1906b.m3594a().asBinder();
    }

    int m3274b() {
        return this.f1905a;
    }

    public LatLng m3275c() {
        return this.f1907c;
    }

    public float m3276d() {
        return this.f1908d;
    }

    public int describeContents() {
        return 0;
    }

    public float m3277e() {
        return this.f1909e;
    }

    public LatLngBounds m3278f() {
        return this.f1910f;
    }

    public float m3279g() {
        return this.f1911g;
    }

    public float m3280h() {
        return this.f1912h;
    }

    public float m3281i() {
        return this.f1914j;
    }

    public float m3282j() {
        return this.f1915k;
    }

    public float m3283k() {
        return this.f1916l;
    }

    public boolean m3284l() {
        return this.f1913i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (af.m2895a()) {
            C1003w.m3648a(this, parcel, i);
        } else {
            C0986e.m3607a(this, parcel, i);
        }
    }
}
