package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C1005y {
    static void m3650a(LatLng latLng, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, latLng.m3285a());
        C0676b.m1508a(parcel, 2, latLng.f1917a);
        C0676b.m1508a(parcel, 3, latLng.f1918b);
        C0676b.m1506a(parcel, a);
    }
}
