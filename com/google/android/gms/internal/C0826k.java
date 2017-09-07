package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0826k implements Creator<al> {
    static void m2707a(al alVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, alVar.f920a);
        C0676b.m1516a(parcel, 2, alVar.f921b, false);
        C0676b.m1510a(parcel, 3, alVar.f922c);
        C0676b.m1510a(parcel, 4, alVar.f923d);
        C0676b.m1519a(parcel, 5, alVar.f924e);
        C0676b.m1510a(parcel, 6, alVar.f925f);
        C0676b.m1510a(parcel, 7, alVar.f926g);
        C0676b.m1521a(parcel, 8, alVar.f927h, i, false);
        C0676b.m1506a(parcel, a);
    }

    public al m2708a(Parcel parcel) {
        al[] alVarArr = null;
        int i = 0;
        int b = C0675a.m1487b(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i5 = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    str = C0675a.m1499k(parcel, a);
                    break;
                case 3:
                    i4 = C0675a.m1494f(parcel, a);
                    break;
                case 4:
                    i3 = C0675a.m1494f(parcel, a);
                    break;
                case 5:
                    z = C0675a.m1491c(parcel, a);
                    break;
                case 6:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 7:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 8:
                    alVarArr = (al[]) C0675a.m1489b(parcel, a, al.CREATOR);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new al(i5, str, i4, i3, z, i2, i, alVarArr);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public al[] m2709a(int i) {
        return new al[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2708a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2709a(i);
    }
}
