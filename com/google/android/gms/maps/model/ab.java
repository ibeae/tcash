package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class ab {
    static void m3596a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, polylineOptions.m3311a());
        C0676b.m1526b(parcel, 2, polylineOptions.m3312b(), false);
        C0676b.m1509a(parcel, 3, polylineOptions.m3313c());
        C0676b.m1510a(parcel, 4, polylineOptions.m3314d());
        C0676b.m1509a(parcel, 5, polylineOptions.m3315e());
        C0676b.m1519a(parcel, 6, polylineOptions.m3316f());
        C0676b.m1519a(parcel, 7, polylineOptions.m3317g());
        C0676b.m1506a(parcel, a);
    }
}
