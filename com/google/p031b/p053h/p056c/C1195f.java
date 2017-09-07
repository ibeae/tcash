package com.google.p031b.p053h.p056c;

import com.google.p031b.p053h.p054a.C1170f;
import com.google.p031b.p053h.p054a.C1172h;
import com.google.p031b.p053h.p054a.C1176j;
import twitter4j.HttpResponseCode;

public final class C1195f {
    private C1172h f2580a;
    private C1170f f2581b;
    private C1176j f2582c;
    private int f2583d = -1;
    private C1190b f2584e;

    public static boolean m4491b(int i) {
        return i >= 0 && i < 8;
    }

    public C1190b m4492a() {
        return this.f2584e;
    }

    public void m4493a(int i) {
        this.f2583d = i;
    }

    public void m4494a(C1170f c1170f) {
        this.f2581b = c1170f;
    }

    public void m4495a(C1172h c1172h) {
        this.f2580a = c1172h;
    }

    public void m4496a(C1176j c1176j) {
        this.f2582c = c1176j;
    }

    public void m4497a(C1190b c1190b) {
        this.f2584e = c1190b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(HttpResponseCode.OK);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        stringBuilder.append(this.f2580a);
        stringBuilder.append("\n ecLevel: ");
        stringBuilder.append(this.f2581b);
        stringBuilder.append("\n version: ");
        stringBuilder.append(this.f2582c);
        stringBuilder.append("\n maskPattern: ");
        stringBuilder.append(this.f2583d);
        if (this.f2584e == null) {
            stringBuilder.append("\n matrix: null\n");
        } else {
            stringBuilder.append("\n matrix:\n");
            stringBuilder.append(this.f2584e.toString());
        }
        stringBuilder.append(">>\n");
        return stringBuilder.toString();
    }
}
