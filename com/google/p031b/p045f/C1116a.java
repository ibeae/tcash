package com.google.p031b.p045f;

import android.support.v4.app.NotificationCompat;
import com.google.p031b.C1016a;
import com.google.p031b.C1084e;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.p034c.C1046a;
import java.util.Arrays;
import java.util.Map;

public final class C1116a extends C1108l {
    static final char[] f2373a = "0123456789-$:/.+ABCD".toCharArray();
    static final int[] f2374b = new int[]{3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] f2375c = new char[]{'A', 'B', 'C', 'D'};
    private final StringBuilder f2376d = new StringBuilder(20);
    private int[] f2377e = new int[80];
    private int f2378f = 0;

    private void m4101a(C1046a c1046a) {
        this.f2378f = 0;
        int d = c1046a.m3815d(0);
        int a = c1046a.m3802a();
        if (d >= a) {
            throw C1198j.m4509a();
        }
        int i = 1;
        d = 0;
        for (int i2 = d; i2 < a; i2++) {
            if ((c1046a.m3807a(i2) ^ i) != 0) {
                d++;
            } else {
                m4104b(d);
                i = i == 0 ? 1 : 0;
                d = 1;
            }
        }
        m4104b(d);
    }

    static boolean m4102a(char[] cArr, char c) {
        if (cArr == null) {
            return false;
        }
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    private int m4103b() {
        int i = 1;
        while (i < this.f2378f) {
            int c = m4105c(i);
            if (c != -1 && C1116a.m4102a(f2375c, f2373a[c])) {
                int i2 = 0;
                for (c = i; c < i + 7; c++) {
                    i2 += this.f2377e[c];
                }
                if (i == 1 || this.f2377e[i - 1] >= i2 / 2) {
                    return i;
                }
            }
            i += 2;
        }
        throw C1198j.m4509a();
    }

    private void m4104b(int i) {
        this.f2377e[this.f2378f] = i;
        this.f2378f++;
        if (this.f2378f >= this.f2377e.length) {
            Object obj = new int[(this.f2378f * 2)];
            System.arraycopy(this.f2377e, 0, obj, 0, this.f2378f);
            this.f2377e = obj;
        }
    }

    private int m4105c(int i) {
        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = i + 7;
        if (i3 >= this.f2378f) {
            return -1;
        }
        int[] iArr = this.f2377e;
        int i4 = i;
        int i5 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i6 = 0;
        while (i4 < i3) {
            int i7 = iArr[i4];
            if (i7 < i5) {
                i5 = i7;
            }
            if (i7 <= i6) {
                i7 = i6;
            }
            i4 += 2;
            i6 = i7;
        }
        i5 = (i5 + i6) / 2;
        i4 = i + 1;
        i6 = 0;
        while (i4 < i3) {
            i7 = iArr[i4];
            if (i7 < i2) {
                i2 = i7;
            }
            if (i7 <= i6) {
                i7 = i6;
            }
            i4 += 2;
            i6 = i7;
        }
        i6 = (i2 + i6) / 2;
        i4 = 0;
        i2 = 0;
        i3 = 128;
        while (i4 < 7) {
            i3 >>= 1;
            i7 = iArr[i + i4] > ((i4 & 1) == 0 ? i5 : i6) ? i2 | i3 : i2;
            i4++;
            i2 = i7;
        }
        for (i7 = 0; i7 < f2374b.length; i7++) {
            if (f2374b[i7] == i2) {
                return i7;
            }
        }
        return -1;
    }

    public C1199m mo1426a(int i, C1046a c1046a, Map<C1084e, ?> map) {
        Arrays.fill(this.f2377e, 0);
        m4101a(c1046a);
        int b = m4103b();
        this.f2376d.setLength(0);
        int i2 = b;
        do {
            int c = m4105c(i2);
            if (c != -1) {
                this.f2376d.append((char) c);
                i2 += 8;
                if (this.f2376d.length() > 1 && C1116a.m4102a(f2375c, f2373a[c])) {
                    break;
                }
            } else {
                throw C1198j.m4509a();
            }
        } while (i2 < this.f2378f);
        int i3 = this.f2377e[i2 - 1];
        int i4 = 0;
        for (c = -8; c < -1; c++) {
            i4 += this.f2377e[i2 + c];
        }
        if (i2 >= this.f2378f || i3 >= i4 / 2) {
            m4107a(b);
            for (c = 0; c < this.f2376d.length(); c++) {
                this.f2376d.setCharAt(c, f2373a[this.f2376d.charAt(c)]);
            }
            if (C1116a.m4102a(f2375c, this.f2376d.charAt(0))) {
                if (!C1116a.m4102a(f2375c, this.f2376d.charAt(this.f2376d.length() - 1))) {
                    throw C1198j.m4509a();
                } else if (this.f2376d.length() <= 3) {
                    throw C1198j.m4509a();
                } else {
                    if (map == null || !map.containsKey(C1084e.RETURN_CODABAR_START_END)) {
                        this.f2376d.deleteCharAt(this.f2376d.length() - 1);
                        this.f2376d.deleteCharAt(0);
                    }
                    i4 = 0;
                    c = 0;
                    while (i4 < b) {
                        i3 = this.f2377e[i4] + c;
                        i4++;
                        c = i3;
                    }
                    float f = (float) c;
                    while (b < i2 - 1) {
                        c += this.f2377e[b];
                        b++;
                    }
                    float f2 = (float) c;
                    return new C1199m(this.f2376d.toString(), null, new C1178o[]{new C1178o(f, (float) i), new C1178o(f2, (float) i)}, C1016a.CODABAR);
                }
            }
            throw C1198j.m4509a();
        }
        throw C1198j.m4509a();
    }

    void m4107a(int i) {
        int i2 = 0;
        int[] iArr = new int[]{0, 0, 0, 0};
        int[] iArr2 = new int[]{0, 0, 0, 0};
        int length = this.f2376d.length() - 1;
        int i3 = 0;
        int i4 = i;
        while (true) {
            int i5 = f2374b[this.f2376d.charAt(i3)];
            for (int i6 = 6; i6 >= 0; i6--) {
                int i7 = (i6 & 1) + ((i5 & 1) * 2);
                iArr[i7] = iArr[i7] + this.f2377e[i4 + i6];
                iArr2[i7] = iArr2[i7] + 1;
                i5 >>= 1;
            }
            if (i3 >= length) {
                break;
            }
            i4 += 8;
            i3++;
        }
        int[] iArr3 = new int[4];
        int[] iArr4 = new int[4];
        for (i3 = 0; i3 < 2; i3++) {
            iArr4[i3] = 0;
            iArr4[i3 + 2] = (((iArr[i3] << 8) / iArr2[i3]) + ((iArr[i3 + 2] << 8) / iArr2[i3 + 2])) >> 1;
            iArr3[i3] = iArr4[i3 + 2];
            iArr3[i3 + 2] = ((iArr[i3 + 2] * NotificationCompat.FLAG_GROUP_SUMMARY) + 384) / iArr2[i3 + 2];
        }
        loop3:
        while (true) {
            i4 = f2374b[this.f2376d.charAt(i2)];
            i3 = 6;
            while (i3 >= 0) {
                int i8 = (i3 & 1) + ((i4 & 1) * 2);
                int i9 = this.f2377e[i + i3] << 8;
                if (i9 >= iArr4[i8] && i9 <= iArr3[i8]) {
                    i4 >>= 1;
                    i3--;
                }
            }
            if (i2 < length) {
                i += 8;
                i2++;
            } else {
                return;
            }
        }
        throw C1198j.m4509a();
    }
}
