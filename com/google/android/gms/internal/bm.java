package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class bm implements Creator<cq> {
    static void m1730a(cq cqVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, cqVar.f1189a);
        C0676b.m1513a(parcel, 2, cqVar.m1955a(), false);
        C0676b.m1513a(parcel, 3, cqVar.m1956b(), false);
        C0676b.m1513a(parcel, 4, cqVar.m1957c(), false);
        C0676b.m1513a(parcel, 5, cqVar.m1958d(), false);
        C0676b.m1506a(parcel, a);
    }

    public cq m1731a(Parcel parcel) {
        IBinder iBinder = null;
        int b = C0675a.m1487b(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    iBinder4 = C0675a.m1500l(parcel, a);
                    break;
                case 3:
                    iBinder3 = C0675a.m1500l(parcel, a);
                    break;
                case 4:
                    iBinder2 = C0675a.m1500l(parcel, a);
                    break;
                case 5:
                    iBinder = C0675a.m1500l(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new cq(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public cq[] m1732a(int i) {
        return new cq[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1731a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1732a(i);
    }
}
