package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jk implements SafeParcelable {
    public static final ex CREATOR = new ex();
    private final int f1655a;
    private final int f1656b;
    private final int f1657c;
    private final jm f1658d;

    jk(int i, int i2, int i3, jm jmVar) {
        this.f1655a = i;
        this.f1656b = i2;
        this.f1657c = i3;
        this.f1658d = jmVar;
    }

    public int m2686a() {
        return this.f1655a;
    }

    public int m2687b() {
        return this.f1656b;
    }

    public int m2688c() {
        return this.f1657c;
    }

    public jm m2689d() {
        return this.f1658d;
    }

    public int describeContents() {
        ex exVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jk)) {
            return false;
        }
        jk jkVar = (jk) obj;
        return this.f1656b == jkVar.f1656b && this.f1657c == jkVar.f1657c && this.f1658d.equals(jkVar.f1658d);
    }

    public int hashCode() {
        return ej.m2329a(Integer.valueOf(this.f1656b), Integer.valueOf(this.f1657c));
    }

    public String toString() {
        return ej.m2330a((Object) this).m2328a("transitionTypes", Integer.valueOf(this.f1656b)).m2328a("loiteringTimeMillis", Integer.valueOf(this.f1657c)).m2328a("placeFilter", this.f1658d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ex exVar = CREATOR;
        ex.m2463a(this, parcel, i);
    }
}
