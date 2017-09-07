package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0987f implements Creator<LatLngBounds> {
    static void m3610a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, latLngBounds.m3286a());
        C0676b.m1514a(parcel, 2, latLngBounds.f1920a, i, false);
        C0676b.m1514a(parcel, 3, latLngBounds.f1921b, i, false);
        C0676b.m1506a(parcel, a);
    }

    public LatLngBounds m3611a(Parcel parcel) {
        LatLng latLng = null;
        int b = C0675a.m1487b(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < b) {
            int f;
            LatLng latLng3;
            int a = C0675a.m1481a(parcel);
            LatLng latLng4;
            switch (C0675a.m1480a(a)) {
                case 1:
                    latLng4 = latLng;
                    latLng = latLng2;
                    f = C0675a.m1494f(parcel, a);
                    latLng3 = latLng4;
                    break;
                case 2:
                    f = i;
                    latLng4 = (LatLng) C0675a.m1483a(parcel, a, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case 3:
                    latLng3 = (LatLng) C0675a.m1483a(parcel, a, LatLng.CREATOR);
                    latLng = latLng2;
                    f = i;
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    latLng3 = latLng;
                    latLng = latLng2;
                    f = i;
                    break;
            }
            i = f;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == b) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public LatLngBounds[] m3612a(int i) {
        return new LatLngBounds[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3611a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3612a(i);
    }
}
