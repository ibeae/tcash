package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.p029a.C0895k;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final C0946f CREATOR = new C0946f();
    private final int f1837a;
    private StreetViewPanoramaCamera f1838b;
    private String f1839c;
    private LatLng f1840d;
    private Integer f1841e;
    private Boolean f1842f;
    private Boolean f1843g;
    private Boolean f1844h;
    private Boolean f1845i;
    private Boolean f1846j;

    public StreetViewPanoramaOptions() {
        this.f1842f = Boolean.valueOf(true);
        this.f1843g = Boolean.valueOf(true);
        this.f1844h = Boolean.valueOf(true);
        this.f1845i = Boolean.valueOf(true);
        this.f1837a = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.f1842f = Boolean.valueOf(true);
        this.f1843g = Boolean.valueOf(true);
        this.f1844h = Boolean.valueOf(true);
        this.f1845i = Boolean.valueOf(true);
        this.f1837a = i;
        this.f1838b = streetViewPanoramaCamera;
        this.f1840d = latLng;
        this.f1841e = num;
        this.f1839c = str;
        this.f1842f = C0895k.m3154a(b);
        this.f1843g = C0895k.m3154a(b2);
        this.f1844h = C0895k.m3154a(b3);
        this.f1845i = C0895k.m3154a(b4);
        this.f1846j = C0895k.m3154a(b5);
    }

    int m2842a() {
        return this.f1837a;
    }

    byte m2843b() {
        return C0895k.m3153a(this.f1842f);
    }

    byte m2844c() {
        return C0895k.m3153a(this.f1843g);
    }

    byte m2845d() {
        return C0895k.m3153a(this.f1844h);
    }

    public int describeContents() {
        return 0;
    }

    byte m2846e() {
        return C0895k.m3153a(this.f1845i);
    }

    byte m2847f() {
        return C0895k.m3153a(this.f1846j);
    }

    public StreetViewPanoramaCamera m2848g() {
        return this.f1838b;
    }

    public LatLng m2849h() {
        return this.f1840d;
    }

    public Integer m2850i() {
        return this.f1841e;
    }

    public String m2851j() {
        return this.f1839c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0946f.m3237a(this, parcel, i);
    }
}
