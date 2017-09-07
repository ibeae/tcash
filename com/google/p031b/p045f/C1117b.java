package com.google.p031b.p045f;

import com.google.p031b.C1198j;
import com.google.p031b.p034c.C1046a;

public final class C1117b extends C1108l {
    static final int[][] f2379a = new int[][]{new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static int m4108a(C1046a c1046a, int[] iArr, int i) {
        C1108l.m4045a(c1046a, i, iArr);
        int i2 = 64;
        int i3 = -1;
        for (int i4 = 0; i4 < f2379a.length; i4++) {
            int a = C1108l.m4044a(iArr, f2379a[i4], 179);
            if (a < i2) {
                i3 = i4;
                i2 = a;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw C1198j.m4509a();
    }

    private static int[] m4109a(C1046a c1046a) {
        int a = c1046a.m3802a();
        int c = c1046a.m3813c(0);
        Object obj = new int[6];
        int length = obj.length;
        int i = c;
        int i2 = 0;
        int i3 = c;
        int i4 = 0;
        while (i < a) {
            int i5;
            int i6;
            if ((c1046a.m3807a(i) ^ i2) != 0) {
                obj[i4] = obj[i4] + 1;
                i5 = i2;
                i6 = i4;
            } else {
                if (i4 == length - 1) {
                    int i7 = 64;
                    c = -1;
                    i6 = 103;
                    while (i6 <= 105) {
                        i5 = C1108l.m4044a((int[]) obj, f2379a[i6], 179);
                        if (i5 < i7) {
                            c = i6;
                        } else {
                            i5 = i7;
                        }
                        i6++;
                        i7 = i5;
                    }
                    if (c < 0 || !c1046a.m3808a(Math.max(0, i3 - ((i - i3) / 2)), i3, false)) {
                        c = (obj[0] + obj[1]) + i3;
                        System.arraycopy(obj, 2, obj, 0, length - 2);
                        obj[length - 2] = null;
                        obj[length - 1] = null;
                        i6 = i4 - 1;
                    } else {
                        return new int[]{i3, i, c};
                    }
                }
                i6 = i4 + 1;
                c = i3;
                obj[i6] = 1;
                if (i2 == 0) {
                    i5 = 1;
                } else {
                    boolean z = false;
                }
                i3 = c;
            }
            i++;
            i2 = i5;
            i4 = i6;
        }
        throw C1198j.m4509a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.p031b.C1199m mo1426a(int r24, com.google.p031b.p034c.C1046a r25, java.util.Map<com.google.p031b.C1084e, ?> r26) {
        /*
        r23 = this;
        if (r26 == 0) goto L_0x002f;
    L_0x0002:
        r2 = com.google.p031b.C1084e.ASSUME_GS1;
        r0 = r26;
        r2 = r0.containsKey(r2);
        if (r2 == 0) goto L_0x002f;
    L_0x000c:
        r2 = 1;
    L_0x000d:
        r15 = com.google.p031b.p045f.C1117b.m4109a(r25);
        r3 = 2;
        r5 = r15[r3];
        r16 = new java.util.ArrayList;
        r3 = 20;
        r0 = r16;
        r0.<init>(r3);
        r3 = (byte) r5;
        r3 = java.lang.Byte.valueOf(r3);
        r0 = r16;
        r0.add(r3);
        switch(r5) {
            case 103: goto L_0x0031;
            case 104: goto L_0x008a;
            case 105: goto L_0x008d;
            default: goto L_0x002a;
        };
    L_0x002a:
        r2 = com.google.p031b.C1155g.m4329a();
        throw r2;
    L_0x002f:
        r2 = 0;
        goto L_0x000d;
    L_0x0031:
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
    L_0x0033:
        r10 = 0;
        r9 = 0;
        r17 = new java.lang.StringBuilder;
        r4 = 20;
        r0 = r17;
        r0.<init>(r4);
        r4 = 0;
        r7 = r15[r4];
        r4 = 1;
        r11 = r15[r4];
        r4 = 6;
        r0 = new int[r4];
        r18 = r0;
        r12 = 0;
        r6 = 0;
        r4 = 0;
        r8 = 1;
        r14 = r9;
        r9 = r7;
        r7 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r12;
        r12 = r6;
        r6 = r10;
    L_0x0055:
        if (r6 != 0) goto L_0x01f3;
    L_0x0057:
        r5 = 0;
        r0 = r25;
        r1 = r18;
        r13 = com.google.p031b.p045f.C1117b.m4108a(r0, r1, r11);
        r9 = (byte) r13;
        r9 = java.lang.Byte.valueOf(r9);
        r0 = r16;
        r0.add(r9);
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r13 == r9) goto L_0x006f;
    L_0x006e:
        r8 = 1;
    L_0x006f:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r13 == r9) goto L_0x0078;
    L_0x0073:
        r3 = r3 + 1;
        r9 = r3 * r13;
        r4 = r4 + r9;
    L_0x0078:
        r0 = r18;
        r0 = r0.length;
        r19 = r0;
        r9 = 0;
        r10 = r11;
    L_0x007f:
        r0 = r19;
        if (r9 >= r0) goto L_0x0090;
    L_0x0083:
        r20 = r18[r9];
        r10 = r10 + r20;
        r9 = r9 + 1;
        goto L_0x007f;
    L_0x008a:
        r3 = 100;
        goto L_0x0033;
    L_0x008d:
        r3 = 99;
        goto L_0x0033;
    L_0x0090:
        switch(r13) {
            case 103: goto L_0x00b4;
            case 104: goto L_0x00b4;
            case 105: goto L_0x00b4;
            default: goto L_0x0093;
        };
    L_0x0093:
        switch(r7) {
            case 99: goto L_0x016e;
            case 100: goto L_0x011e;
            case 101: goto L_0x00b9;
            default: goto L_0x0096;
        };
    L_0x0096:
        r21 = r8;
        r8 = r6;
        r6 = r21;
        r22 = r5;
        r5 = r7;
        r7 = r22;
    L_0x00a0:
        if (r14 == 0) goto L_0x00a8;
    L_0x00a2:
        r9 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r5 != r9) goto L_0x01ef;
    L_0x00a6:
        r5 = 100;
    L_0x00a8:
        r9 = r11;
        r14 = r7;
        r11 = r10;
        r7 = r5;
        r5 = r12;
        r12 = r13;
        r21 = r8;
        r8 = r6;
        r6 = r21;
        goto L_0x0055;
    L_0x00b4:
        r2 = com.google.p031b.C1155g.m4329a();
        throw r2;
    L_0x00b9:
        r9 = 64;
        if (r13 >= r9) goto L_0x00d0;
    L_0x00bd:
        r9 = r13 + 32;
        r9 = (char) r9;
        r0 = r17;
        r0.append(r9);
        r21 = r8;
        r8 = r6;
        r6 = r21;
        r22 = r5;
        r5 = r7;
        r7 = r22;
        goto L_0x00a0;
    L_0x00d0:
        r9 = 96;
        if (r13 >= r9) goto L_0x00e7;
    L_0x00d4:
        r9 = r13 + -64;
        r9 = (char) r9;
        r0 = r17;
        r0.append(r9);
        r21 = r8;
        r8 = r6;
        r6 = r21;
        r22 = r5;
        r5 = r7;
        r7 = r22;
        goto L_0x00a0;
    L_0x00e7:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r13 == r9) goto L_0x00ec;
    L_0x00eb:
        r8 = 0;
    L_0x00ec:
        switch(r13) {
            case 96: goto L_0x00ef;
            case 97: goto L_0x00ef;
            case 98: goto L_0x0112;
            case 99: goto L_0x0119;
            case 100: goto L_0x0116;
            case 101: goto L_0x00ef;
            case 102: goto L_0x00fa;
            case 103: goto L_0x00ef;
            case 104: goto L_0x00ef;
            case 105: goto L_0x00ef;
            case 106: goto L_0x011c;
            default: goto L_0x00ef;
        };
    L_0x00ef:
        r21 = r8;
        r8 = r6;
        r6 = r21;
        r22 = r5;
        r5 = r7;
        r7 = r22;
        goto L_0x00a0;
    L_0x00fa:
        if (r2 == 0) goto L_0x00ef;
    L_0x00fc:
        r9 = r17.length();
        if (r9 != 0) goto L_0x010a;
    L_0x0102:
        r9 = "]C1";
        r0 = r17;
        r0.append(r9);
        goto L_0x00ef;
    L_0x010a:
        r9 = 29;
        r0 = r17;
        r0.append(r9);
        goto L_0x00ef;
    L_0x0112:
        r5 = 1;
        r7 = 100;
        goto L_0x00ef;
    L_0x0116:
        r7 = 100;
        goto L_0x00ef;
    L_0x0119:
        r7 = 99;
        goto L_0x00ef;
    L_0x011c:
        r6 = 1;
        goto L_0x00ef;
    L_0x011e:
        r9 = 96;
        if (r13 >= r9) goto L_0x0136;
    L_0x0122:
        r9 = r13 + 32;
        r9 = (char) r9;
        r0 = r17;
        r0.append(r9);
        r21 = r8;
        r8 = r6;
        r6 = r21;
        r22 = r5;
        r5 = r7;
        r7 = r22;
        goto L_0x00a0;
    L_0x0136:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r13 == r9) goto L_0x013b;
    L_0x013a:
        r8 = 0;
    L_0x013b:
        switch(r13) {
            case 96: goto L_0x013e;
            case 97: goto L_0x013e;
            case 98: goto L_0x0162;
            case 99: goto L_0x0169;
            case 100: goto L_0x013e;
            case 101: goto L_0x0166;
            case 102: goto L_0x014a;
            case 103: goto L_0x013e;
            case 104: goto L_0x013e;
            case 105: goto L_0x013e;
            case 106: goto L_0x016c;
            default: goto L_0x013e;
        };
    L_0x013e:
        r21 = r8;
        r8 = r6;
        r6 = r21;
        r22 = r5;
        r5 = r7;
        r7 = r22;
        goto L_0x00a0;
    L_0x014a:
        if (r2 == 0) goto L_0x013e;
    L_0x014c:
        r9 = r17.length();
        if (r9 != 0) goto L_0x015a;
    L_0x0152:
        r9 = "]C1";
        r0 = r17;
        r0.append(r9);
        goto L_0x013e;
    L_0x015a:
        r9 = 29;
        r0 = r17;
        r0.append(r9);
        goto L_0x013e;
    L_0x0162:
        r5 = 1;
        r7 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x013e;
    L_0x0166:
        r7 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x013e;
    L_0x0169:
        r7 = 99;
        goto L_0x013e;
    L_0x016c:
        r6 = 1;
        goto L_0x013e;
    L_0x016e:
        r9 = 100;
        if (r13 >= r9) goto L_0x018e;
    L_0x0172:
        r9 = 10;
        if (r13 >= r9) goto L_0x017d;
    L_0x0176:
        r9 = 48;
        r0 = r17;
        r0.append(r9);
    L_0x017d:
        r0 = r17;
        r0.append(r13);
        r21 = r8;
        r8 = r6;
        r6 = r21;
        r22 = r5;
        r5 = r7;
        r7 = r22;
        goto L_0x00a0;
    L_0x018e:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r13 == r9) goto L_0x0193;
    L_0x0192:
        r8 = 0;
    L_0x0193:
        switch(r13) {
            case 100: goto L_0x0198;
            case 101: goto L_0x01d4;
            case 102: goto L_0x01a6;
            case 103: goto L_0x0196;
            case 104: goto L_0x0196;
            case 105: goto L_0x0196;
            case 106: goto L_0x01e2;
            default: goto L_0x0196;
        };
    L_0x0196:
        goto L_0x0096;
    L_0x0198:
        r7 = 100;
        r21 = r8;
        r8 = r6;
        r6 = r21;
        r22 = r5;
        r5 = r7;
        r7 = r22;
        goto L_0x00a0;
    L_0x01a6:
        if (r2 == 0) goto L_0x0096;
    L_0x01a8:
        r9 = r17.length();
        if (r9 != 0) goto L_0x01c1;
    L_0x01ae:
        r9 = "]C1";
        r0 = r17;
        r0.append(r9);
        r21 = r8;
        r8 = r6;
        r6 = r21;
        r22 = r5;
        r5 = r7;
        r7 = r22;
        goto L_0x00a0;
    L_0x01c1:
        r9 = 29;
        r0 = r17;
        r0.append(r9);
        r21 = r8;
        r8 = r6;
        r6 = r21;
        r22 = r5;
        r5 = r7;
        r7 = r22;
        goto L_0x00a0;
    L_0x01d4:
        r7 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r21 = r8;
        r8 = r6;
        r6 = r21;
        r22 = r5;
        r5 = r7;
        r7 = r22;
        goto L_0x00a0;
    L_0x01e2:
        r6 = 1;
        r21 = r8;
        r8 = r6;
        r6 = r21;
        r22 = r5;
        r5 = r7;
        r7 = r22;
        goto L_0x00a0;
    L_0x01ef:
        r5 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x00a8;
    L_0x01f3:
        r2 = r11 - r9;
        r0 = r25;
        r6 = r0.m3815d(r11);
        r10 = r25.m3802a();
        r11 = r6 - r9;
        r11 = r11 / 2;
        r11 = r11 + r6;
        r10 = java.lang.Math.min(r10, r11);
        r11 = 0;
        r0 = r25;
        r6 = r0.m3808a(r6, r10, r11);
        if (r6 != 0) goto L_0x0216;
    L_0x0211:
        r2 = com.google.p031b.C1198j.m4509a();
        throw r2;
    L_0x0216:
        r3 = r3 * r5;
        r3 = r4 - r3;
        r3 = r3 % 103;
        if (r3 == r5) goto L_0x0222;
    L_0x021d:
        r2 = com.google.p031b.C1079d.m3955a();
        throw r2;
    L_0x0222:
        r3 = r17.length();
        if (r3 != 0) goto L_0x022d;
    L_0x0228:
        r2 = com.google.p031b.C1198j.m4509a();
        throw r2;
    L_0x022d:
        if (r3 <= 0) goto L_0x023c;
    L_0x022f:
        if (r8 == 0) goto L_0x023c;
    L_0x0231:
        r4 = 99;
        if (r7 != r4) goto L_0x026b;
    L_0x0235:
        r4 = r3 + -2;
        r0 = r17;
        r0.delete(r4, r3);
    L_0x023c:
        r3 = 1;
        r3 = r15[r3];
        r4 = 0;
        r4 = r15[r4];
        r3 = r3 + r4;
        r3 = (float) r3;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = r3 / r4;
        r3 = (float) r9;
        r2 = (float) r2;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 / r5;
        r5 = r3 + r2;
        r6 = r16.size();
        r7 = new byte[r6];
        r2 = 0;
        r3 = r2;
    L_0x0257:
        if (r3 >= r6) goto L_0x0273;
    L_0x0259:
        r0 = r16;
        r2 = r0.get(r3);
        r2 = (java.lang.Byte) r2;
        r2 = r2.byteValue();
        r7[r3] = r2;
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0257;
    L_0x026b:
        r4 = r3 + -1;
        r0 = r17;
        r0.delete(r4, r3);
        goto L_0x023c;
    L_0x0273:
        r2 = new com.google.b.m;
        r3 = r17.toString();
        r6 = 2;
        r6 = new com.google.p031b.C1178o[r6];
        r8 = 0;
        r9 = new com.google.b.o;
        r0 = r24;
        r10 = (float) r0;
        r9.<init>(r4, r10);
        r6[r8] = r9;
        r4 = 1;
        r8 = new com.google.b.o;
        r0 = r24;
        r9 = (float) r0;
        r8.<init>(r5, r9);
        r6[r4] = r8;
        r4 = com.google.p031b.C1016a.CODE_128;
        r2.<init>(r3, r7, r6, r4);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.f.b.a(int, com.google.b.c.a, java.util.Map):com.google.b.m");
    }
}
