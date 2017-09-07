package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;
import java.util.List;

public class cp implements Creator<du> {
    static void m1950a(du duVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, duVar.f1381a);
        C0676b.m1516a(parcel, 2, duVar.f1382b, false);
        C0676b.m1516a(parcel, 3, duVar.f1383c, false);
        C0676b.m1517a(parcel, 4, duVar.f1384d, false);
        C0676b.m1510a(parcel, 5, duVar.f1385e);
        C0676b.m1517a(parcel, 6, duVar.f1386f, false);
        C0676b.m1511a(parcel, 7, duVar.f1387g);
        C0676b.m1519a(parcel, 8, duVar.f1388h);
        C0676b.m1511a(parcel, 9, duVar.f1389i);
        C0676b.m1517a(parcel, 10, duVar.f1390j, false);
        C0676b.m1511a(parcel, 11, duVar.f1391k);
        C0676b.m1510a(parcel, 12, duVar.f1392l);
        C0676b.m1516a(parcel, 13, duVar.f1393m, false);
        C0676b.m1511a(parcel, 14, duVar.f1394n);
        C0676b.m1516a(parcel, 15, duVar.f1395o, false);
        C0676b.m1516a(parcel, 19, duVar.f1397q, false);
        C0676b.m1519a(parcel, 18, duVar.f1396p);
        C0676b.m1516a(parcel, 21, duVar.f1398r, false);
        C0676b.m1506a(parcel, a);
    }

    public du m1951a(Parcel parcel) {
        int b = C0675a.m1487b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    str = C0675a.m1499k(parcel, a);
                    break;
                case 3:
                    str2 = C0675a.m1499k(parcel, a);
                    break;
                case 4:
                    list = C0675a.m1504p(parcel, a);
                    break;
                case 5:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 6:
                    list2 = C0675a.m1504p(parcel, a);
                    break;
                case 7:
                    j = C0675a.m1496h(parcel, a);
                    break;
                case 8:
                    z = C0675a.m1491c(parcel, a);
                    break;
                case 9:
                    j2 = C0675a.m1496h(parcel, a);
                    break;
                case 10:
                    list3 = C0675a.m1504p(parcel, a);
                    break;
                case 11:
                    j3 = C0675a.m1496h(parcel, a);
                    break;
                case 12:
                    i3 = C0675a.m1494f(parcel, a);
                    break;
                case 13:
                    str3 = C0675a.m1499k(parcel, a);
                    break;
                case 14:
                    j4 = C0675a.m1496h(parcel, a);
                    break;
                case 15:
                    str4 = C0675a.m1499k(parcel, a);
                    break;
                case 18:
                    z2 = C0675a.m1491c(parcel, a);
                    break;
                case 19:
                    str5 = C0675a.m1499k(parcel, a);
                    break;
                case 21:
                    str6 = C0675a.m1499k(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new du(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public du[] m1952a(int i) {
        return new du[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1951a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1952a(i);
    }
}
