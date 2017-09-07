package com.telkom.mwallet.coupon.p065a;

import android.os.IBinder;
import com.skcc.wallet.core.p057a.C1216a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class C1438d {
    private static final String f3302a = C1438d.class.getSimpleName();
    private static final Object f3303b = C1438d.m5445b();
    private static final Method f3304c = C1438d.m5442a(f3303b);

    static {
        if (f3303b == null) {
            C1216a.m4525e(f3302a, "This device does supports control of a flashlight");
        } else {
            C1216a.m4525e(f3302a, "This device does not support control of a flashlight");
        }
    }

    private C1438d() {
    }

    private static Class<?> m5439a(String str) {
        Class<?> cls = null;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException e) {
        } catch (Exception e2) {
            C1216a.m4520a(f3302a, "Unexpected error while finding class " + str, e2);
        }
        return cls;
    }

    private static Object m5440a(Method method, Object obj, Object... objArr) {
        Object obj2 = null;
        try {
            obj2 = method.invoke(obj, objArr);
        } catch (Exception e) {
            C1216a.m4520a(f3302a, "Unexpected error while invoking " + method, e);
        } catch (InvocationTargetException e2) {
            C1216a.m4521a(f3302a, "Unexpected error while invoking " + method, "" + e2.getCause());
        } catch (Exception e3) {
            C1216a.m4520a(f3302a, "Unexpected error while invoking " + method, e3);
        }
        return obj2;
    }

    private static Method m5441a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method = null;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
        } catch (Exception e2) {
            C1216a.m4520a(f3302a, "Unexpected error while finding method " + str, e2);
        }
        return method;
    }

    private static Method m5442a(Object obj) {
        if (obj == null) {
            return null;
        }
        return C1438d.m5441a(obj.getClass(), "setFlashlightEnabled", Boolean.TYPE);
    }

    static void m5443a() {
        C1438d.m5444a(false);
    }

    private static void m5444a(boolean z) {
        if (f3303b != null) {
            C1438d.m5440a(f3304c, f3303b, Boolean.valueOf(z));
        }
    }

    private static Object m5445b() {
        Class a = C1438d.m5439a("android.os.ServiceManager");
        if (a == null) {
            return null;
        }
        Method a2 = C1438d.m5441a(a, "getService", String.class);
        if (a2 == null || C1438d.m5440a(a2, null, "hardware") == null) {
            return null;
        }
        Class a3 = C1438d.m5439a("android.os.IHardwareService$Stub");
        if (a3 == null) {
            return null;
        }
        Method a4 = C1438d.m5441a(a3, "asInterface", IBinder.class);
        if (a4 == null) {
            return null;
        }
        return C1438d.m5440a(a4, null, r1);
    }
}
