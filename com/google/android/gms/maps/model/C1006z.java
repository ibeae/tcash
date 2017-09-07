package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C1006z {
    static void m3651a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, markerOptions.m3287a());
        C0676b.m1514a(parcel, 2, markerOptions.m3290c(), i, false);
        C0676b.m1516a(parcel, 3, markerOptions.m3291d(), false);
        C0676b.m1516a(parcel, 4, markerOptions.m3292e(), false);
        C0676b.m1513a(parcel, 5, markerOptions.m3289b(), false);
        C0676b.m1509a(parcel, 6, markerOptions.m3293f());
        C0676b.m1509a(parcel, 7, markerOptions.m3294g());
        C0676b.m1519a(parcel, 8, markerOptions.m3295h());
        C0676b.m1519a(parcel, 9, markerOptions.m3296i());
        C0676b.m1506a(parcel, a);
    }
}
