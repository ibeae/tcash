package com.google.p031b.p036b.p037a;

import com.facebook.internal.NativeProtocol;
import com.google.p031b.C1199m;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class af extends C1017u {
    private static final Pattern f2060a = Pattern.compile("BEGIN:VCARD", 2);
    private static final Pattern f2061b = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
    private static final Pattern f2062c = Pattern.compile("\r\n[ \t]");
    private static final Pattern f2063d = Pattern.compile("\\\\[nN]");
    private static final Pattern f2064e = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern f2065f = Pattern.compile("=");
    private static final Pattern f2066g = Pattern.compile(";");
    private static final Pattern f2067h = Pattern.compile("(?<!\\\\);+");
    private static final Pattern f2068i = Pattern.compile(",");
    private static final Pattern f2069j = Pattern.compile("[;,]");

    private static String m3719a(CharSequence charSequence, String str) {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            switch (charAt) {
                case '\n':
                case '\r':
                    break;
                case '=':
                    if (i >= length - 2) {
                        break;
                    }
                    charAt = charSequence.charAt(i + 1);
                    if (!(charAt == '\r' || charAt == '\n')) {
                        char charAt2 = charSequence.charAt(i + 2);
                        int a = C1017u.m3690a(charAt);
                        int a2 = C1017u.m3690a(charAt2);
                        if (a >= 0 && a2 >= 0) {
                            byteArrayOutputStream.write((a << 4) + a2);
                        }
                        i += 2;
                        break;
                    }
                default:
                    af.m3722a(byteArrayOutputStream, str, stringBuilder);
                    stringBuilder.append(charAt);
                    break;
            }
            i++;
        }
        af.m3722a(byteArrayOutputStream, str, stringBuilder);
        return stringBuilder.toString();
    }

    private static String m3720a(List<String> list) {
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    static List<List<String>> m3721a(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> list = null;
        int i = 0;
        int length = str.length();
        while (i < length) {
            Matcher matcher = Pattern.compile("(?:^|\n)" + charSequence + "(?:;([^:]*))?:", 2).matcher(str);
            if (i > 0) {
                i--;
            }
            if (!matcher.find(i)) {
                break;
            }
            String str2;
            List list2;
            int end = matcher.end(0);
            CharSequence group = matcher.group(1);
            List list3 = null;
            Object obj = null;
            String str3 = null;
            if (group != null) {
                String[] split = f2066g.split(group);
                int length2 = split.length;
                int i2 = 0;
                while (i2 < length2) {
                    Object obj2;
                    group = split[i2];
                    if (list3 == null) {
                        list3 = new ArrayList(1);
                    }
                    list3.add(group);
                    String[] split2 = f2065f.split(group, 2);
                    if (split2.length > 1) {
                        String str4 = split2[0];
                        str2 = split2[1];
                        if ("ENCODING".equalsIgnoreCase(str4) && "QUOTED-PRINTABLE".equalsIgnoreCase(str2)) {
                            obj2 = 1;
                            i2++;
                            obj = obj2;
                        } else if ("CHARSET".equalsIgnoreCase(str4)) {
                            str3 = str2;
                            obj2 = obj;
                            i2++;
                            obj = obj2;
                        }
                    }
                    obj2 = obj;
                    i2++;
                    obj = obj2;
                }
                str2 = str3;
                list2 = list3;
            } else {
                str2 = null;
                list2 = null;
            }
            i = end;
            while (true) {
                i = str.indexOf(10, i);
                if (i < 0) {
                    break;
                } else if (i >= str.length() - 1 || (str.charAt(i + 1) != ' ' && str.charAt(i + 1) != '\t')) {
                    if (obj == null || ((i < 1 || str.charAt(i - 1) != '=') && (i < 2 || str.charAt(i - 2) != '='))) {
                        break;
                    }
                    i++;
                } else {
                    i += 2;
                }
            }
            if (i < 0) {
                i = length;
            } else if (i > end) {
                Object a;
                List<List<String>> arrayList = list == null ? new ArrayList(1) : list;
                if (i >= 1 && str.charAt(i - 1) == '\r') {
                    i--;
                }
                CharSequence substring = str.substring(end, i);
                if (z) {
                    substring = substring.trim();
                }
                if (obj != null) {
                    a = af.m3719a(substring, str2);
                    if (z2) {
                        a = f2067h.matcher(a).replaceAll("\n").trim();
                    }
                } else {
                    if (z2) {
                        substring = f2067h.matcher(substring).replaceAll("\n").trim();
                    }
                    a = f2064e.matcher(f2063d.matcher(f2062c.matcher(substring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                }
                if (list2 == null) {
                    List arrayList2 = new ArrayList(1);
                    arrayList2.add(a);
                    arrayList.add(arrayList2);
                } else {
                    list2.add(0, a);
                    arrayList.add(list2);
                }
                i++;
                list = arrayList;
            } else {
                i++;
            }
        }
        return list;
    }

    private static void m3722a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder stringBuilder) {
        if (byteArrayOutputStream.size() > 0) {
            String str2;
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(toByteArray, Charset.forName("UTF-8"));
            } else {
                try {
                    str2 = new String(toByteArray, str);
                } catch (UnsupportedEncodingException e) {
                    str2 = new String(toByteArray, Charset.forName("UTF-8"));
                }
            }
            byteArrayOutputStream.reset();
            stringBuilder.append(str2);
        }
    }

    private static void m3723a(Iterable<List<String>> iterable) {
        if (iterable != null) {
            for (List list : iterable) {
                String str = (String) list.get(0);
                String[] strArr = new String[5];
                int i = 0;
                int i2 = 0;
                while (i < strArr.length - 1) {
                    int indexOf = str.indexOf(59, i2);
                    if (indexOf < 0) {
                        break;
                    }
                    strArr[i] = str.substring(i2, indexOf);
                    i++;
                    i2 = indexOf + 1;
                }
                strArr[i] = str.substring(i2);
                StringBuilder stringBuilder = new StringBuilder(100);
                af.m3724a(strArr, 3, stringBuilder);
                af.m3724a(strArr, 1, stringBuilder);
                af.m3724a(strArr, 2, stringBuilder);
                af.m3724a(strArr, 0, stringBuilder);
                af.m3724a(strArr, 4, stringBuilder);
                list.set(0, stringBuilder.toString().trim());
            }
        }
    }

    private static void m3724a(String[] strArr, int i, StringBuilder stringBuilder) {
        if (strArr[i] != null && !strArr[i].isEmpty()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(strArr[i]);
        }
    }

    private static boolean m3725a(CharSequence charSequence) {
        return charSequence == null || f2061b.matcher(charSequence).matches();
    }

    private static String[] m3726a(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        List arrayList = new ArrayList(collection.size());
        for (List list : collection) {
            String str = (String) list.get(0);
            if (!(str == null || str.isEmpty())) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    static List<String> m3727b(CharSequence charSequence, String str, boolean z, boolean z2) {
        List a = af.m3721a(charSequence, str, z, z2);
        return (a == null || a.isEmpty()) ? null : (List) a.get(0);
    }

    private static String[] m3728b(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        List arrayList = new ArrayList(collection.size());
        for (List list : collection) {
            Object obj;
            int i = 1;
            while (i < list.size()) {
                obj = (String) list.get(i);
                int indexOf = obj.indexOf(61);
                if (indexOf < 0) {
                    break;
                } else if ("TYPE".equalsIgnoreCase(obj.substring(0, indexOf))) {
                    obj = obj.substring(indexOf + 1);
                    break;
                } else {
                    i++;
                }
            }
            obj = null;
            arrayList.add(obj);
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    public C1022d m3729a(C1199m c1199m) {
        String c = C1017u.m3696c(c1199m);
        Matcher matcher = f2060a.matcher(c);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List a = af.m3721a("FN", c, true, false);
        if (a == null) {
            a = af.m3721a("N", c, true, false);
            af.m3723a((Iterable) a);
        }
        Collection collection = a;
        a = af.m3727b("NICKNAME", c, true, false);
        String[] split = a == null ? null : f2068i.split((CharSequence) a.get(0));
        Collection a2 = af.m3721a("TEL", c, true, false);
        Collection a3 = af.m3721a("EMAIL", c, true, false);
        List b = af.m3727b("NOTE", c, false, false);
        Collection a4 = af.m3721a("ADR", c, true, true);
        List b2 = af.m3727b("ORG", c, true, true);
        List b3 = af.m3727b("BDAY", c, true, false);
        List list = (b3 == null || af.m3725a((CharSequence) b3.get(0))) ? b3 : null;
        List b4 = af.m3727b(NativeProtocol.METHOD_ARGS_TITLE, c, true, false);
        Collection a5 = af.m3721a("URL", c, true, false);
        List b5 = af.m3727b("IMPP", c, true, false);
        a = af.m3727b("GEO", c, true, false);
        String[] split2 = a == null ? null : f2069j.split((CharSequence) a.get(0));
        if (!(split2 == null || split2.length == 2)) {
            split2 = null;
        }
        return new C1022d(af.m3726a(collection), split, null, af.m3726a(a2), af.m3728b(a2), af.m3726a(a3), af.m3728b(a3), af.m3720a(b5), af.m3720a(b), af.m3726a(a4), af.m3728b(a4), af.m3720a(b2), af.m3720a(list), af.m3720a(b4), af.m3726a(a5), split2);
    }

    public /* synthetic */ C1019q mo1416b(C1199m c1199m) {
        return m3729a(c1199m);
    }
}
