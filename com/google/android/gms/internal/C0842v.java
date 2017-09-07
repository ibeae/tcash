package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class C0842v implements SafeParcelable {
    public static final fu CREATOR = new fu();
    public final int f1797a;
    public final boolean f1798b;
    public final boolean f1799c;

    C0842v(int i, boolean z, boolean z2) {
        this.f1797a = i;
        this.f1798b = z;
        this.f1799c = z2;
    }

    public C0842v(boolean z, boolean z2) {
        this.f1797a = 1;
        this.f1798b = z;
        this.f1799c = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        fu.m2637a(this, parcel, i);
    }
}
