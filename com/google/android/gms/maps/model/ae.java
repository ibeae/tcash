package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class ae {
    static void m3599a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, visibleRegion.m3332a());
        C0676b.m1514a(parcel, 2, visibleRegion.f1983a, i, false);
        C0676b.m1514a(parcel, 3, visibleRegion.f1984b, i, false);
        C0676b.m1514a(parcel, 4, visibleRegion.f1985c, i, false);
        C0676b.m1514a(parcel, 5, visibleRegion.f1986d, i, false);
        C0676b.m1514a(parcel, 6, visibleRegion.f1987e, i, false);
        C0676b.m1506a(parcel, a);
    }
}
