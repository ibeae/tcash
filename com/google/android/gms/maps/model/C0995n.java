package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0995n implements Creator<StreetViewPanoramaLink> {
    static void m3628a(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, streetViewPanoramaLink.m3319a());
        C0676b.m1516a(parcel, 2, streetViewPanoramaLink.f1958a, false);
        C0676b.m1509a(parcel, 3, streetViewPanoramaLink.f1959b);
        C0676b.m1506a(parcel, a);
    }

    public StreetViewPanoramaLink m3629a(Parcel parcel) {
        int b = C0675a.m1487b(parcel);
        int i = 0;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    str = C0675a.m1499k(parcel, a);
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
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public StreetViewPanoramaLink[] m3630a(int i) {
        return new StreetViewPanoramaLink[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3629a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3630a(i);
    }
}
