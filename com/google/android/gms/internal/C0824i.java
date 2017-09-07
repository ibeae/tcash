package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;
import java.util.List;

public class C0824i implements Creator<ai> {
    static void m2666a(ai aiVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, aiVar.f891a);
        C0676b.m1511a(parcel, 2, aiVar.f892b);
        C0676b.m1512a(parcel, 3, aiVar.f893c, false);
        C0676b.m1510a(parcel, 4, aiVar.f894d);
        C0676b.m1517a(parcel, 5, aiVar.f895e, false);
        C0676b.m1519a(parcel, 6, aiVar.f896f);
        C0676b.m1510a(parcel, 7, aiVar.f897g);
        C0676b.m1519a(parcel, 8, aiVar.f898h);
        C0676b.m1516a(parcel, 9, aiVar.f899i, false);
        C0676b.m1514a(parcel, 10, aiVar.f900j, i, false);
        C0676b.m1514a(parcel, 11, aiVar.f901k, i, false);
        C0676b.m1516a(parcel, 12, aiVar.f902l, false);
        C0676b.m1512a(parcel, 13, aiVar.f903m, false);
        C0676b.m1506a(parcel, a);
    }

    public ai m2667a(Parcel parcel) {
        int b = C0675a.m1487b(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        aw awVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    j = C0675a.m1496h(parcel, a);
                    break;
                case 3:
                    bundle = C0675a.m1501m(parcel, a);
                    break;
                case 4:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 5:
                    list = C0675a.m1504p(parcel, a);
                    break;
                case 6:
                    z = C0675a.m1491c(parcel, a);
                    break;
                case 7:
                    i3 = C0675a.m1494f(parcel, a);
                    break;
                case 8:
                    z2 = C0675a.m1491c(parcel, a);
                    break;
                case 9:
                    str = C0675a.m1499k(parcel, a);
                    break;
                case 10:
                    awVar = (aw) C0675a.m1483a(parcel, a, aw.CREATOR);
                    break;
                case 11:
                    location = (Location) C0675a.m1483a(parcel, a, Location.CREATOR);
                    break;
                case 12:
                    str2 = C0675a.m1499k(parcel, a);
                    break;
                case 13:
                    bundle2 = C0675a.m1501m(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ai(i, j, bundle, i2, list, z, i3, z2, str, awVar, location, str2, bundle2);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public ai[] m2668a(int i) {
        return new ai[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2667a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2668a(i);
    }
}
