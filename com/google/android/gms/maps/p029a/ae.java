package com.google.android.gms.maps.p029a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C0666c;
import com.google.android.gms.common.C0672e;
import com.google.android.gms.internal.ek;
import com.google.android.gms.maps.model.C0993l;
import com.google.android.gms.maps.p029a.C0899m.C0901a;
import com.google.android.gms.p027a.C0654d;

public class ae {
    private static Context f1851a;
    private static C0899m f1852b;

    public static C0899m m2887a(Context context) {
        ek.m2332a((Object) context);
        if (f1852b != null) {
            return f1852b;
        }
        ae.m2892b(context);
        f1852b = ae.m2893c(context);
        try {
            f1852b.mo1255a(C0654d.m1384a(ae.m2894d(context).getResources()), 5089000);
            return f1852b;
        } catch (RemoteException e) {
            throw new C0993l(e);
        }
    }

    private static <T> T m2888a(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static <T> T m2889a(ClassLoader classLoader, String str) {
        try {
            return ae.m2888a(((ClassLoader) ek.m2332a((Object) classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    private static boolean m2890a() {
        return false;
    }

    private static Class<?> m2891b() {
        try {
            return VERSION.SDK_INT < 15 ? Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6") : Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static void m2892b(Context context) {
        int a = C0672e.m1465a(context);
        switch (a) {
            case 0:
                return;
            default:
                throw new C0666c(a);
        }
    }

    private static C0899m m2893c(Context context) {
        if (ae.m2890a()) {
            Log.i(ae.class.getSimpleName(), "Making Creator statically");
            return (C0899m) ae.m2888a(ae.m2891b());
        }
        Log.i(ae.class.getSimpleName(), "Making Creator dynamically");
        return C0901a.m3176a((IBinder) ae.m2889a(ae.m2894d(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    private static Context m2894d(Context context) {
        if (f1851a == null) {
            if (ae.m2890a()) {
                f1851a = context.getApplicationContext();
            } else {
                f1851a = C0672e.m1476c(context);
            }
        }
        return f1851a;
    }
}
