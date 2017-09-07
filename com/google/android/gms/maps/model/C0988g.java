package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0988g implements Creator<LatLng> {
    static void m3613a(LatLng latLng, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, latLng.m3285a());
        C0676b.m1508a(parcel, 2, latLng.f1917a);
        C0676b.m1508a(parcel, 3, latLng.f1918b);
        C0676b.m1506a(parcel, a);
    }

    public LatLng m3614a(Parcel parcel) {
        double d = 0.0d;
        int b = C0675a.m1487b(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    d2 = C0675a.m1498j(parcel, a);
                    break;
                case 3:
                    d = C0675a.m1498j(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LatLng(i, d2, d);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public LatLng[] m3615a(int i) {
        return new LatLng[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3614a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3615a(i);
    }
}
