package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class ju implements SafeParcelable {
    public static final Creator<ju> CREATOR = new fc();
    final int f1729a;
    private final String f1730b;
    private final LatLng f1731c;
    private final String f1732d;
    private final List<js> f1733e;
    private final String f1734f;
    private final String f1735g;

    ju(int i, String str, LatLng latLng, String str2, List<js> list, String str3, String str4) {
        this.f1729a = i;
        this.f1730b = str;
        this.f1731c = latLng;
        this.f1732d = str2;
        this.f1733e = new ArrayList(list);
        this.f1734f = str3;
        this.f1735g = str4;
    }

    public String m2700a() {
        return this.f1730b;
    }

    public LatLng m2701b() {
        return this.f1731c;
    }

    public String m2702c() {
        return this.f1732d;
    }

    public List<js> m2703d() {
        return this.f1733e;
    }

    public int describeContents() {
        return 0;
    }

    public String m2704e() {
        return this.f1734f;
    }

    public String m2705f() {
        return this.f1735g;
    }

    public void writeToParcel(Parcel parcel, int i) {
        fc.m2486a(this, parcel, i);
    }
}
