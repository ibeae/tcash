package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class bg implements Creator<ch> {
    static void m1707a(ch chVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, chVar.f1121a);
        C0676b.m1514a(parcel, 2, chVar.f1122b, i, false);
        C0676b.m1513a(parcel, 3, chVar.m1854a(), false);
        C0676b.m1513a(parcel, 4, chVar.m1855b(), false);
        C0676b.m1513a(parcel, 5, chVar.m1856c(), false);
        C0676b.m1513a(parcel, 6, chVar.m1857d(), false);
        C0676b.m1516a(parcel, 7, chVar.f1127g, false);
        C0676b.m1519a(parcel, 8, chVar.f1128h);
        C0676b.m1516a(parcel, 9, chVar.f1129i, false);
        C0676b.m1513a(parcel, 10, chVar.m1859f(), false);
        C0676b.m1510a(parcel, 11, chVar.f1131k);
        C0676b.m1510a(parcel, 12, chVar.f1132l);
        C0676b.m1516a(parcel, 13, chVar.f1133m, false);
        C0676b.m1514a(parcel, 14, chVar.f1134n, i, false);
        C0676b.m1513a(parcel, 15, chVar.m1858e(), false);
        C0676b.m1514a(parcel, 17, chVar.f1137q, i, false);
        C0676b.m1516a(parcel, 16, chVar.f1136p, false);
        C0676b.m1506a(parcel, a);
    }

    public ch m1708a(Parcel parcel) {
        int b = C0675a.m1487b(parcel);
        int i = 0;
        ce ceVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        ev evVar = null;
        IBinder iBinder6 = null;
        String str4 = null;
        C0842v c0842v = null;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    ceVar = (ce) C0675a.m1483a(parcel, a, ce.CREATOR);
                    break;
                case 3:
                    iBinder = C0675a.m1500l(parcel, a);
                    break;
                case 4:
                    iBinder2 = C0675a.m1500l(parcel, a);
                    break;
                case 5:
                    iBinder3 = C0675a.m1500l(parcel, a);
                    break;
                case 6:
                    iBinder4 = C0675a.m1500l(parcel, a);
                    break;
                case 7:
                    str = C0675a.m1499k(parcel, a);
                    break;
                case 8:
                    z = C0675a.m1491c(parcel, a);
                    break;
                case 9:
                    str2 = C0675a.m1499k(parcel, a);
                    break;
                case 10:
                    iBinder5 = C0675a.m1500l(parcel, a);
                    break;
                case 11:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 12:
                    i3 = C0675a.m1494f(parcel, a);
                    break;
                case 13:
                    str3 = C0675a.m1499k(parcel, a);
                    break;
                case 14:
                    evVar = (ev) C0675a.m1483a(parcel, a, (Creator) ev.CREATOR);
                    break;
                case 15:
                    iBinder6 = C0675a.m1500l(parcel, a);
                    break;
                case 16:
                    str4 = C0675a.m1499k(parcel, a);
                    break;
                case 17:
                    c0842v = (C0842v) C0675a.m1483a(parcel, a, (Creator) C0842v.CREATOR);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ch(i, ceVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, evVar, iBinder6, str4, c0842v);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public ch[] m1709a(int i) {
        return new ch[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1708a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1709a(i);
    }
}
