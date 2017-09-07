package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class C0946f implements Creator<StreetViewPanoramaOptions> {
    static void m3237a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, streetViewPanoramaOptions.m2842a());
        C0676b.m1514a(parcel, 2, streetViewPanoramaOptions.m2848g(), i, false);
        C0676b.m1516a(parcel, 3, streetViewPanoramaOptions.m2851j(), false);
        C0676b.m1514a(parcel, 4, streetViewPanoramaOptions.m2849h(), i, false);
        C0676b.m1515a(parcel, 5, streetViewPanoramaOptions.m2850i(), false);
        C0676b.m1507a(parcel, 6, streetViewPanoramaOptions.m2843b());
        C0676b.m1507a(parcel, 7, streetViewPanoramaOptions.m2844c());
        C0676b.m1507a(parcel, 8, streetViewPanoramaOptions.m2845d());
        C0676b.m1507a(parcel, 9, streetViewPanoramaOptions.m2846e());
        C0676b.m1507a(parcel, 10, streetViewPanoramaOptions.m2847f());
        C0676b.m1506a(parcel, a);
    }

    public StreetViewPanoramaOptions m3238a(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int b2 = C0675a.m1487b(parcel);
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) C0675a.m1483a(parcel, a, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = C0675a.m1499k(parcel, a);
                    break;
                case 4:
                    latLng = (LatLng) C0675a.m1483a(parcel, a, LatLng.CREATOR);
                    break;
                case 5:
                    num = C0675a.m1495g(parcel, a);
                    break;
                case 6:
                    b6 = C0675a.m1492d(parcel, a);
                    break;
                case 7:
                    b5 = C0675a.m1492d(parcel, a);
                    break;
                case 8:
                    b4 = C0675a.m1492d(parcel, a);
                    break;
                case 9:
                    b3 = C0675a.m1492d(parcel, a);
                    break;
                case 10:
                    b = C0675a.m1492d(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b2) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b6, b5, b4, b3, b);
        }
        throw new C0674a("Overread allowed size end=" + b2, parcel);
    }

    public StreetViewPanoramaOptions[] m3239a(int i) {
        return new StreetViewPanoramaOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3238a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3239a(i);
    }
}
