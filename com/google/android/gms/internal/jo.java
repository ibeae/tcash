package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jo implements SafeParcelable {
    public static final ez CREATOR = new ez();
    final int f1669a;
    private final String f1670b;
    private final String f1671c;

    jo(int i, String str, String str2) {
        this.f1669a = i;
        this.f1670b = str;
        this.f1671c = str2;
    }

    public String m2694a() {
        return this.f1670b;
    }

    public String m2695b() {
        return this.f1671c;
    }

    public int describeContents() {
        ez ezVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof jo)) {
            return false;
        }
        jo joVar = (jo) obj;
        return ej.m2331a(this.f1670b, joVar.f1670b) && ej.m2331a(this.f1671c, joVar.f1671c);
    }

    public int hashCode() {
        return ej.m2329a(this.f1670b, this.f1671c);
    }

    public String toString() {
        return ej.m2330a((Object) this).m2328a("mPlaceId", this.f1670b).m2328a("mTag", this.f1671c).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ez ezVar = CREATOR;
        ez.m2469a(this, parcel, i);
    }
}
