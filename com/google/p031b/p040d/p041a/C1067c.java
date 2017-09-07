package com.google.p031b.p040d.p041a;

import android.support.v4.app.NotificationCompat;
import com.google.p031b.C1155g;
import com.google.p031b.p034c.C1053c;
import com.google.p031b.p034c.C1055e;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class C1067c {
    private static final char[] f2262a = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] f2263b = new char[]{'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
    private static final char[] f2264c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] f2265d = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', ''};

    private enum C1066a {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    private static int m3915a(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + NotificationCompat.FLAG_LOCAL_ONLY;
    }

    static C1055e m3916a(byte[] bArr) {
        String stringBuilder;
        List list;
        C1053c c1053c = new C1053c(bArr);
        StringBuilder stringBuilder2 = new StringBuilder(100);
        StringBuilder stringBuilder3 = new StringBuilder(0);
        Collection arrayList = new ArrayList(1);
        C1066a c1066a = C1066a.ASCII_ENCODE;
        do {
            if (c1066a == C1066a.ASCII_ENCODE) {
                c1066a = C1067c.m3917a(c1053c, stringBuilder2, stringBuilder3);
            } else {
                switch (c1066a) {
                    case C40_ENCODE:
                        C1067c.m3919a(c1053c, stringBuilder2);
                        break;
                    case TEXT_ENCODE:
                        C1067c.m3921b(c1053c, stringBuilder2);
                        break;
                    case ANSIX12_ENCODE:
                        C1067c.m3922c(c1053c, stringBuilder2);
                        break;
                    case EDIFACT_ENCODE:
                        C1067c.m3923d(c1053c, stringBuilder2);
                        break;
                    case BASE256_ENCODE:
                        C1067c.m3920a(c1053c, stringBuilder2, arrayList);
                        break;
                    default:
                        throw C1155g.m4329a();
                }
                c1066a = C1066a.ASCII_ENCODE;
            }
            if (c1066a != C1066a.PAD_ENCODE) {
            }
            if (stringBuilder3.length() > 0) {
                stringBuilder2.append(stringBuilder3.toString());
            }
            stringBuilder = stringBuilder2.toString();
            if (arrayList.isEmpty()) {
                Collection collection = arrayList;
            } else {
                list = null;
            }
            return new C1055e(bArr, stringBuilder, list, null);
        } while (c1053c.m3860c() > 0);
        if (stringBuilder3.length() > 0) {
            stringBuilder2.append(stringBuilder3.toString());
        }
        stringBuilder = stringBuilder2.toString();
        if (arrayList.isEmpty()) {
            Collection collection2 = arrayList;
        } else {
            list = null;
        }
        return new C1055e(bArr, stringBuilder, list, null);
    }

    private static C1066a m3917a(C1053c c1053c, StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        int i = 0;
        do {
            int a = c1053c.m3858a(8);
            if (a == 0) {
                throw C1155g.m4329a();
            } else if (a <= 128) {
                stringBuilder.append((char) ((i != 0 ? a + 128 : a) - 1));
                return C1066a.ASCII_ENCODE;
            } else if (a == 129) {
                return C1066a.PAD_ENCODE;
            } else {
                if (a <= 229) {
                    a -= 130;
                    if (a < 10) {
                        stringBuilder.append('0');
                    }
                    stringBuilder.append(a);
                } else if (a == 230) {
                    return C1066a.C40_ENCODE;
                } else {
                    if (a == 231) {
                        return C1066a.BASE256_ENCODE;
                    }
                    if (a == 232) {
                        stringBuilder.append('\u001d');
                    } else if (!(a == 233 || a == 234)) {
                        if (a == 235) {
                            i = 1;
                        } else if (a == 236) {
                            stringBuilder.append("[)>\u001e05\u001d");
                            stringBuilder2.insert(0, "\u001e\u0004");
                        } else if (a == 237) {
                            stringBuilder.append("[)>\u001e06\u001d");
                            stringBuilder2.insert(0, "\u001e\u0004");
                        } else if (a == 238) {
                            return C1066a.ANSIX12_ENCODE;
                        } else {
                            if (a == 239) {
                                return C1066a.TEXT_ENCODE;
                            }
                            if (a == 240) {
                                return C1066a.EDIFACT_ENCODE;
                            }
                            if (!(a == 241 || a < 242 || (a == 254 && c1053c.m3860c() == 0))) {
                                throw C1155g.m4329a();
                            }
                        }
                    }
                }
            }
        } while (c1053c.m3860c() > 0);
        return C1066a.ASCII_ENCODE;
    }

    private static void m3918a(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        i3 -= i4 * 1600;
        i4 = i3 / 40;
        iArr[1] = i4;
        iArr[2] = i3 - (i4 * 40);
    }

    private static void m3919a(C1053c c1053c, StringBuilder stringBuilder) {
        int[] iArr = new int[3];
        int i = 0;
        Object obj = null;
        while (c1053c.m3860c() != 8) {
            int a = c1053c.m3858a(8);
            if (a != 254) {
                C1067c.m3918a(a, c1053c.m3858a(8), iArr);
                for (a = 0; a < 3; a++) {
                    int i2 = iArr[a];
                    switch (i) {
                        case 0:
                            if (i2 < 3) {
                                i = i2 + 1;
                                break;
                            } else if (i2 < f2262a.length) {
                                char c = f2262a[i2];
                                if (obj == null) {
                                    stringBuilder.append(c);
                                    break;
                                }
                                stringBuilder.append((char) (c + 128));
                                obj = null;
                                break;
                            } else {
                                throw C1155g.m4329a();
                            }
                        case 1:
                            if (obj != null) {
                                stringBuilder.append((char) (i2 + 128));
                                obj = null;
                            } else {
                                stringBuilder.append((char) i2);
                            }
                            i = 0;
                            break;
                        case 2:
                            if (i2 < f2263b.length) {
                                char c2 = f2263b[i2];
                                if (obj != null) {
                                    stringBuilder.append((char) (c2 + 128));
                                    obj = null;
                                } else {
                                    stringBuilder.append(c2);
                                }
                            } else if (i2 == 27) {
                                stringBuilder.append('\u001d');
                            } else if (i2 == 30) {
                                obj = 1;
                            } else {
                                throw C1155g.m4329a();
                            }
                            i = 0;
                            break;
                        case 3:
                            if (obj != null) {
                                stringBuilder.append((char) (i2 + 224));
                                obj = null;
                            } else {
                                stringBuilder.append((char) (i2 + 96));
                            }
                            i = 0;
                            break;
                        default:
                            throw C1155g.m4329a();
                    }
                }
                if (c1053c.m3860c() <= 0) {
                    return;
                }
            }
            return;
        }
    }

    private static void m3920a(C1053c c1053c, StringBuilder stringBuilder, Collection<byte[]> collection) {
        int c;
        int b = c1053c.m3859b() + 1;
        int i = b + 1;
        b = C1067c.m3915a(c1053c.m3858a(8), b);
        if (b == 0) {
            c = c1053c.m3860c() / 8;
        } else if (b < 250) {
            c = b;
        } else {
            c = ((b - 249) * 250) + C1067c.m3915a(c1053c.m3858a(8), i);
            i++;
        }
        if (c < 0) {
            throw C1155g.m4329a();
        }
        Object obj = new byte[c];
        b = 0;
        while (b < c) {
            if (c1053c.m3860c() < 8) {
                throw C1155g.m4329a();
            }
            int i2 = i + 1;
            obj[b] = (byte) C1067c.m3915a(c1053c.m3858a(8), i);
            b++;
            i = i2;
        }
        collection.add(obj);
        try {
            stringBuilder.append(new String(obj, "ISO8859_1"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Platform does not support required encoding: " + e);
        }
    }

    private static void m3921b(C1053c c1053c, StringBuilder stringBuilder) {
        int[] iArr = new int[3];
        int i = 0;
        Object obj = null;
        while (c1053c.m3860c() != 8) {
            int a = c1053c.m3858a(8);
            if (a != 254) {
                C1067c.m3918a(a, c1053c.m3858a(8), iArr);
                for (a = 0; a < 3; a++) {
                    int i2 = iArr[a];
                    char c;
                    switch (i) {
                        case 0:
                            if (i2 < 3) {
                                i = i2 + 1;
                                break;
                            } else if (i2 < f2264c.length) {
                                char c2 = f2264c[i2];
                                if (obj == null) {
                                    stringBuilder.append(c2);
                                    break;
                                }
                                stringBuilder.append((char) (c2 + 128));
                                obj = null;
                                break;
                            } else {
                                throw C1155g.m4329a();
                            }
                        case 1:
                            if (obj != null) {
                                stringBuilder.append((char) (i2 + 128));
                                obj = null;
                            } else {
                                stringBuilder.append((char) i2);
                            }
                            i = 0;
                            break;
                        case 2:
                            if (i2 < f2263b.length) {
                                c = f2263b[i2];
                                if (obj != null) {
                                    stringBuilder.append((char) (c + 128));
                                    obj = null;
                                } else {
                                    stringBuilder.append(c);
                                }
                            } else if (i2 == 27) {
                                stringBuilder.append('\u001d');
                            } else if (i2 == 30) {
                                obj = 1;
                            } else {
                                throw C1155g.m4329a();
                            }
                            i = 0;
                            break;
                        case 3:
                            if (i2 < f2265d.length) {
                                c = f2265d[i2];
                                if (obj != null) {
                                    stringBuilder.append((char) (c + 128));
                                    obj = null;
                                } else {
                                    stringBuilder.append(c);
                                }
                                i = 0;
                                break;
                            }
                            throw C1155g.m4329a();
                        default:
                            throw C1155g.m4329a();
                    }
                }
                if (c1053c.m3860c() <= 0) {
                    return;
                }
            }
            return;
        }
    }

    private static void m3922c(C1053c c1053c, StringBuilder stringBuilder) {
        int[] iArr = new int[3];
        while (c1053c.m3860c() != 8) {
            int a = c1053c.m3858a(8);
            if (a != 254) {
                C1067c.m3918a(a, c1053c.m3858a(8), iArr);
                for (a = 0; a < 3; a++) {
                    int i = iArr[a];
                    if (i == 0) {
                        stringBuilder.append('\r');
                    } else if (i == 1) {
                        stringBuilder.append('*');
                    } else if (i == 2) {
                        stringBuilder.append('>');
                    } else if (i == 3) {
                        stringBuilder.append(' ');
                    } else if (i < 14) {
                        stringBuilder.append((char) (i + 44));
                    } else if (i < 40) {
                        stringBuilder.append((char) (i + 51));
                    } else {
                        throw C1155g.m4329a();
                    }
                }
                if (c1053c.m3860c() <= 0) {
                    return;
                }
            }
            return;
        }
    }

    private static void m3923d(C1053c c1053c, StringBuilder stringBuilder) {
        while (c1053c.m3860c() > 16) {
            for (int i = 0; i < 4; i++) {
                int a = c1053c.m3858a(6);
                if (a == 31) {
                    a = 8 - c1053c.m3857a();
                    if (a != 8) {
                        c1053c.m3858a(a);
                        return;
                    }
                    return;
                }
                if ((a & 32) == 0) {
                    a |= 64;
                }
                stringBuilder.append((char) a);
            }
            if (c1053c.m3860c() <= 0) {
                return;
            }
        }
    }
}
