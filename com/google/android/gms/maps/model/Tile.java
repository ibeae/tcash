package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.p029a.af;

public final class Tile implements SafeParcelable {
    public static final C0998q CREATOR = new C0998q();
    public final int f1970a;
    public final int f1971b;
    public final byte[] f1972c;
    private final int f1973d;

    Tile(int i, int i2, int i3, byte[] bArr) {
        this.f1973d = i;
        this.f1970a = i2;
        this.f1971b = i3;
        this.f1972c = bArr;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }

    int m3325a() {
        return this.f1973d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (af.m2895a()) {
            ac.m3597a(this, parcel, i);
        } else {
            C0998q.m3637a(this, parcel, i);
        }
    }
}
