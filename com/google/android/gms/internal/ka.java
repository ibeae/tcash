package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class ka implements SafeParcelable {
    public static final fh CREATOR = new fh();
    public final int f1742a;
    public final String f1743b;
    public final String f1744c;

    public ka(int i, String str, String str2) {
        this.f1742a = i;
        this.f1743b = str;
        this.f1744c = str2;
    }

    public ka(String str, Locale locale) {
        this.f1742a = 0;
        this.f1743b = str;
        this.f1744c = locale.toString();
    }

    public int describeContents() {
        fh fhVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ka)) {
            return false;
        }
        ka kaVar = (ka) obj;
        return this.f1744c.equals(kaVar.f1744c) && this.f1743b.equals(kaVar.f1743b);
    }

    public int hashCode() {
        return ej.m2329a(this.f1743b, this.f1744c);
    }

    public String toString() {
        return ej.m2330a((Object) this).m2328a("clientPackageName", this.f1743b).m2328a("locale", this.f1744c).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        fh fhVar = CREATOR;
        fh.m2507a(this, parcel, i);
    }
}
