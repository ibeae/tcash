package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class co implements Creator<ds> {
    static void m1947a(ds dsVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, dsVar.f1355a);
        C0676b.m1512a(parcel, 2, dsVar.f1356b, false);
        C0676b.m1514a(parcel, 3, dsVar.f1357c, i, false);
        C0676b.m1514a(parcel, 4, dsVar.f1358d, i, false);
        C0676b.m1516a(parcel, 5, dsVar.f1359e, false);
        C0676b.m1514a(parcel, 6, dsVar.f1360f, i, false);
        C0676b.m1514a(parcel, 7, dsVar.f1361g, i, false);
        C0676b.m1516a(parcel, 8, dsVar.f1362h, false);
        C0676b.m1516a(parcel, 9, dsVar.f1363i, false);
        C0676b.m1516a(parcel, 10, dsVar.f1364j, false);
        C0676b.m1514a(parcel, 11, dsVar.f1365k, i, false);
        C0676b.m1512a(parcel, 12, dsVar.f1366l, false);
        C0676b.m1516a(parcel, 13, dsVar.f1367m, false);
        C0676b.m1506a(parcel, a);
    }

    public ds m1948a(Parcel parcel) {
        int b = C0675a.m1487b(parcel);
        int i = 0;
        Bundle bundle = null;
        ai aiVar = null;
        al alVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        ev evVar = null;
        Bundle bundle2 = null;
        String str5 = null;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    bundle = C0675a.m1501m(parcel, a);
                    break;
                case 3:
                    aiVar = (ai) C0675a.m1483a(parcel, a, ai.CREATOR);
                    break;
                case 4:
                    alVar = (al) C0675a.m1483a(parcel, a, al.CREATOR);
                    break;
                case 5:
                    str = C0675a.m1499k(parcel, a);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) C0675a.m1483a(parcel, a, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) C0675a.m1483a(parcel, a, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = C0675a.m1499k(parcel, a);
                    break;
                case 9:
                    str3 = C0675a.m1499k(parcel, a);
                    break;
                case 10:
                    str4 = C0675a.m1499k(parcel, a);
                    break;
                case 11:
                    evVar = (ev) C0675a.m1483a(parcel, a, ev.CREATOR);
                    break;
                case 12:
                    bundle2 = C0675a.m1501m(parcel, a);
                    break;
                case 13:
                    str5 = C0675a.m1499k(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ds(i, bundle, aiVar, alVar, str, applicationInfo, packageInfo, str2, str3, str4, evVar, bundle2, str5);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public ds[] m1949a(int i) {
        return new ds[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1948a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1949a(i);
    }
}
