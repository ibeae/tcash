package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0998q implements Creator<Tile> {
    static void m3637a(Tile tile, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, tile.m3325a());
        C0676b.m1510a(parcel, 2, tile.f1970a);
        C0676b.m1510a(parcel, 3, tile.f1971b);
        C0676b.m1520a(parcel, 4, tile.f1972c, false);
        C0676b.m1506a(parcel, a);
    }

    public Tile m3638a(Parcel parcel) {
        int i = 0;
        int b = C0675a.m1487b(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i3 = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 3:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 4:
                    bArr = C0675a.m1502n(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public Tile[] m3639a(int i) {
        return new Tile[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3638a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3639a(i);
    }
}
