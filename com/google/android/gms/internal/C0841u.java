package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class C0841u implements Creator<aw> {
    static void m2791a(aw awVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, awVar.f962a);
        C0676b.m1510a(parcel, 2, awVar.f963b);
        C0676b.m1510a(parcel, 3, awVar.f964c);
        C0676b.m1510a(parcel, 4, awVar.f965d);
        C0676b.m1510a(parcel, 5, awVar.f966e);
        C0676b.m1510a(parcel, 6, awVar.f967f);
        C0676b.m1510a(parcel, 7, awVar.f968g);
        C0676b.m1510a(parcel, 8, awVar.f969h);
        C0676b.m1510a(parcel, 9, awVar.f970i);
        C0676b.m1516a(parcel, 10, awVar.f971j, false);
        C0676b.m1510a(parcel, 11, awVar.f972k);
        C0676b.m1516a(parcel, 12, awVar.f973l, false);
        C0676b.m1510a(parcel, 13, awVar.f974m);
        C0676b.m1510a(parcel, 14, awVar.f975n);
        C0676b.m1516a(parcel, 15, awVar.f976o, false);
        C0676b.m1506a(parcel, a);
    }

    public aw m2792a(Parcel parcel) {
        int b = C0675a.m1487b(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 3:
                    i3 = C0675a.m1494f(parcel, a);
                    break;
                case 4:
                    i4 = C0675a.m1494f(parcel, a);
                    break;
                case 5:
                    i5 = C0675a.m1494f(parcel, a);
                    break;
                case 6:
                    i6 = C0675a.m1494f(parcel, a);
                    break;
                case 7:
                    i7 = C0675a.m1494f(parcel, a);
                    break;
                case 8:
                    i8 = C0675a.m1494f(parcel, a);
                    break;
                case 9:
                    i9 = C0675a.m1494f(parcel, a);
                    break;
                case 10:
                    str = C0675a.m1499k(parcel, a);
                    break;
                case 11:
                    i10 = C0675a.m1494f(parcel, a);
                    break;
                case 12:
                    str2 = C0675a.m1499k(parcel, a);
                    break;
                case 13:
                    i11 = C0675a.m1494f(parcel, a);
                    break;
                case 14:
                    i12 = C0675a.m1494f(parcel, a);
                    break;
                case 15:
                    str3 = C0675a.m1499k(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new aw(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public aw[] m2793a(int i) {
        return new aw[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2792a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2793a(i);
    }
}
