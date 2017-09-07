package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.C0665b.C0660b;
import com.google.android.gms.common.C0665b.C0664a;
import com.google.android.gms.internal.cr.C0737a;
import com.google.android.gms.internal.ed.C0780d;

public class cn extends ed<cr> {
    final int f1188a;

    public cn(Context context, C0664a c0664a, C0660b c0660b, int i) {
        super(context, c0664a, c0660b, new String[0]);
        this.f1188a = i;
    }

    protected cr m1941a(IBinder iBinder) {
        return C0737a.m1961a(iBinder);
    }

    protected String mo957a() {
        return "com.google.android.gms.ads.service.START";
    }

    protected void mo958a(ei eiVar, C0780d c0780d) {
        eiVar.mo999g(c0780d, this.f1188a, m1936j().getPackageName(), new Bundle());
    }

    protected /* synthetic */ IInterface mo959b(IBinder iBinder) {
        return m1941a(iBinder);
    }

    protected String mo960b() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public cr m1946c() {
        return (cr) super.m1939m();
    }
}
