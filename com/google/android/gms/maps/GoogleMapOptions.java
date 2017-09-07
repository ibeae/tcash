package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0640R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.p029a.C0895k;
import com.google.android.gms.maps.p029a.af;

public final class GoogleMapOptions implements SafeParcelable {
    public static final C0944d CREATOR = new C0944d();
    private final int f1826a;
    private Boolean f1827b;
    private Boolean f1828c;
    private int f1829d;
    private CameraPosition f1830e;
    private Boolean f1831f;
    private Boolean f1832g;
    private Boolean f1833h;
    private Boolean f1834i;
    private Boolean f1835j;
    private Boolean f1836k;

    public GoogleMapOptions() {
        this.f1829d = -1;
        this.f1826a = 1;
    }

    GoogleMapOptions(int i, byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        this.f1829d = -1;
        this.f1826a = i;
        this.f1827b = C0895k.m3154a(b);
        this.f1828c = C0895k.m3154a(b2);
        this.f1829d = i2;
        this.f1830e = cameraPosition;
        this.f1831f = C0895k.m3154a(b3);
        this.f1832g = C0895k.m3154a(b4);
        this.f1833h = C0895k.m3154a(b5);
        this.f1834i = C0895k.m3154a(b6);
        this.f1835j = C0895k.m3154a(b7);
        this.f1836k = C0895k.m3154a(b8);
    }

    public static GoogleMapOptions m2820a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0640R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(0)) {
            googleMapOptions.m2822a(obtainAttributes.getInt(0, -1));
        }
        if (obtainAttributes.hasValue(13)) {
            googleMapOptions.m2824a(obtainAttributes.getBoolean(13, false));
        }
        if (obtainAttributes.hasValue(12)) {
            googleMapOptions.m2826b(obtainAttributes.getBoolean(12, false));
        }
        if (obtainAttributes.hasValue(6)) {
            googleMapOptions.m2830d(obtainAttributes.getBoolean(6, true));
        }
        if (obtainAttributes.hasValue(7)) {
            googleMapOptions.m2838h(obtainAttributes.getBoolean(7, true));
        }
        if (obtainAttributes.hasValue(8)) {
            googleMapOptions.m2832e(obtainAttributes.getBoolean(8, true));
        }
        if (obtainAttributes.hasValue(9)) {
            googleMapOptions.m2836g(obtainAttributes.getBoolean(9, true));
        }
        if (obtainAttributes.hasValue(11)) {
            googleMapOptions.m2834f(obtainAttributes.getBoolean(11, true));
        }
        if (obtainAttributes.hasValue(10)) {
            googleMapOptions.m2828c(obtainAttributes.getBoolean(10, true));
        }
        googleMapOptions.m2823a(CameraPosition.m3262a(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    int m2821a() {
        return this.f1826a;
    }

    public GoogleMapOptions m2822a(int i) {
        this.f1829d = i;
        return this;
    }

    public GoogleMapOptions m2823a(CameraPosition cameraPosition) {
        this.f1830e = cameraPosition;
        return this;
    }

    public GoogleMapOptions m2824a(boolean z) {
        this.f1827b = Boolean.valueOf(z);
        return this;
    }

    byte m2825b() {
        return C0895k.m3153a(this.f1827b);
    }

    public GoogleMapOptions m2826b(boolean z) {
        this.f1828c = Boolean.valueOf(z);
        return this;
    }

    byte m2827c() {
        return C0895k.m3153a(this.f1828c);
    }

    public GoogleMapOptions m2828c(boolean z) {
        this.f1831f = Boolean.valueOf(z);
        return this;
    }

    byte m2829d() {
        return C0895k.m3153a(this.f1831f);
    }

    public GoogleMapOptions m2830d(boolean z) {
        this.f1832g = Boolean.valueOf(z);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    byte m2831e() {
        return C0895k.m3153a(this.f1832g);
    }

    public GoogleMapOptions m2832e(boolean z) {
        this.f1833h = Boolean.valueOf(z);
        return this;
    }

    byte m2833f() {
        return C0895k.m3153a(this.f1833h);
    }

    public GoogleMapOptions m2834f(boolean z) {
        this.f1834i = Boolean.valueOf(z);
        return this;
    }

    byte m2835g() {
        return C0895k.m3153a(this.f1834i);
    }

    public GoogleMapOptions m2836g(boolean z) {
        this.f1835j = Boolean.valueOf(z);
        return this;
    }

    byte m2837h() {
        return C0895k.m3153a(this.f1835j);
    }

    public GoogleMapOptions m2838h(boolean z) {
        this.f1836k = Boolean.valueOf(z);
        return this;
    }

    byte m2839i() {
        return C0895k.m3153a(this.f1836k);
    }

    public int m2840j() {
        return this.f1829d;
    }

    public CameraPosition m2841k() {
        return this.f1830e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (af.m2895a()) {
            C0950h.m3256a(this, parcel, i);
        } else {
            C0944d.m3232a(this, parcel, i);
        }
    }
}
