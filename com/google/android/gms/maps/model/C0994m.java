package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0994m implements Creator<StreetViewPanoramaCamera> {
    static void m3625a(StreetViewPanoramaCamera streetViewPanoramaCamera, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, streetViewPanoramaCamera.m3318a());
        C0676b.m1509a(parcel, 2, streetViewPanoramaCamera.f1953a);
        C0676b.m1509a(parcel, 3, streetViewPanoramaCamera.f1954b);
        C0676b.m1509a(parcel, 4, streetViewPanoramaCamera.f1955c);
        C0676b.m1506a(parcel, a);
    }

    public StreetViewPanoramaCamera m3626a(Parcel parcel) {
        float f = 0.0f;
        int b = C0675a.m1487b(parcel);
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
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
                    f3 = C0675a.m1497i(parcel, a);
                    break;
                case 4:
                    f = C0675a.m1497i(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StreetViewPanoramaCamera(i, f2, f3, f);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public StreetViewPanoramaCamera[] m3627a(int i) {
        return new StreetViewPanoramaCamera[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3626a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3627a(i);
    }
}
