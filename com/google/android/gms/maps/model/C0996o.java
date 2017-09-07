package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0996o implements Creator<StreetViewPanoramaLocation> {
    static void m3631a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, streetViewPanoramaLocation.m3320a());
        C0676b.m1521a(parcel, 2, streetViewPanoramaLocation.f1961a, i, false);
        C0676b.m1514a(parcel, 3, streetViewPanoramaLocation.f1962b, i, false);
        C0676b.m1516a(parcel, 4, streetViewPanoramaLocation.f1963c, false);
        C0676b.m1506a(parcel, a);
    }

    public StreetViewPanoramaLocation m3632a(Parcel parcel) {
        String str = null;
        int b = C0675a.m1487b(parcel);
        int i = 0;
        LatLng latLng = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        while (parcel.dataPosition() < b) {
            LatLng latLng2;
            StreetViewPanoramaLink[] streetViewPanoramaLinkArr2;
            int f;
            String str2;
            int a = C0675a.m1481a(parcel);
            String str3;
            switch (C0675a.m1480a(a)) {
                case 1:
                    str3 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    f = C0675a.m1494f(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    f = i;
                    LatLng latLng3 = latLng;
                    streetViewPanoramaLinkArr2 = (StreetViewPanoramaLink[]) C0675a.m1489b(parcel, a, StreetViewPanoramaLink.CREATOR);
                    str2 = str;
                    latLng2 = latLng3;
                    break;
                case 3:
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    f = i;
                    str3 = str;
                    latLng2 = (LatLng) C0675a.m1483a(parcel, a, LatLng.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = C0675a.m1499k(parcel, a);
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    f = i;
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    str2 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    f = i;
                    break;
            }
            i = f;
            streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
            latLng = latLng2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new StreetViewPanoramaLocation(i, streetViewPanoramaLinkArr, latLng, str);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public StreetViewPanoramaLocation[] m3633a(int i) {
        return new StreetViewPanoramaLocation[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3632a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3633a(i);
    }
}
