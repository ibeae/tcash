package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ej;
import com.google.android.gms.internal.ek;

public class StreetViewPanoramaOrientation implements SafeParcelable {
    public static final C0997p CREATOR = new C0997p();
    public final float f1967a;
    public final float f1968b;
    private final int f1969c;

    public static final class C0952a {
        public float f1965a;
        public float f1966b;

        public C0952a m3321a(float f) {
            this.f1966b = f;
            return this;
        }

        public StreetViewPanoramaOrientation m3322a() {
            return new StreetViewPanoramaOrientation(this.f1966b, this.f1965a);
        }

        public C0952a m3323b(float f) {
            this.f1965a = f;
            return this;
        }
    }

    public StreetViewPanoramaOrientation(float f, float f2) {
        this(1, f, f2);
    }

    StreetViewPanoramaOrientation(int i, float f, float f2) {
        boolean z = -90.0f <= f && f <= 90.0f;
        ek.m2336a(z, (Object) "Tilt needs to be between -90 and 90 inclusive");
        this.f1969c = i;
        this.f1967a = 0.0f + f;
        if (((double) f2) <= 0.0d) {
            f2 = (f2 % 360.0f) + 360.0f;
        }
        this.f1968b = f2 % 360.0f;
    }

    int m3324a() {
        return this.f1969c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.f1967a) == Float.floatToIntBits(streetViewPanoramaOrientation.f1967a) && Float.floatToIntBits(this.f1968b) == Float.floatToIntBits(streetViewPanoramaOrientation.f1968b);
    }

    public int hashCode() {
        return ej.m2329a(Float.valueOf(this.f1967a), Float.valueOf(this.f1968b));
    }

    public String toString() {
        return ej.m2330a((Object) this).m2328a("tilt", Float.valueOf(this.f1967a)).m2328a("bearing", Float.valueOf(this.f1968b)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0997p.m3634a(this, parcel, i);
    }
}
