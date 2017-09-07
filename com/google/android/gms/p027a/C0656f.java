package com.google.android.gms.p027a;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.C0672e;
import com.google.android.gms.internal.ek;

public abstract class C0656f<T> {
    private final String f810a;
    private T f811b;

    public static class C0655a extends Exception {
        public C0655a(String str) {
            super(str);
        }
    }

    protected C0656f(String str) {
        this.f810a = str;
    }

    protected final T m1386a(Context context) {
        if (this.f811b == null) {
            ek.m2332a((Object) context);
            Context c = C0672e.m1476c(context);
            if (c == null) {
                throw new C0655a("Could not get remote context.");
            }
            try {
                this.f811b = mo1107a((IBinder) c.getClassLoader().loadClass(this.f810a).newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0655a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0655a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0655a("Could not access creator.");
            }
        }
        return this.f811b;
    }

    protected abstract T mo1107a(IBinder iBinder);
}
