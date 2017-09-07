package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C1000t implements Creator<VisibleRegion> {
    static void m3643a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, visibleRegion.m3332a());
        C0676b.m1514a(parcel, 2, visibleRegion.f1983a, i, false);
        C0676b.m1514a(parcel, 3, visibleRegion.f1984b, i, false);
        C0676b.m1514a(parcel, 4, visibleRegion.f1985c, i, false);
        C0676b.m1514a(parcel, 5, visibleRegion.f1986d, i, false);
        C0676b.m1514a(parcel, 6, visibleRegion.f1987e, i, false);
        C0676b.m1506a(parcel, a);
    }

    public VisibleRegion m3644a(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int b = C0675a.m1487b(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    latLng4 = (LatLng) C0675a.m1483a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) C0675a.m1483a(parcel, a, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) C0675a.m1483a(parcel, a, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) C0675a.m1483a(parcel, a, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0675a.m1483a(parcel, a, LatLngBounds.CREATOR);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public VisibleRegion[] m3645a(int i) {
        return new VisibleRegion[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3644a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3645a(i);
    }
}
