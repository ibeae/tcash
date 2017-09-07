package com.google.p031b.p045f.p046a;

import com.google.p031b.C1178o;

public final class C1112c {
    private final int f2359a;
    private final int[] f2360b;
    private final C1178o[] f2361c;

    public C1112c(int i, int[] iArr, int i2, int i3, int i4) {
        this.f2359a = i;
        this.f2360b = iArr;
        this.f2361c = new C1178o[]{new C1178o((float) i2, (float) i4), new C1178o((float) i3, (float) i4)};
    }

    public int m4083a() {
        return this.f2359a;
    }

    public int[] m4084b() {
        return this.f2360b;
    }

    public C1178o[] m4085c() {
        return this.f2361c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1112c)) {
            return false;
        }
        return this.f2359a == ((C1112c) obj).f2359a;
    }

    public int hashCode() {
        return this.f2359a;
    }
}
