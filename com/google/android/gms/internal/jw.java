package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class jw implements SafeParcelable {
    public static final fd CREATOR = new fd();
    public static final jw f1736a = m2706a("test_type", 1);
    public static final jw f1737b = m2706a("saved_offers", 4);
    public static final Set<jw> f1738c = Collections.unmodifiableSet(new HashSet(Arrays.asList(new jw[]{f1736a, f1737b})));
    final int f1739d;
    final String f1740e;
    final int f1741f;

    jw(int i, String str, int i2) {
        ek.m2334a(str);
        this.f1739d = i;
        this.f1740e = str;
        this.f1741f = i2;
    }

    private static jw m2706a(String str, int i) {
        return new jw(0, str, i);
    }

    public int describeContents() {
        fd fdVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jw)) {
            return false;
        }
        jw jwVar = (jw) obj;
        return this.f1740e.equals(jwVar.f1740e) && this.f1741f == jwVar.f1741f;
    }

    public int hashCode() {
        return this.f1740e.hashCode();
    }

    public String toString() {
        return this.f1740e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        fd fdVar = CREATOR;
        fd.m2489a(this, parcel, i);
    }
}
