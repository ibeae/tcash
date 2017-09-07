package com.p005a.p006a.p020c;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

public final class C0246b {
    public static File m806a(Context context) {
        return C0246b.m807a(context, true);
    }

    public static File m807a(Context context, boolean z) {
        File file = null;
        if (z && "mounted".equals(Environment.getExternalStorageState()) && C0246b.m810d(context)) {
            file = C0246b.m809c(context);
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file != null) {
            return file;
        }
        C0245a.m805c("Can't define system cache directory! '%s' will be used.", "/data/data/" + context.getPackageName() + "/cache/");
        return new File("/data/data/" + context.getPackageName() + "/cache/");
    }

    public static File m808b(Context context) {
        File a = C0246b.m806a(context);
        File file = new File(a, "uil-images");
        return (file.exists() || file.mkdir()) ? file : a;
    }

    private static File m809c(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists()) {
            return file;
        }
        if (file.mkdirs()) {
            try {
                new File(file, ".nomedia").createNewFile();
                return file;
            } catch (IOException e) {
                C0245a.m804b("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
                return file;
            }
        }
        C0245a.m805c("Unable to create external cache directory", new Object[0]);
        return null;
    }

    private static boolean m810d(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
