package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C1002v {
    static void m3647a(CircleOptions circleOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, circleOptions.m3265a());
        C0676b.m1514a(parcel, 2, circleOptions.m3266b(), i, false);
        C0676b.m1508a(parcel, 3, circleOptions.m3267c());
        C0676b.m1509a(parcel, 4, circleOptions.m3268d());
        C0676b.m1510a(parcel, 5, circleOptions.m3269e());
        C0676b.m1510a(parcel, 6, circleOptions.m3270f());
        C0676b.m1509a(parcel, 7, circleOptions.m3271g());
        C0676b.m1519a(parcel, 8, circleOptions.m3272h());
        C0676b.m1506a(parcel, a);
    }
}
