package com.p005a.p006a.p020c;

import android.util.Log;
import com.p005a.p006a.p013b.C0235c;

public final class C0245a {
    private static volatile boolean f429a = false;

    private static void m802a(int i, Throwable th, String str, Object... objArr) {
        if (!f429a) {
            String format = objArr.length > 0 ? String.format(str, objArr) : str;
            if (th != null) {
                if (format == null) {
                    format = th.getMessage();
                }
                String stackTraceString = Log.getStackTraceString(th);
                format = String.format("%1$s\n%2$s", new Object[]{format, stackTraceString});
            }
            Log.println(i, C0235c.f358a, format);
        }
    }

    public static void m803a(String str, Object... objArr) {
        C0245a.m802a(3, null, str, objArr);
    }

    public static void m804b(String str, Object... objArr) {
        C0245a.m802a(4, null, str, objArr);
    }

    public static void m805c(String str, Object... objArr) {
        C0245a.m802a(5, null, str, objArr);
    }
}
