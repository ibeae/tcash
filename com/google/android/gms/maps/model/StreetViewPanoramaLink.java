package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ej;

public class StreetViewPanoramaLink implements SafeParcelable {
    public static final C0995n CREATOR = new C0995n();
    public final String f1958a;
    public final float f1959b;
    private final int f1960c;

    StreetViewPanoramaLink(int i, String str, float f) {
        this.f1960c = i;
        this.f1958a = str;
        if (((double) f) <= 0.0d) {
            f = (f % 360.0f) + 360.0f;
        }
        this.f1959b = f % 360.0f;
    }

    int m3319a() {
        return this.f1960c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.f1958a.equals(streetViewPanoramaLink.f1958a) && Float.floatToIntBits(this.f1959b) == Float.floatToIntBits(streetViewPanoramaLink.f1959b);
    }

    public int hashCode() {
        return ej.m2329a(this.f1958a, Float.valueOf(this.f1959b));
    }

    public String toString() {
        return ej.m2330a((Object) this).m2328a("panoId", this.f1958a).m2328a("bearing", Float.valueOf(this.f1959b)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0995n.m3628a(this, parcel, i);
    }
}
