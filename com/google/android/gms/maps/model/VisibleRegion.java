package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ej;
import com.google.android.gms.maps.p029a.af;

public final class VisibleRegion implements SafeParcelable {
    public static final C1000t CREATOR = new C1000t();
    public final LatLng f1983a;
    public final LatLng f1984b;
    public final LatLng f1985c;
    public final LatLng f1986d;
    public final LatLngBounds f1987e;
    private final int f1988f;

    VisibleRegion(int i, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f1988f = i;
        this.f1983a = latLng;
        this.f1984b = latLng2;
        this.f1985c = latLng3;
        this.f1986d = latLng4;
        this.f1987e = latLngBounds;
    }

    int m3332a() {
        return this.f1988f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.f1983a.equals(visibleRegion.f1983a) && this.f1984b.equals(visibleRegion.f1984b) && this.f1985c.equals(visibleRegion.f1985c) && this.f1986d.equals(visibleRegion.f1986d) && this.f1987e.equals(visibleRegion.f1987e);
    }

    public int hashCode() {
        return ej.m2329a(this.f1983a, this.f1984b, this.f1985c, this.f1986d, this.f1987e);
    }

    public String toString() {
        return ej.m2330a((Object) this).m2328a("nearLeft", this.f1983a).m2328a("nearRight", this.f1984b).m2328a("farLeft", this.f1985c).m2328a("farRight", this.f1986d).m2328a("latLngBounds", this.f1987e).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (af.m2895a()) {
            ae.m3599a(this, parcel, i);
        } else {
            C1000t.m3643a(this, parcel, i);
        }
    }
}
