package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ej;
import com.google.android.gms.internal.ek;
import com.google.android.gms.maps.p029a.af;

public final class LatLngBounds implements SafeParcelable {
    public static final C0987f CREATOR = new C0987f();
    public final LatLng f1920a;
    public final LatLng f1921b;
    private final int f1922c;

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        ek.m2333a((Object) latLng, (Object) "null southwest");
        ek.m2333a((Object) latLng2, (Object) "null northeast");
        ek.m2337a(latLng2.f1917a >= latLng.f1917a, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.f1917a), Double.valueOf(latLng2.f1917a));
        this.f1922c = i;
        this.f1920a = latLng;
        this.f1921b = latLng2;
    }

    int m3286a() {
        return this.f1922c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.f1920a.equals(latLngBounds.f1920a) && this.f1921b.equals(latLngBounds.f1921b);
    }

    public int hashCode() {
        return ej.m2329a(this.f1920a, this.f1921b);
    }

    public String toString() {
        return ej.m2330a((Object) this).m2328a("southwest", this.f1920a).m2328a("northeast", this.f1921b).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (af.m2895a()) {
            C1004x.m3649a(this, parcel, i);
        } else {
            C0987f.m3610a(this, parcel, i);
        }
    }
}
