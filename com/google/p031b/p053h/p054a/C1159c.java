package com.google.p031b.p053h.p054a;

import com.google.p031b.p034c.C1052b;

abstract class C1159c {
    private static final C1159c[] f2503a = new C1159c[]{new C1160a(), new C1161b(), new C1162c(), new C1163d(), new C1164e(), new C1165f(), new C1166g(), new C1167h()};

    private static final class C1160a extends C1159c {
        private C1160a() {
            super();
        }

        boolean mo1435a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    private static final class C1161b extends C1159c {
        private C1161b() {
            super();
        }

        boolean mo1435a(int i, int i2) {
            return (i & 1) == 0;
        }
    }

    private static final class C1162c extends C1159c {
        private C1162c() {
            super();
        }

        boolean mo1435a(int i, int i2) {
            return i2 % 3 == 0;
        }
    }

    private static final class C1163d extends C1159c {
        private C1163d() {
            super();
        }

        boolean mo1435a(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    }

    private static final class C1164e extends C1159c {
        private C1164e() {
            super();
        }

        boolean mo1435a(int i, int i2) {
            return (((i >>> 1) + (i2 / 3)) & 1) == 0;
        }
    }

    private static final class C1165f extends C1159c {
        private C1165f() {
            super();
        }

        boolean mo1435a(int i, int i2) {
            int i3 = i * i2;
            return (i3 % 3) + (i3 & 1) == 0;
        }
    }

    private static final class C1166g extends C1159c {
        private C1166g() {
            super();
        }

        boolean mo1435a(int i, int i2) {
            int i3 = i * i2;
            return (((i3 % 3) + (i3 & 1)) & 1) == 0;
        }
    }

    private static final class C1167h extends C1159c {
        private C1167h() {
            super();
        }

        boolean mo1435a(int i, int i2) {
            return ((((i + i2) & 1) + ((i * i2) % 3)) & 1) == 0;
        }
    }

    private C1159c() {
    }

    static C1159c m4340a(int i) {
        if (i >= 0 && i <= 7) {
            return f2503a[i];
        }
        throw new IllegalArgumentException();
    }

    final void m4341a(C1052b c1052b, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (mo1435a(i2, i3)) {
                    c1052b.m3853c(i3, i2);
                }
            }
        }
    }

    abstract boolean mo1435a(int i, int i2);
}
