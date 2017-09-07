package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class jm implements SafeParcelable {
    public static final ey CREATOR = new ey();
    final int f1659a;
    final List<js> f1660b;
    final List<jw> f1661c;
    final List<String> f1662d;
    private final String f1663e;
    private final boolean f1664f;
    private final String f1665g;
    private final Set<js> f1666h;
    private final Set<jw> f1667i;
    private final Set<String> f1668j;

    jm(int i, List<js> list, String str, boolean z, List<jw> list2, String str2, List<String> list3) {
        this.f1659a = i;
        this.f1660b = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        if (str == null) {
            str = "";
        }
        this.f1663e = str;
        this.f1664f = z;
        this.f1661c = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        if (str2 == null) {
            str2 = "";
        }
        this.f1665g = str2;
        this.f1662d = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.f1666h = m2690a(this.f1660b);
        this.f1667i = m2690a(this.f1661c);
        this.f1668j = m2690a(this.f1662d);
    }

    private static <E> Set<E> m2690a(List<E> list) {
        return list.isEmpty() ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(list));
    }

    @Deprecated
    public String m2691a() {
        return this.f1663e;
    }

    public boolean m2692b() {
        return this.f1664f;
    }

    public String m2693c() {
        return this.f1665g;
    }

    public int describeContents() {
        ey eyVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jm)) {
            return false;
        }
        jm jmVar = (jm) obj;
        return this.f1666h.equals(jmVar.f1666h) && this.f1664f == jmVar.f1664f && this.f1665g.equals(jmVar.f1665g) && this.f1667i.equals(jmVar.f1667i) && this.f1668j.equals(jmVar.f1668j);
    }

    public int hashCode() {
        return ej.m2329a(this.f1666h, Boolean.valueOf(this.f1664f), this.f1667i, this.f1665g, this.f1668j);
    }

    public String toString() {
        return ej.m2330a((Object) this).m2328a("types", this.f1666h).m2328a("placeIds", this.f1668j).m2328a("requireOpenNow", Boolean.valueOf(this.f1664f)).m2328a("userAccountName", this.f1665g).m2328a("requestedUserDataTypes", this.f1667i).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ey eyVar = CREATOR;
        ey.m2466a(this, parcel, i);
    }
}
