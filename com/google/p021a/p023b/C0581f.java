package com.google.p021a.p023b;

public final class C0581f<FIRST, SECOND> {
    public final FIRST f619a;
    public final SECOND f620b;

    public C0581f(FIRST first, SECOND second) {
        this.f619a = first;
        this.f620b = second;
    }

    private static boolean m1166a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0581f)) {
            return false;
        }
        C0581f c0581f = (C0581f) obj;
        return C0581f.m1166a(this.f619a, c0581f.f619a) && C0581f.m1166a(this.f620b, c0581f.f620b);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f619a != null ? this.f619a.hashCode() : 0) * 17;
        if (this.f620b != null) {
            i = this.f620b.hashCode();
        }
        return hashCode + (i * 17);
    }

    public String toString() {
        return String.format("{%s,%s}", new Object[]{this.f619a, this.f620b});
    }
}
