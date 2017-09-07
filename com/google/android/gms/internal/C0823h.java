package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.C0672e;
import com.google.android.gms.internal.C0815o.C0816a;
import com.google.android.gms.internal.C0833p.C0835a;
import com.google.android.gms.p027a.C0654d;
import com.google.android.gms.p027a.C0656f;

public final class C0823h extends C0656f<C0833p> {
    private static final C0823h f1643a = new C0823h();

    private C0823h() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static C0815o m2662a(Context context, al alVar, String str, as asVar) {
        if (C0672e.m1465a(context) == 0) {
            C0815o b = f1643a.m2663b(context, alVar, str, asVar);
            if (b != null) {
                return b;
            }
        }
        dq.m2112a("Using AdManager from the client jar.");
        return new ft(context, alVar, str, asVar, new ev(5089000, 5089000, true));
    }

    private C0815o m2663b(Context context, al alVar, String str, as asVar) {
        try {
            return C0816a.m2590a(((C0833p) m1386a(context)).mo1109a(C0654d.m1384a((Object) context), alVar, str, asVar, 5089000));
        } catch (Throwable e) {
            dq.m2118c("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            dq.m2118c("Could not create remote AdManager.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object mo1107a(IBinder iBinder) {
        return m2665b(iBinder);
    }

    protected C0833p m2665b(IBinder iBinder) {
        return C0835a.m2738a(iBinder);
    }
}
