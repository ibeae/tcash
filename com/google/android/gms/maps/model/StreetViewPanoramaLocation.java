package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ej;

public class StreetViewPanoramaLocation implements SafeParcelable {
    public static final C0996o CREATOR = new C0996o();
    public final StreetViewPanoramaLink[] f1961a;
    public final LatLng f1962b;
    public final String f1963c;
    private final int f1964d;

    StreetViewPanoramaLocation(int i, StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.f1964d = i;
        this.f1961a = streetViewPanoramaLinkArr;
        this.f1962b = latLng;
        this.f1963c = str;
    }

    int m3320a() {
        return this.f1964d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.f1963c.equals(streetViewPanoramaLocation.f1963c) && this.f1962b.equals(streetViewPanoramaLocation.f1962b);
    }

    public int hashCode() {
        return ej.m2329a(this.f1962b, this.f1963c);
    }

    public String toString() {
        return ej.m2330a((Object) this).m2328a("panoId", this.f1963c).m2328a("position", this.f1962b.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0996o.m3631a(this, parcel, i);
    }
}
