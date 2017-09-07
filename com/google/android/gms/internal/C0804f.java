package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.C0775e.C0715a;
import com.google.android.gms.internal.dv.C0699a;
import org.json.JSONObject;

public class C0804f implements C0775e {
    private final dt f1570a;

    public C0804f(Context context, ev evVar) {
        this.f1570a = dt.m2125a(context, new al(), false, false, null, evVar);
    }

    public void mo1054a() {
        dk.m2070a(this.f1570a);
    }

    public void mo1055a(final C0715a c0715a) {
        this.f1570a.m2142f().m2152a(new C0699a(this) {
            final /* synthetic */ C0804f f1569b;

            public void mo921a(dt dtVar) {
                c0715a.mo945a();
            }
        });
    }

    public void mo1056a(String str) {
        this.f1570a.loadUrl(str);
    }

    public void mo1057a(String str, aa aaVar) {
        this.f1570a.m2142f().m2155a(str, aaVar);
    }

    public void mo1058a(String str, JSONObject jSONObject) {
        this.f1570a.m2135a(str, jSONObject);
    }

    public void mo1059b() {
        dk.m2081b(this.f1570a);
    }

    public void mo1060b(String str) {
        this.f1570a.m2142f().m2155a(str, null);
    }
}
