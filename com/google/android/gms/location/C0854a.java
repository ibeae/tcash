package com.google.android.gms.location;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.common.C0665b;
import com.google.android.gms.common.C0665b.C0660b;
import com.google.android.gms.common.C0665b.C0664a;
import com.google.android.gms.internal.et;

@Deprecated
public class C0854a implements C0665b {
    private final et f1820a;

    public C0854a(Context context, C0664a c0664a, C0660b c0660b) {
        this.f1820a = new et(context, c0664a, c0660b, "location");
    }

    public Location m2807a() {
        return this.f1820a.m2458c();
    }

    public void m2808b() {
        this.f1820a.m1932f();
    }

    public void m2809c() {
        this.f1820a.mo1053i();
    }

    public boolean m2810d() {
        return this.f1820a.mo954g();
    }
}
