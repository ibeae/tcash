package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.widget.PlacePickerFragment;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;
import java.util.List;

public class ey implements Creator<jm> {
    static void m2466a(jm jmVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1526b(parcel, 1, jmVar.f1660b, false);
        C0676b.m1510a(parcel, (int) PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, jmVar.f1659a);
        C0676b.m1516a(parcel, 2, jmVar.m2691a(), false);
        C0676b.m1519a(parcel, 3, jmVar.m2692b());
        C0676b.m1526b(parcel, 4, jmVar.f1661c, false);
        C0676b.m1516a(parcel, 5, jmVar.m2693c(), false);
        C0676b.m1517a(parcel, 6, jmVar.f1662d, false);
        C0676b.m1506a(parcel, a);
    }

    public jm m2467a(Parcel parcel) {
        boolean z = false;
        List list = null;
        int b = C0675a.m1487b(parcel);
        String str = null;
        List list2 = null;
        String str2 = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    list3 = C0675a.m1490c(parcel, a, js.CREATOR);
                    break;
                case 2:
                    str2 = C0675a.m1499k(parcel, a);
                    break;
                case 3:
                    z = C0675a.m1491c(parcel, a);
                    break;
                case 4:
                    list2 = C0675a.m1490c(parcel, a, jw.CREATOR);
                    break;
                case 5:
                    str = C0675a.m1499k(parcel, a);
                    break;
                case 6:
                    list = C0675a.m1504p(parcel, a);
                    break;
                case PlacePickerFragment.DEFAULT_RADIUS_IN_METERS /*1000*/:
                    i = C0675a.m1494f(parcel, a);
                    break;
                default:
                    C0675a.m1488b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new jm(i, list3, str2, z, list2, str, list);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public jm[] m2468a(int i) {
        return new jm[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2467a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2468a(i);
    }
}
