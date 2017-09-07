package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0640R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ej;
import com.google.android.gms.internal.ek;
import com.google.android.gms.maps.p029a.af;

public final class CameraPosition implements SafeParcelable {
    public static final C0984c CREATOR = new C0984c();
    public final LatLng f1892a;
    public final float f1893b;
    public final float f1894c;
    public final float f1895d;
    private final int f1896e;

    public static final class C0951a {
        private LatLng f1888a;
        private float f1889b;
        private float f1890c;
        private float f1891d;

        public C0951a m3257a(float f) {
            this.f1889b = f;
            return this;
        }

        public C0951a m3258a(LatLng latLng) {
            this.f1888a = latLng;
            return this;
        }

        public CameraPosition m3259a() {
            return new CameraPosition(this.f1888a, this.f1889b, this.f1890c, this.f1891d);
        }

        public C0951a m3260b(float f) {
            this.f1890c = f;
            return this;
        }

        public C0951a m3261c(float f) {
            this.f1891d = f;
            return this;
        }
    }

    CameraPosition(int i, LatLng latLng, float f, float f2, float f3) {
        ek.m2333a((Object) latLng, (Object) "null camera target");
        boolean z = 0.0f <= f2 && f2 <= 90.0f;
        ek.m2336a(z, (Object) "Tilt needs to be between 0 and 90 inclusive");
        this.f1896e = i;
        this.f1892a = latLng;
        this.f1893b = f;
        this.f1894c = f2 + 0.0f;
        if (((double) f3) <= 0.0d) {
            f3 = (f3 % 360.0f) + 360.0f;
        }
        this.f1895d = f3 % 360.0f;
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        this(1, latLng, f, f2, f3);
    }

    public static CameraPosition m3262a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0640R.styleable.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(2) ? obtainAttributes.getFloat(2, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(3) ? obtainAttributes.getFloat(3, 0.0f) : 0.0f));
        C0951a b = m3263b();
        b.m3258a(latLng);
        if (obtainAttributes.hasValue(5)) {
            b.m3257a(obtainAttributes.getFloat(5, 0.0f));
        }
        if (obtainAttributes.hasValue(1)) {
            b.m3261c(obtainAttributes.getFloat(1, 0.0f));
        }
        if (obtainAttributes.hasValue(4)) {
            b.m3260b(obtainAttributes.getFloat(4, 0.0f));
        }
        return b.m3259a();
    }

    public static C0951a m3263b() {
        return new C0951a();
    }

    int m3264a() {
        return this.f1896e;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.f1892a.equals(cameraPosition.f1892a) && Float.floatToIntBits(this.f1893b) == Float.floatToIntBits(cameraPosition.f1893b) && Float.floatToIntBits(this.f1894c) == Float.floatToIntBits(cameraPosition.f1894c) && Float.floatToIntBits(this.f1895d) == Float.floatToIntBits(cameraPosition.f1895d);
    }

    public int hashCode() {
        return ej.m2329a(this.f1892a, Float.valueOf(this.f1893b), Float.valueOf(this.f1894c), Float.valueOf(this.f1895d));
    }

    public String toString() {
        return ej.m2330a((Object) this).m2328a("target", this.f1892a).m2328a("zoom", Float.valueOf(this.f1893b)).m2328a("tilt", Float.valueOf(this.f1894c)).m2328a("bearing", Float.valueOf(this.f1895d)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (af.m2895a()) {
            C1001u.m3646a(this, parcel, i);
        } else {
            C0984c.m3601a(this, parcel, i);
        }
    }
}
