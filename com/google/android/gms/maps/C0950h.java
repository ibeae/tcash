package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0950h {
    static void m3256a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, googleMapOptions.m2821a());
        C0676b.m1507a(parcel, 2, googleMapOptions.m2825b());
        C0676b.m1507a(parcel, 3, googleMapOptions.m2827c());
        C0676b.m1510a(parcel, 4, googleMapOptions.m2840j());
        C0676b.m1514a(parcel, 5, googleMapOptions.m2841k(), i, false);
        C0676b.m1507a(parcel, 6, googleMapOptions.m2829d());
        C0676b.m1507a(parcel, 7, googleMapOptions.m2831e());
        C0676b.m1507a(parcel, 8, googleMapOptions.m2833f());
        C0676b.m1507a(parcel, 9, googleMapOptions.m2835g());
        C0676b.m1507a(parcel, 10, googleMapOptions.m2837h());
        C0676b.m1507a(parcel, 11, googleMapOptions.m2839i());
        C0676b.m1506a(parcel, a);
    }
}
