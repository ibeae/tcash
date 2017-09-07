package com.google.p031b.p034c;

import com.google.p031b.C1084e;
import java.util.Map;

public final class C1061l {
    private static final String f2244a = System.getProperty("file.encoding");
    private static final boolean f2245b;

    static {
        boolean z = "SJIS".equalsIgnoreCase(f2244a) || "EUC_JP".equalsIgnoreCase(f2244a);
        f2245b = z;
    }

    public static String m3895a(byte[] bArr, Map<C1084e, ?> map) {
        if (map != null) {
            String str = (String) map.get(C1084e.CHARACTER_SET);
            if (str != null) {
                return str;
            }
        }
        int length = bArr.length;
        Object obj = 1;
        Object obj2 = 1;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj3 = (bArr.length > 3 && bArr[0] == (byte) -17 && bArr[1] == (byte) -69 && bArr[2] == (byte) -65) ? 1 : null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        Object obj4 = 1;
        while (i10 < length && (obj != null || obj2 != null || obj4 != null)) {
            Object obj5;
            int i13;
            Object obj6;
            int i14;
            int i15;
            int i16 = bArr[i10] & 255;
            if (obj4 != null) {
                if (i > 0) {
                    if ((i16 & 128) == 0) {
                        obj5 = null;
                    } else {
                        i--;
                        obj5 = obj4;
                    }
                } else if ((i16 & 128) != 0) {
                    if ((i16 & 64) == 0) {
                        obj5 = null;
                    } else {
                        i++;
                        if ((i16 & 32) == 0) {
                            i2++;
                            obj5 = obj4;
                        } else {
                            i++;
                            if ((i16 & 16) == 0) {
                                i3++;
                                obj5 = obj4;
                            } else {
                                i++;
                                if ((i16 & 8) == 0) {
                                    i4++;
                                    obj5 = obj4;
                                } else {
                                    obj5 = null;
                                }
                            }
                        }
                    }
                }
                if (obj != null) {
                    if (i16 <= 127 && i16 < 160) {
                        obj = null;
                    } else if (i16 > 159 && (i16 < 192 || i16 == 215 || i16 == 247)) {
                        i9++;
                    }
                }
                if (obj2 != null) {
                    i13 = i7;
                    i7 = i6;
                    i6 = i5;
                    obj6 = obj2;
                    i14 = i8;
                    i8 = i12;
                    i12 = i14;
                } else if (i5 <= 0) {
                    if (i16 >= 64 || i16 == 127 || i16 > 252) {
                        i14 = i8;
                        i8 = i12;
                        i12 = i14;
                        i15 = i7;
                        i7 = i6;
                        i6 = i5;
                        obj6 = null;
                        i13 = i15;
                    } else {
                        i13 = i5 - 1;
                        obj6 = obj2;
                        i14 = i12;
                        i12 = i8;
                        i8 = i14;
                        i15 = i6;
                        i6 = i13;
                        i13 = i7;
                        i7 = i15;
                    }
                } else if (i16 != 128 || i16 == 160 || i16 > 239) {
                    i14 = i8;
                    i8 = i12;
                    i12 = i14;
                    i15 = i7;
                    i7 = i6;
                    i6 = i5;
                    obj6 = null;
                    i13 = i15;
                } else if (i16 > 160 && i16 < 224) {
                    i6++;
                    i12 = i7 + 1;
                    if (i12 > i8) {
                        i8 = 0;
                        i7 = i6;
                        i13 = i12;
                        i6 = i5;
                        obj6 = obj2;
                    } else {
                        i7 = i6;
                        i6 = i5;
                        obj6 = obj2;
                        i14 = i8;
                        i8 = 0;
                        i13 = i12;
                        i12 = i14;
                    }
                } else if (i16 > 127) {
                    i7 = i5 + 1;
                    i13 = 0;
                    i12++;
                    if (i12 > i11) {
                        i11 = i12;
                        obj6 = obj2;
                        i14 = i12;
                        i12 = i8;
                        i8 = i14;
                        i15 = i7;
                        i7 = i6;
                        i6 = i15;
                    } else {
                        obj6 = obj2;
                        i14 = i12;
                        i12 = i8;
                        i8 = i14;
                        i15 = i7;
                        i7 = i6;
                        i6 = i15;
                    }
                } else {
                    i13 = 0;
                    i7 = i6;
                    i6 = i5;
                    obj6 = obj2;
                    i12 = i8;
                    i8 = 0;
                }
                i10++;
                obj2 = obj6;
                i5 = i6;
                i6 = i7;
                i7 = i13;
                obj4 = obj5;
                i14 = i8;
                i8 = i12;
                i12 = i14;
            }
            obj5 = obj4;
            if (obj != null) {
                if (i16 <= 127) {
                }
                i9++;
            }
            if (obj2 != null) {
                i13 = i7;
                i7 = i6;
                i6 = i5;
                obj6 = obj2;
                i14 = i8;
                i8 = i12;
                i12 = i14;
            } else if (i5 <= 0) {
                if (i16 != 128) {
                }
                i14 = i8;
                i8 = i12;
                i12 = i14;
                i15 = i7;
                i7 = i6;
                i6 = i5;
                obj6 = null;
                i13 = i15;
            } else {
                if (i16 >= 64) {
                }
                i14 = i8;
                i8 = i12;
                i12 = i14;
                i15 = i7;
                i7 = i6;
                i6 = i5;
                obj6 = null;
                i13 = i15;
            }
            i10++;
            obj2 = obj6;
            i5 = i6;
            i6 = i7;
            i7 = i13;
            obj4 = obj5;
            i14 = i8;
            i8 = i12;
            i12 = i14;
        }
        Object obj7 = (obj4 == null || i <= 0) ? obj4 : null;
        if (obj2 != null && i5 > 0) {
            obj2 = null;
        }
        return (obj7 == null || (obj3 == null && (i2 + i3) + i4 <= 0)) ? (obj2 == null || (!f2245b && i8 < 3 && i11 < 3)) ? (obj == null || obj2 == null) ? obj != null ? "ISO8859_1" : obj2 != null ? "SJIS" : obj7 != null ? "UTF8" : f2244a : (!(i8 == 2 && i6 == 2) && i9 * 10 < length) ? "ISO8859_1" : "SJIS" : "SJIS" : "UTF8";
    }
}
