package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class ad {
    static void m3598a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, tileOverlayOptions.m3327a());
        C0676b.m1513a(parcel, 2, tileOverlayOptions.m3328b(), false);
        C0676b.m1519a(parcel, 3, tileOverlayOptions.m3330d());
        C0676b.m1509a(parcel, 4, tileOverlayOptions.m3329c());
        C0676b.m1506a(parcel, a);
    }
}
