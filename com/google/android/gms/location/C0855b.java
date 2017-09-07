package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ej;

public class C0855b implements SafeParcelable {
    public static final C0858e CREATOR = new C0858e();
    int f1821a;
    int f1822b;
    long f1823c;
    private final int f1824d;

    C0855b(int i, int i2, int i3, long j) {
        this.f1824d = i;
        this.f1821a = i2;
        this.f1822b = i3;
        this.f1823c = j;
    }

    private String m2811a(int i) {
        switch (i) {
            case 0:
                return "STATUS_SUCCESSFUL";
            case 2:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case 3:
                return "STATUS_NO_INFO_IN_DATABASE";
            case 4:
                return "STATUS_INVALID_SCAN";
            case 5:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case 6:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case 7:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case 8:
                return "STATUS_IN_PROGRESS";
            default:
                return "STATUS_UNKNOWN";
        }
    }

    int m2812a() {
        return this.f1824d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0855b)) {
            return false;
        }
        C0855b c0855b = (C0855b) obj;
        return this.f1821a == c0855b.f1821a && this.f1822b == c0855b.f1822b && this.f1823c == c0855b.f1823c;
    }

    public int hashCode() {
        return ej.m2329a(Integer.valueOf(this.f1821a), Integer.valueOf(this.f1822b), Long.valueOf(this.f1823c));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocationStatus[cell status: ").append(m2811a(this.f1821a));
        stringBuilder.append(", wifi status: ").append(m2811a(this.f1822b));
        stringBuilder.append(", elapsed realtime ns: ").append(this.f1823c);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0858e.m2817a(this, parcel, i);
    }
}
