package com.google.p031b.p053h.p054a;

import com.facebook.widget.PlacePickerFragment;
import com.google.p031b.C1084e;
import com.google.p031b.C1155g;
import com.google.p031b.p034c.C1053c;
import com.google.p031b.p034c.C1054d;
import com.google.p031b.p034c.C1055e;
import com.google.p031b.p034c.C1061l;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class C1168d {
    private static final char[] f2504a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', '+', '-', '.', '/', ':'};

    private static char m4351a(int i) {
        if (i < f2504a.length) {
            return f2504a[i];
        }
        throw C1155g.m4329a();
    }

    private static int m4352a(C1053c c1053c) {
        int a = c1053c.m3858a(8);
        if ((a & 128) == 0) {
            return a & 127;
        }
        if ((a & 192) == 128) {
            return ((a & 63) << 8) | c1053c.m3858a(8);
        } else if ((a & 224) == 192) {
            return ((a & 31) << 16) | c1053c.m3858a(16);
        } else {
            throw C1155g.m4329a();
        }
    }

    static C1055e m4353a(byte[] bArr, C1176j c1176j, C1170f c1170f, Map<C1084e, ?> map) {
        C1053c c1053c = new C1053c(bArr);
        StringBuilder stringBuilder = new StringBuilder(50);
        List arrayList = new ArrayList(1);
        boolean z = false;
        C1054d c1054d = null;
        while (true) {
            C1172h c1172h;
            boolean z2;
            if (c1053c.m3860c() < 4) {
                c1172h = C1172h.TERMINATOR;
            } else {
                try {
                    c1172h = C1172h.m4369a(c1053c.m3858a(4));
                } catch (IllegalArgumentException e) {
                    throw C1155g.m4329a();
                }
            }
            if (c1172h == C1172h.TERMINATOR) {
                z2 = z;
            } else if (c1172h == C1172h.FNC1_FIRST_POSITION || c1172h == C1172h.FNC1_SECOND_POSITION) {
                z2 = true;
            } else if (c1172h == C1172h.STRUCTURED_APPEND) {
                if (c1053c.m3860c() < 16) {
                    throw C1155g.m4329a();
                }
                c1053c.m3858a(16);
                z2 = z;
            } else if (c1172h == C1172h.ECI) {
                c1054d = C1054d.m3861a(C1168d.m4352a(c1053c));
                if (c1054d == null) {
                    throw C1155g.m4329a();
                }
                z2 = z;
            } else if (c1172h == C1172h.HANZI) {
                r2 = c1053c.m3858a(4);
                int a = c1053c.m3858a(c1172h.m4371a(c1176j));
                if (r2 == 1) {
                    C1168d.m4354a(c1053c, stringBuilder, a);
                }
                z2 = z;
            } else {
                r2 = c1053c.m3858a(c1172h.m4371a(c1176j));
                if (c1172h == C1172h.NUMERIC) {
                    C1168d.m4358c(c1053c, stringBuilder, r2);
                    z2 = z;
                } else if (c1172h == C1172h.ALPHANUMERIC) {
                    C1168d.m4356a(c1053c, stringBuilder, r2, z);
                    z2 = z;
                } else if (c1172h == C1172h.BYTE) {
                    C1168d.m4355a(c1053c, stringBuilder, r2, c1054d, arrayList, map);
                    z2 = z;
                } else if (c1172h == C1172h.KANJI) {
                    C1168d.m4357b(c1053c, stringBuilder, r2);
                    z2 = z;
                } else {
                    throw C1155g.m4329a();
                }
            }
            if (c1172h == C1172h.TERMINATOR) {
                break;
            }
            z = z2;
        }
        String stringBuilder2 = stringBuilder.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new C1055e(bArr, stringBuilder2, arrayList, c1170f == null ? null : c1170f.toString());
    }

    private static void m4354a(C1053c c1053c, StringBuilder stringBuilder, int i) {
        if (i * 13 > c1053c.m3860c()) {
            throw C1155g.m4329a();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int a = c1053c.m3858a(13);
            a = (a % 96) | ((a / 96) << 8);
            a = a < 959 ? a + 41377 : a + 42657;
            bArr[i2] = (byte) ((a >> 8) & 255);
            bArr[i2 + 1] = (byte) (a & 255);
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException e) {
            throw C1155g.m4329a();
        }
    }

    private static void m4355a(C1053c c1053c, StringBuilder stringBuilder, int i, C1054d c1054d, Collection<byte[]> collection, Map<C1084e, ?> map) {
        if ((i << 3) > c1053c.m3860c()) {
            throw C1155g.m4329a();
        }
        Object obj = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            obj[i2] = (byte) c1053c.m3858a(8);
        }
        try {
            stringBuilder.append(new String(obj, c1054d == null ? C1061l.m3895a(obj, map) : c1054d.name()));
            collection.add(obj);
        } catch (UnsupportedEncodingException e) {
            throw C1155g.m4329a();
        }
    }

    private static void m4356a(C1053c c1053c, StringBuilder stringBuilder, int i, boolean z) {
        int length = stringBuilder.length();
        while (i > 1) {
            if (c1053c.m3860c() < 11) {
                throw C1155g.m4329a();
            }
            int a = c1053c.m3858a(11);
            stringBuilder.append(C1168d.m4351a(a / 45));
            stringBuilder.append(C1168d.m4351a(a % 45));
            i -= 2;
        }
        if (i == 1) {
            if (c1053c.m3860c() < 6) {
                throw C1155g.m4329a();
            }
            stringBuilder.append(C1168d.m4351a(c1053c.m3858a(6)));
        }
        if (z) {
            while (length < stringBuilder.length()) {
                if (stringBuilder.charAt(length) == '%') {
                    if (length >= stringBuilder.length() - 1 || stringBuilder.charAt(length + 1) != '%') {
                        stringBuilder.setCharAt(length, '\u001d');
                    } else {
                        stringBuilder.deleteCharAt(length + 1);
                    }
                }
                length++;
            }
        }
    }

    private static void m4357b(C1053c c1053c, StringBuilder stringBuilder, int i) {
        if (i * 13 > c1053c.m3860c()) {
            throw C1155g.m4329a();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int a = c1053c.m3858a(13);
            a = (a % 192) | ((a / 192) << 8);
            a = a < 7936 ? a + 33088 : a + 49472;
            bArr[i2] = (byte) (a >> 8);
            bArr[i2 + 1] = (byte) a;
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException e) {
            throw C1155g.m4329a();
        }
    }

    private static void m4358c(C1053c c1053c, StringBuilder stringBuilder, int i) {
        while (i >= 3) {
            if (c1053c.m3860c() < 10) {
                throw C1155g.m4329a();
            }
            int a = c1053c.m3858a(10);
            if (a >= PlacePickerFragment.DEFAULT_RADIUS_IN_METERS) {
                throw C1155g.m4329a();
            }
            stringBuilder.append(C1168d.m4351a(a / 100));
            stringBuilder.append(C1168d.m4351a((a / 10) % 10));
            stringBuilder.append(C1168d.m4351a(a % 10));
            i -= 3;
        }
        if (i == 2) {
            if (c1053c.m3860c() < 7) {
                throw C1155g.m4329a();
            }
            a = c1053c.m3858a(7);
            if (a >= 100) {
                throw C1155g.m4329a();
            }
            stringBuilder.append(C1168d.m4351a(a / 10));
            stringBuilder.append(C1168d.m4351a(a % 10));
        } else if (i != 1) {
        } else {
            if (c1053c.m3860c() < 4) {
                throw C1155g.m4329a();
            }
            a = c1053c.m3858a(4);
            if (a >= 10) {
                throw C1155g.m4329a();
            }
            stringBuilder.append(C1168d.m4351a(a));
        }
    }
}
