package com.google.p031b.p045f.p046a.p047a.p048a;

import com.google.p031b.C1155g;
import com.google.p031b.p034c.C1046a;

final class C1104s {
    private final C1046a f2331a;
    private final C1098m f2332b = new C1098m();
    private final StringBuilder f2333c = new StringBuilder();

    C1104s(C1046a c1046a) {
        this.f2331a = c1046a;
    }

    static int m4017a(C1046a c1046a, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (c1046a.m3807a(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    private C1101o m4018a() {
        C1096l d;
        boolean b;
        do {
            int a = this.f2332b.m3996a();
            if (this.f2332b.m3999b()) {
                d = m4024d();
                b = d.m3995b();
            } else if (this.f2332b.m4000c()) {
                d = m4022c();
                b = d.m3995b();
            } else {
                d = m4020b();
                b = d.m3995b();
            }
            if ((a != this.f2332b.m3996a() ? 1 : null) == null && !b) {
                break;
            }
        } while (!b);
        return d.m3994a();
    }

    private boolean m4019a(int i) {
        if (i + 7 > this.f2331a.m3802a()) {
            return i + 4 <= this.f2331a.m3802a();
        } else {
            for (int i2 = i; i2 < i + 3; i2++) {
                if (this.f2331a.m3807a(i2)) {
                    return true;
                }
            }
            return this.f2331a.m3807a(i + 3);
        }
    }

    private C1096l m4020b() {
        while (m4019a(this.f2332b.m3996a())) {
            C1102p b = m4021b(this.f2332b.m3996a());
            this.f2332b.m3997a(b.m4004e());
            if (b.m4012c()) {
                return new C1096l(b.m4013d() ? new C1101o(this.f2332b.m3996a(), this.f2333c.toString()) : new C1101o(this.f2332b.m3996a(), this.f2333c.toString(), b.m4011b()), true);
            }
            this.f2333c.append(b.m4010a());
            if (b.m4013d()) {
                return new C1096l(new C1101o(this.f2332b.m3996a(), this.f2333c.toString()), true);
            }
            this.f2333c.append(b.m4011b());
        }
        if (m4030i(this.f2332b.m3996a())) {
            this.f2332b.m4002e();
            this.f2332b.m3998b(4);
        }
        return new C1096l(false);
    }

    private C1102p m4021b(int i) {
        if (i + 7 > this.f2331a.m3802a()) {
            int a = m4031a(i, 4);
            return a == 0 ? new C1102p(this.f2331a.m3802a(), 10, 10) : new C1102p(this.f2331a.m3802a(), a - 1, 10);
        } else {
            int a2 = m4031a(i, 7);
            return new C1102p(i + 7, (a2 - 8) / 11, (a2 - 8) % 11);
        }
    }

    private C1096l m4022c() {
        while (m4023c(this.f2332b.m3996a())) {
            C1100n d = m4025d(this.f2332b.m3996a());
            this.f2332b.m3997a(d.m4004e());
            if (d.m4006b()) {
                return new C1096l(new C1101o(this.f2332b.m3996a(), this.f2333c.toString()), true);
            }
            this.f2333c.append(d.m4005a());
        }
        if (m4029h(this.f2332b.m3996a())) {
            this.f2332b.m3998b(3);
            this.f2332b.m4001d();
        } else if (m4028g(this.f2332b.m3996a())) {
            if (this.f2332b.m3996a() + 5 < this.f2331a.m3802a()) {
                this.f2332b.m3998b(5);
            } else {
                this.f2332b.m3997a(this.f2331a.m3802a());
            }
            this.f2332b.m4002e();
        }
        return new C1096l(false);
    }

    private boolean m4023c(int i) {
        boolean z = true;
        if (i + 5 > this.f2331a.m3802a()) {
            return false;
        }
        int a = m4031a(i, 5);
        if (a >= 5 && a < 16) {
            return true;
        }
        if (i + 7 > this.f2331a.m3802a()) {
            return false;
        }
        a = m4031a(i, 7);
        if (a >= 64 && a < 116) {
            return true;
        }
        if (i + 8 > this.f2331a.m3802a()) {
            return false;
        }
        a = m4031a(i, 8);
        if (a < 232 || a >= 253) {
            z = false;
        }
        return z;
    }

    private C1096l m4024d() {
        while (m4026e(this.f2332b.m3996a())) {
            C1100n f = m4027f(this.f2332b.m3996a());
            this.f2332b.m3997a(f.m4004e());
            if (f.m4006b()) {
                return new C1096l(new C1101o(this.f2332b.m3996a(), this.f2333c.toString()), true);
            }
            this.f2333c.append(f.m4005a());
        }
        if (m4029h(this.f2332b.m3996a())) {
            this.f2332b.m3998b(3);
            this.f2332b.m4001d();
        } else if (m4028g(this.f2332b.m3996a())) {
            if (this.f2332b.m3996a() + 5 < this.f2331a.m3802a()) {
                this.f2332b.m3998b(5);
            } else {
                this.f2332b.m3997a(this.f2331a.m3802a());
            }
            this.f2332b.m4003f();
        }
        return new C1096l(false);
    }

    private C1100n m4025d(int i) {
        int a = m4031a(i, 5);
        if (a == 15) {
            return new C1100n(i + 5, '$');
        }
        if (a >= 5 && a < 15) {
            return new C1100n(i + 5, (char) ((a + 48) - 5));
        }
        a = m4031a(i, 7);
        if (a >= 64 && a < 90) {
            return new C1100n(i + 7, (char) (a + 1));
        }
        if (a >= 90 && a < 116) {
            return new C1100n(i + 7, (char) (a + 7));
        }
        char c;
        switch (m4031a(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = '\"';
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = '&';
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = '(';
                break;
            case 238:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case 240:
                c = '+';
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = '/';
                break;
            case 245:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = '<';
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case 250:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw C1155g.m4329a();
        }
        return new C1100n(i + 8, c);
    }

    private boolean m4026e(int i) {
        boolean z = true;
        if (i + 5 > this.f2331a.m3802a()) {
            return false;
        }
        int a = m4031a(i, 5);
        if (a >= 5 && a < 16) {
            return true;
        }
        if (i + 6 > this.f2331a.m3802a()) {
            return false;
        }
        a = m4031a(i, 6);
        if (a < 16 || a >= 63) {
            z = false;
        }
        return z;
    }

    private C1100n m4027f(int i) {
        int a = m4031a(i, 5);
        if (a == 15) {
            return new C1100n(i + 5, '$');
        }
        if (a >= 5 && a < 15) {
            return new C1100n(i + 5, (char) ((a + 48) - 5));
        }
        a = m4031a(i, 6);
        if (a >= 32 && a < 58) {
            return new C1100n(i + 6, (char) (a + 33));
        }
        char c;
        switch (a) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + a);
        }
        return new C1100n(i + 6, c);
    }

    private boolean m4028g(int i) {
        if (i + 1 > this.f2331a.m3802a()) {
            return false;
        }
        int i2 = 0;
        while (i2 < 5 && i2 + i < this.f2331a.m3802a()) {
            if (i2 == 2) {
                if (!this.f2331a.m3807a(i + 2)) {
                    return false;
                }
            } else if (this.f2331a.m3807a(i + i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private boolean m4029h(int i) {
        if (i + 3 > this.f2331a.m3802a()) {
            return false;
        }
        for (int i2 = i; i2 < i + 3; i2++) {
            if (this.f2331a.m3807a(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean m4030i(int i) {
        if (i + 1 > this.f2331a.m3802a()) {
            return false;
        }
        int i2 = 0;
        while (i2 < 4 && i2 + i < this.f2331a.m3802a()) {
            if (this.f2331a.m3807a(i + i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    int m4031a(int i, int i2) {
        return C1104s.m4017a(this.f2331a, i, i2);
    }

    C1101o m4032a(int i, String str) {
        this.f2333c.setLength(0);
        if (str != null) {
            this.f2333c.append(str);
        }
        this.f2332b.m3997a(i);
        C1101o a = m4018a();
        return (a == null || !a.m4008b()) ? new C1101o(this.f2332b.m3996a(), this.f2333c.toString()) : new C1101o(this.f2332b.m3996a(), this.f2333c.toString(), a.m4009c());
    }

    String m4033a(StringBuilder stringBuilder, int i) {
        String str = null;
        while (true) {
            C1101o a = m4032a(i, str);
            str = C1103r.m4015a(a.m4007a());
            if (str != null) {
                stringBuilder.append(str);
            }
            str = a.m4008b() ? String.valueOf(a.m4009c()) : null;
            if (i == a.m4004e()) {
                return stringBuilder.toString();
            }
            i = a.m4004e();
        }
    }
}
