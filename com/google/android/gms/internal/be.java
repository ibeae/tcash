package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class be implements Creator<ce> {
    static void m1670a(ce ceVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, 1, ceVar.f1111a);
        C0676b.m1516a(parcel, 2, ceVar.f1112b, false);
        C0676b.m1516a(parcel, 3, ceVar.f1113c, false);
        C0676b.m1516a(parcel, 4, ceVar.f1114d, false);
        C0676b.m1516a(parcel, 5, ceVar.f1115e, false);
        C0676b.m1516a(parcel, 6, ceVar.f1116f, false);
        C0676b.m1516a(parcel, 7, ceVar.f1117g, false);
        C0676b.m1516a(parcel, 8, ceVar.f1118h, false);
        C0676b.m1506a(parcel, a);
    }

    public ce m1671a(Parcel parcel) {
        String str = null;
        int b = C0675a.m1487b(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    i = C0675a.m1494f(parcel, a);
                    break;
                case 2:
                    str7 = C0675a.m1499k(parcel, a);
                    break;
                case 3:
                    str6 = C0675a.m1499k(parcel, a);
                    break;
                case 4:
                    str5 = C0675a.m1499k(parcel, a);
                    break;
                case 5:
                    str4 = C0675a.m1499k(parcel, a);
                    break;
                case 6:
                    str3 = C0675a.m1499k(parcel, a);
                    break;
                case 7:
                    str2 = C0675a.m1499k(parcel, a);
                    break;
                case 8:
                    str = C0675a.m1499k(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ce(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public ce[] m1672a(int i) {
        return new ce[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1671a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1672a(i);
    }
}
