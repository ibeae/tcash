package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class fu implements Creator<C0842v> {
    static void m2637a(C0842v c0842v, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, c0842v.f1797a);
        C0676b.m1519a(parcel, 2, c0842v.f1798b);
        C0676b.m1519a(parcel, 3, c0842v.f1799c);
        C0676b.m1506a(parcel, a);
    }

    public C0842v m2638a(Parcel parcel) {
        boolean z = false;
        int b = C0675a.m1487b(parcel);
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    z2 = C0675a.m1491c(parcel, a);
                    break;
                case 3:
                    z = C0675a.m1491c(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new C0842v(i, z2, z);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public C0842v[] m2639a(int i) {
        return new C0842v[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2638a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2639a(i);
    }
}
