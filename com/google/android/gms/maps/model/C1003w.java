package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C1003w {
    static void m3648a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, groundOverlayOptions.m3274b());
        C0676b.m1513a(parcel, 2, groundOverlayOptions.m3273a(), false);
        C0676b.m1514a(parcel, 3, groundOverlayOptions.m3275c(), i, false);
        C0676b.m1509a(parcel, 4, groundOverlayOptions.m3276d());
        C0676b.m1509a(parcel, 5, groundOverlayOptions.m3277e());
        C0676b.m1514a(parcel, 6, groundOverlayOptions.m3278f(), i, false);
        C0676b.m1509a(parcel, 7, groundOverlayOptions.m3279g());
        C0676b.m1509a(parcel, 8, groundOverlayOptions.m3280h());
        C0676b.m1519a(parcel, 9, groundOverlayOptions.m3284l());
        C0676b.m1509a(parcel, 10, groundOverlayOptions.m3281i());
        C0676b.m1509a(parcel, 11, groundOverlayOptions.m3282j());
        C0676b.m1509a(parcel, 12, groundOverlayOptions.m3283k());
        C0676b.m1506a(parcel, a);
    }
}
