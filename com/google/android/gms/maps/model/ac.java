package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class ac {
    static void m3597a(Tile tile, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, tile.m3325a());
        C0676b.m1510a(parcel, 2, tile.f1970a);
        C0676b.m1510a(parcel, 3, tile.f1971b);
        C0676b.m1520a(parcel, 4, tile.f1972c, false);
        C0676b.m1506a(parcel, a);
    }
}
