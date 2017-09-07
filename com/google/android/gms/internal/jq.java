package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

public final class jq implements SafeParcelable {
    public static final fa CREATOR = new fa();
    static final long f1672a = TimeUnit.HOURS.toMillis(1);
    final int f1673b;
    private final jm f1674c;
    private final long f1675d;
    private final int f1676e;

    public jq(int i, jm jmVar, long j, int i2) {
        this.f1673b = i;
        this.f1674c = jmVar;
        this.f1675d = j;
        this.f1676e = i2;
    }

    public jm m2696a() {
        return this.f1674c;
    }

    public long m2697b() {
        return this.f1675d;
    }

    public int m2698c() {
        return this.f1676e;
    }

    public int describeContents() {
        fa faVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jq)) {
            return false;
        }
        jq jqVar = (jq) obj;
        return ej.m2331a(this.f1674c, jqVar.f1674c) && this.f1675d == jqVar.f1675d && this.f1676e == jqVar.f1676e;
    }

    public int hashCode() {
        return ej.m2329a(this.f1674c, Long.valueOf(this.f1675d), Integer.valueOf(this.f1676e));
    }

    public String toString() {
        return ej.m2330a((Object) this).m2328a("filter", this.f1674c).m2328a("interval", Long.valueOf(this.f1675d)).m2328a("priority", Integer.valueOf(this.f1676e)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        fa faVar = CREATOR;
        fa.m2480a(this, parcel, i);
    }
}
