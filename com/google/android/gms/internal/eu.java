package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.widget.PlacePickerFragment;
import com.google.android.gms.common.internal.safeparcel.C0675a;
import com.google.android.gms.common.internal.safeparcel.C0675a.C0674a;
import com.google.android.gms.common.internal.safeparcel.C0676b;

public class eu implements Creator<jh> {
    static void m2460a(jh jhVar, Parcel parcel, int i) {
        int a = C0676b.m1505a(parcel);
        C0676b.m1516a(parcel, 1, jhVar.m2681f(), false);
        C0676b.m1510a(parcel, (int) PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, jhVar.m2676a());
        C0676b.m1511a(parcel, 2, jhVar.m2682g());
        C0676b.m1518a(parcel, 3, jhVar.m2677b());
        C0676b.m1508a(parcel, 4, jhVar.m2678c());
        C0676b.m1508a(parcel, 5, jhVar.m2679d());
        C0676b.m1509a(parcel, 6, jhVar.m2680e());
        C0676b.m1510a(parcel, 7, jhVar.m2683h());
        C0676b.m1510a(parcel, 8, jhVar.m2684i());
        C0676b.m1510a(parcel, 9, jhVar.m2685j());
        C0676b.m1506a(parcel, a);
    }

    public jh m2461a(Parcel parcel) {
        int b = C0675a.m1487b(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < b) {
            int a = C0675a.m1481a(parcel);
            switch (C0675a.m1480a(a)) {
                case 1:
                    str = C0675a.m1499k(parcel, a);
                    break;
                case 2:
                    j = C0675a.m1496h(parcel, a);
                    break;
                case 3:
                    s = C0675a.m1493e(parcel, a);
                    break;
                case 4:
                    d = C0675a.m1498j(parcel, a);
                    break;
                case 5:
                    d2 = C0675a.m1498j(parcel, a);
                    break;
                case 6:
                    f = C0675a.m1497i(parcel, a);
                    break;
                case 7:
                    i2 = C0675a.m1494f(parcel, a);
                    break;
                case 8:
                    i3 = C0675a.m1494f(parcel, a);
                    break;
                case 9:
                    i4 = C0675a.m1494f(parcel, a);
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
            return new jh(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new C0674a("Overread allowed size end=" + b, parcel);
    }

    public jh[] m2462a(int i) {
        return new jh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2461a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2462a(i);
    }
}
