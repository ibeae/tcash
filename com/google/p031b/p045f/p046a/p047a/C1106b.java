package com.google.p031b.p045f.p046a.p047a;

import com.google.p031b.p045f.p046a.C1111b;
import com.google.p031b.p045f.p046a.C1112c;

final class C1106b {
    private final boolean f2334a;
    private final C1111b f2335b;
    private final C1111b f2336c;
    private final C1112c f2337d;

    C1106b(C1111b c1111b, C1111b c1111b2, C1112c c1112c, boolean z) {
        this.f2335b = c1111b;
        this.f2336c = c1111b2;
        this.f2337d = c1112c;
        this.f2334a = z;
    }

    private static int m4035a(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }

    private static boolean m4036a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    C1111b m4037a() {
        return this.f2335b;
    }

    C1111b m4038b() {
        return this.f2336c;
    }

    C1112c m4039c() {
        return this.f2337d;
    }

    public boolean m4040d() {
        return this.f2336c == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1106b)) {
            return false;
        }
        C1106b c1106b = (C1106b) obj;
        return C1106b.m4036a(this.f2335b, c1106b.f2335b) && C1106b.m4036a(this.f2336c, c1106b.f2336c) && C1106b.m4036a(this.f2337d, c1106b.f2337d);
    }

    public int hashCode() {
        return (C1106b.m4035a(this.f2335b) ^ C1106b.m4035a(this.f2336c)) ^ C1106b.m4035a(this.f2337d);
    }

    public String toString() {
        return "[ " + this.f2335b + " , " + this.f2336c + " : " + (this.f2337d == null ? "null" : Integer.valueOf(this.f2337d.m4083a())) + " ]";
    }
}
