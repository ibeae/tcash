package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0999r implements Creator<TileOverlayOptions> {
    static void m3640a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, tileOverlayOptions.m3327a());
        C0676b.m1513a(parcel, 2, tileOverlayOptions.m3328b(), false);
        C0676b.m1519a(parcel, 3, tileOverlayOptions.m3330d());
        C0676b.m1509a(parcel, 4, tileOverlayOptions.m3329c());
        C0676b.m1519a(parcel, 5, tileOverlayOptions.m3331e());
        C0676b.m1506a(parcel, a);
    }

    public TileOverlayOptions m3641a(Parcel parcel) {
        boolean z = false;
        int b = C0675a.m1487b(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    iBinder = C0675a.m1500l(parcel, a);
                    break;
                case 3:
                    z = C0675a.m1491c(parcel, a);
                    break;
                case 4:
                    f = C0675a.m1497i(parcel, a);
                    break;
                case 5:
                    z2 = C0675a.m1491c(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public TileOverlayOptions[] m3642a(int i) {
        return new TileOverlayOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3641a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3642a(i);
    }
}
