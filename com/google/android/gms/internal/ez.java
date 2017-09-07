package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class ez implements Creator<jo> {
    static void m2469a(jo joVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, joVar.f1669a);
        C0676b.m1516a(parcel, 2, joVar.m2694a(), false);
        C0676b.m1516a(parcel, 3, joVar.m2695b(), false);
        C0676b.m1506a(parcel, a);
    }

    public jo m2470a(Parcel parcel) {
        String str = null;
        int b = C0675a.m1487b(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    str2 = C0675a.m1499k(parcel, a);
                    break;
                case 3:
                    str = C0675a.m1499k(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new jo(i, str2, str);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public jo[] m2471a(int i) {
        return new jo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2470a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2471a(i);
    }
}
