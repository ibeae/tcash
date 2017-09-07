package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ej;
import com.google.android.gms.internal.ek;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation.C0952a;

public class StreetViewPanoramaCamera implements SafeParcelable {
    public static final C0994m CREATOR = new C0994m();
    public final float f1953a;
    public final float f1954b;
    public final float f1955c;
    private final int f1956d;
    private StreetViewPanoramaOrientation f1957e;

    StreetViewPanoramaCamera(int i, float f, float f2, float f3) {
        boolean z = -90.0f <= f2 && f2 <= 90.0f;
        ek.m2336a(z, (Object) "Tilt needs to be between -90 and 90 inclusive");
        this.f1956d = i;
        this.f1953a = f;
        this.f1954b = 0.0f + f2;
        this.f1955c = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
        this.f1957e = new C0952a().m3321a(f2).m3323b(f3).m3322a();
    }

    int m3318a() {
        return this.f1956d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.f1953a) == Float.floatToIntBits(streetViewPanoramaCamera.f1953a) && Float.floatToIntBits(this.f1954b) == Float.floatToIntBits(streetViewPanoramaCamera.f1954b) && Float.floatToIntBits(this.f1955c) == Float.floatToIntBits(streetViewPanoramaCamera.f1955c);
    }

    public int hashCode() {
        return ej.m2329a(Float.valueOf(this.f1953a), Float.valueOf(this.f1954b), Float.valueOf(this.f1955c));
    }

    public String toString() {
        return ej.m2330a((Object) this).m2328a("zoom", Float.valueOf(this.f1953a)).m2328a("tilt", Float.valueOf(this.f1954b)).m2328a("bearing", Float.valueOf(this.f1955c)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0994m.m3625a(this, parcel, i);
    }
}
