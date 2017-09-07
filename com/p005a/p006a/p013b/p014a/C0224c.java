package com.p005a.p006a.p013b.p014a;

import java.util.Comparator;

public final class C0224c {

    static class C02231 implements Comparator<String> {
        C02231() {
        }

        public int m741a(String str, String str2) {
            return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m741a((String) obj, (String) obj2);
        }
    }

    public static Comparator<String> m742a() {
        return new C02231();
    }
}
