package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class dr implements Creator<ev> {
    static void m2121a(ev evVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, evVar.f1563a);
        C0676b.m1516a(parcel, 2, evVar.f1564b, false);
        C0676b.m1510a(parcel, 3, evVar.f1565c);
        C0676b.m1510a(parcel, 4, evVar.f1566d);
        C0676b.m1519a(parcel, 5, evVar.f1567e);
        C0676b.m1506a(parcel, a);
    }

    public ev m2122a(Parcel parcel) {
        boolean z = false;
        int b = C0675a.m1487b(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i3 = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    str = C0675a.m1499k(parcel, a);
                    break;
                case 3:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 4:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 5:
                    z = C0675a.m1491c(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ev(i3, str, i2, i, z);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public ev[] m2123a(int i) {
        return new ev[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2122a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2123a(i);
    }
}
