package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.C0672e;
import com.google.android.gms.internal.cm.C0733a;
import com.google.android.gms.internal.cm.C0734b;

public final class cl {

    public interface C0731a {
        void mo948a(du duVar);
    }

    public static di m1895a(Context context, ds dsVar, C0731a c0731a) {
        return dsVar.f1365k.f1567e ? m1896b(context, dsVar, c0731a) : m1897c(context, dsVar, c0731a);
    }

    private static di m1896b(Context context, ds dsVar, C0731a c0731a) {
        dq.m2112a("Fetching ad response from local ad request service.");
        di c0733a = new C0733a(context, dsVar, c0731a);
        c0733a.m1741e();
        return c0733a;
    }

    private static di m1897c(Context context, ds dsVar, C0731a c0731a) {
        dq.m2112a("Fetching ad response from remote ad request service.");
        if (C0672e.m1465a(context) == 0) {
            return new C0734b(context, dsVar, c0731a);
        }
        dq.m2120e("Failed to connect to remote ad request service.");
        return null;
    }
}
