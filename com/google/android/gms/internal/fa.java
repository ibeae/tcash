package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.widget.PlacePickerFragment;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class fa implements Creator<jq> {
    static void m2480a(jq jqVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1510a(parcel, (int) PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, jqVar.f1673b);
        C0676b.m1514a(parcel, 2, jqVar.m2696a(), i, false);
        C0676b.m1511a(parcel, 3, jqVar.m2697b());
        C0676b.m1510a(parcel, 4, jqVar.m2698c());
        C0676b.m1506a(parcel, a);
    }

    public jq m2481a(Parcel parcel) {
        int b = C0675a.m1487b(parcel);
        int i = 0;
        jm jmVar = null;
        long j = jq.f1672a;
        int i2 = 102;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 2:
                    jmVar = (jm) C0675a.m1483a(parcel, a, jm.CREATOR);
                    break;
                case 3:
                    j = C0675a.m1496h(parcel, a);
                    break;
                case 4:
                    i2 = C0675a.m1494f(parcel, a);
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
            return new jq(i, jmVar, j, i2);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public jq[] m2482a(int i) {
        return new jq[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2481a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2482a(i);
    }
}
