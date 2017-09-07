package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C1001u {
    static void m3646a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, cameraPosition.m3264a());
        C0676b.m1514a(parcel, 2, cameraPosition.f1892a, i, false);
        C0676b.m1509a(parcel, 3, cameraPosition.f1893b);
        C0676b.m1509a(parcel, 4, cameraPosition.f1894c);
        C0676b.m1509a(parcel, 5, cameraPosition.f1895d);
        C0676b.m1506a(parcel, a);
    }
}
