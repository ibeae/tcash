package com.google.p031b.p045f.p046a;

public class C1111b {
    private final int f2357a;
    private final int f2358b;

    public C1111b(int i, int i2) {
        this.f2357a = i;
        this.f2358b = i2;
    }

    public final int m4081a() {
        return this.f2357a;
    }

    public final int m4082b() {
        return this.f2358b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1111b)) {
            return false;
        }
        C1111b c1111b = (C1111b) obj;
        return this.f2357a == c1111b.f2357a && this.f2358b == c1111b.f2358b;
    }

    public final int hashCode() {
        return this.f2357a ^ this.f2358b;
    }

    public final String toString() {
        return this.f2357a + "(" + this.f2358b + ')';
    }
}
