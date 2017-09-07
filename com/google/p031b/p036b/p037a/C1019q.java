package com.google.p031b.p036b.p037a;

public abstract class C1019q {
    private final C1035r f2052a;

    protected C1019q(C1035r c1035r) {
        this.f2052a = c1035r;
    }

    public static void m3706a(String str, StringBuilder stringBuilder) {
        if (str != null && !str.isEmpty()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append('\n');
            }
            stringBuilder.append(str);
        }
    }

    public static void m3707a(String[] strArr, StringBuilder stringBuilder) {
        if (strArr != null) {
            for (String a : strArr) {
                C1019q.m3706a(a, stringBuilder);
            }
        }
    }

    public abstract String mo1417a();

    public final C1035r m3709b() {
        return this.f2052a;
    }

    public final String toString() {
        return mo1417a();
    }
}
