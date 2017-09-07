package com.google.p031b.p034c;

import com.google.p031b.C1155g;
import java.util.HashMap;
import java.util.Map;

public enum C1054d {
    Cp437((String) new int[]{0, 2}, (int) new String[0]),
    ISO8859_1((String) new int[]{1, 3}, (int) new String[]{"ISO-8859-1"}),
    ISO8859_2((String) 4, (int) new String[]{"ISO-8859-2"}),
    ISO8859_3((String) 5, (int) new String[]{"ISO-8859-3"}),
    ISO8859_4((String) 6, (int) new String[]{"ISO-8859-4"}),
    ISO8859_5((String) 7, (int) new String[]{"ISO-8859-5"}),
    ISO8859_6((String) 8, (int) new String[]{"ISO-8859-6"}),
    ISO8859_7((String) 9, (int) new String[]{"ISO-8859-7"}),
    ISO8859_8((String) 10, (int) new String[]{"ISO-8859-8"}),
    ISO8859_9((String) 11, (int) new String[]{"ISO-8859-9"}),
    ISO8859_10((String) 12, (int) new String[]{"ISO-8859-10"}),
    ISO8859_11((String) 13, (int) new String[]{"ISO-8859-11"}),
    ISO8859_13((String) 15, (int) new String[]{"ISO-8859-13"}),
    ISO8859_14((String) 16, (int) new String[]{"ISO-8859-14"}),
    ISO8859_15((String) 17, (int) new String[]{"ISO-8859-15"}),
    ISO8859_16((String) 18, (int) new String[]{"ISO-8859-16"}),
    SJIS((String) 20, (int) new String[]{"Shift_JIS"}),
    Cp1250((String) 21, (int) new String[]{"windows-1250"}),
    Cp1251((String) 22, (int) new String[]{"windows-1251"}),
    Cp1252((String) 23, (int) new String[]{"windows-1252"}),
    Cp1256((String) 24, (int) new String[]{"windows-1256"}),
    UnicodeBigUnmarked((String) 25, (int) new String[]{"UTF-16BE", "UnicodeBig"}),
    UTF8((String) 26, (int) new String[]{"UTF-8"}),
    ASCII((String) new int[]{27, 170}, (int) new String[]{"US-ASCII"}),
    Big5(28),
    GB18030((String) 29, (int) new String[]{"GB2312", "EUC_CN", "GBK"}),
    EUC_KR((String) 30, (int) new String[]{"EUC-KR"});
    
    private static final Map<Integer, C1054d> f2192B = null;
    private static final Map<String, C1054d> f2193C = null;
    private final int[] f2221D;
    private final String[] f2222E;

    static {
        f2192B = new HashMap();
        f2193C = new HashMap();
        for (C1054d c1054d : C1054d.values()) {
            for (int valueOf : c1054d.f2221D) {
                f2192B.put(Integer.valueOf(valueOf), c1054d);
            }
            f2193C.put(c1054d.name(), c1054d);
            for (Object put : c1054d.f2222E) {
                f2193C.put(put, c1054d);
            }
        }
    }

    private C1054d(int i) {
        this(r3, r4, new int[]{i}, new String[0]);
    }

    private C1054d(int i, String... strArr) {
        this.f2221D = new int[]{i};
        this.f2222E = strArr;
    }

    private C1054d(int[] iArr, String... strArr) {
        this.f2221D = iArr;
        this.f2222E = strArr;
    }

    public static C1054d m3861a(int i) {
        if (i >= 0 && i < 900) {
            return (C1054d) f2192B.get(Integer.valueOf(i));
        }
        throw C1155g.m4329a();
    }

    public static C1054d m3862a(String str) {
        return (C1054d) f2193C.get(str);
    }

    public int m3863a() {
        return this.f2221D[0];
    }
}
