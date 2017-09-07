package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0997p implements Creator<StreetViewPanoramaOrientation> {
    static void m3634a(StreetViewPanoramaOrientation streetViewPanoramaOrientation, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, streetViewPanoramaOrientation.m3324a());
        C0676b.m1509a(parcel, 2, streetViewPanoramaOrientation.f1967a);
        C0676b.m1509a(parcel, 3, streetViewPanoramaOrientation.f1968b);
        C0676b.m1506a(parcel, a);
    }

    public StreetViewPanoramaOrientation m3635a(Parcel parcel) {
        float f = 0.0f;
        int b = C0675a.m1487b(parcel);
        int i = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    f2 = C0675a.m1497i(parcel, a);
                    break;
                case 3:
                    f = C0675a.m1497i(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StreetViewPanoramaOrientation(i, f2, f);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public StreetViewPanoramaOrientation[] m3636a(int i) {
        return new StreetViewPanoramaOrientation[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3635a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3636a(i);
    }
}
