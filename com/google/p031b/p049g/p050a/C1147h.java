package com.google.p031b.p049g.p050a;

import com.google.p031b.C1178o;

final class C1147h extends C1146g {
    private final boolean f2480a;

    C1147h(C1140c c1140c, boolean z) {
        super(c1140c);
        this.f2480a = z;
    }

    private void m4268a(C1141d[] c1141dArr, C1138a c1138a) {
        for (int i = 0; i < c1141dArr.length; i++) {
            C1141d c1141d = c1141dArr[i];
            if (c1141dArr[i] != null) {
                int g = c1141d.m4236g() % 30;
                int h = c1141d.m4237h();
                if (h <= c1138a.m4211c()) {
                    if (!this.f2480a) {
                        h += 2;
                    }
                    switch (h % 3) {
                        case 0:
                            if ((g * 3) + 1 == c1138a.m4212d()) {
                                break;
                            }
                            c1141dArr[i] = null;
                            break;
                        case 1:
                            if (g / 3 != c1138a.m4210b() || g % 3 != c1138a.m4213e()) {
                                c1141dArr[i] = null;
                                break;
                            }
                            break;
                            break;
                        case 2:
                            if (g + 1 == c1138a.m4209a()) {
                                break;
                            }
                            c1141dArr[i] = null;
                            break;
                        default:
                            break;
                    }
                }
                c1141dArr[i] = null;
            }
        }
    }

    int m4269a(C1138a c1138a) {
        C1141d[] b = m4266b();
        m4271c();
        m4268a(b, c1138a);
        C1140c a = m4262a();
        C1178o e = this.f2480a ? a.m4224e() : a.m4225f();
        C1178o g = this.f2480a ? a.m4226g() : a.m4227h();
        int b2 = m4265b((int) e.m4397b());
        int b3 = m4265b((int) g.m4397b());
        float c = ((float) (b3 - b2)) / ((float) c1138a.m4211c());
        int i = -1;
        int i2 = b2;
        int i3 = 0;
        int i4 = 1;
        while (i2 < b3) {
            if (b[i2] == null) {
                b2 = i3;
                i3 = i4;
                i4 = i;
            } else {
                C1141d c1141d = b[i2];
                b2 = c1141d.m4237h() - i;
                if (b2 == 0) {
                    b2 = i3 + 1;
                    i3 = i4;
                    i4 = i;
                } else if (b2 == 1) {
                    b2 = Math.max(i4, i3);
                    i4 = c1141d.m4237h();
                    i3 = b2;
                    b2 = 1;
                } else if (b2 < 0 || c1141d.m4237h() >= c1138a.m4211c() || b2 > i2) {
                    b[i2] = null;
                    b2 = i3;
                    i3 = i4;
                    i4 = i;
                } else {
                    int i5 = i4 > 2 ? b2 * (i4 - 2) : b2;
                    Object obj = i5 >= i2 ? 1 : null;
                    for (int i6 = 1; i6 <= i5 && obj == null; i6++) {
                        obj = b[i2 - i6] != null ? 1 : null;
                    }
                    if (obj != null) {
                        b[i2] = null;
                        b2 = i3;
                        i3 = i4;
                        i4 = i;
                    } else {
                        i3 = i4;
                        i4 = c1141d.m4237h();
                        b2 = 1;
                    }
                }
            }
            i2++;
            i = i4;
            i4 = i3;
            i3 = b2;
        }
        return (int) (((double) c) + 0.5d);
    }

    int m4270b(C1138a c1138a) {
        C1140c a = m4262a();
        C1178o e = this.f2480a ? a.m4224e() : a.m4225f();
        C1178o g = this.f2480a ? a.m4226g() : a.m4227h();
        int b = m4265b((int) e.m4397b());
        int b2 = m4265b((int) g.m4397b());
        float c = ((float) (b2 - b)) / ((float) c1138a.m4211c());
        C1141d[] b3 = m4266b();
        int i = -1;
        b = 0;
        int i2 = 1;
        for (int i3 = b; i3 < b2; i3++) {
            if (b3[i3] != null) {
                C1141d c1141d = b3[i3];
                c1141d.m4230b();
                int h = c1141d.m4237h() - i;
                if (h == 0) {
                    b++;
                } else if (h == 1) {
                    b = Math.max(i2, b);
                    i = c1141d.m4237h();
                    i2 = b;
                    b = 1;
                } else if (c1141d.m4237h() >= c1138a.m4211c()) {
                    b3[i3] = null;
                } else {
                    i = c1141d.m4237h();
                    b = 1;
                }
            }
        }
        return (int) (((double) c) + 0.5d);
    }

    void m4271c() {
        for (C1141d c1141d : m4266b()) {
            if (c1141d != null) {
                c1141d.m4230b();
            }
        }
    }

    int[] m4272d() {
        C1138a e = m4273e();
        if (e == null) {
            return null;
        }
        m4270b(e);
        int[] iArr = new int[e.m4211c()];
        for (C1141d c1141d : m4266b()) {
            if (c1141d != null) {
                int h = c1141d.m4237h();
                iArr[h] = iArr[h] + 1;
            }
        }
        return iArr;
    }

    C1138a m4273e() {
        C1141d[] b = m4266b();
        C1139b c1139b = new C1139b();
        C1139b c1139b2 = new C1139b();
        C1139b c1139b3 = new C1139b();
        C1139b c1139b4 = new C1139b();
        for (C1141d c1141d : b) {
            if (c1141d != null) {
                c1141d.m4230b();
                int g = c1141d.m4236g() % 30;
                int h = c1141d.m4237h();
                if (!this.f2480a) {
                    h += 2;
                }
                switch (h % 3) {
                    case 0:
                        c1139b2.m4214a((g * 3) + 1);
                        break;
                    case 1:
                        c1139b4.m4214a(g / 3);
                        c1139b3.m4214a(g % 3);
                        break;
                    case 2:
                        c1139b.m4214a(g + 1);
                        break;
                    default:
                        break;
                }
            }
        }
        if (c1139b.m4215a().length == 0 || c1139b2.m4215a().length == 0 || c1139b3.m4215a().length == 0 || c1139b4.m4215a().length == 0 || c1139b.m4215a()[0] < 1 || c1139b2.m4215a()[0] + c1139b3.m4215a()[0] < 3 || c1139b2.m4215a()[0] + c1139b3.m4215a()[0] > 90) {
            return null;
        }
        C1138a c1138a = new C1138a(c1139b.m4215a()[0], c1139b2.m4215a()[0], c1139b3.m4215a()[0], c1139b4.m4215a()[0]);
        m4268a(b, c1138a);
        return c1138a;
    }

    boolean m4274f() {
        return this.f2480a;
    }

    public String toString() {
        return "IsLeft: " + this.f2480a + '\n' + super.toString();
    }
}
