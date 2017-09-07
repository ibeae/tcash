package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C1004x {
    static void m3649a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, latLngBounds.m3286a());
        C0676b.m1514a(parcel, 2, latLngBounds.f1920a, i, false);
        C0676b.m1514a(parcel, 3, latLngBounds.f1921b, i, false);
        C0676b.m1506a(parcel, a);
    }
}
