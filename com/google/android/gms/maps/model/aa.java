package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class aa {
    static void m3595a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, polygonOptions.m3302a());
        C0676b.m1526b(parcel, 2, polygonOptions.m3304c(), false);
        C0676b.m1528c(parcel, 3, polygonOptions.m3303b(), false);
        C0676b.m1509a(parcel, 4, polygonOptions.m3305d());
        C0676b.m1510a(parcel, 5, polygonOptions.m3306e());
        C0676b.m1510a(parcel, 6, polygonOptions.m3307f());
        C0676b.m1509a(parcel, 7, polygonOptions.m3308g());
        C0676b.m1519a(parcel, 8, polygonOptions.m3309h());
        C0676b.m1519a(parcel, 9, polygonOptions.m3310i());
        C0676b.m1506a(parcel, a);
    }
}
