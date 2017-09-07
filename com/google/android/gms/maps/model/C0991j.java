package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;
import java.util.ArrayList;
import java.util.List;

public class C0991j implements Creator<PolygonOptions> {
    static void m3619a(PolygonOptions polygonOptions, Parcel parcel, int i) {
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

    public PolygonOptions m3620a(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = C0675a.m1487b(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i3 = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    list = C0675a.m1490c(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    C0675a.m1486a(parcel, a, arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    f2 = C0675a.m1497i(parcel, a);
                    break;
                case 5:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 6:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 7:
                    f = C0675a.m1497i(parcel, a);
                    break;
                case 8:
                    z2 = C0675a.m1491c(parcel, a);
                    break;
                case 9:
                    z = C0675a.m1491c(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public PolygonOptions[] m3621a(int i) {
        return new PolygonOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3620a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3621a(i);
    }
}
