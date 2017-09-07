package com.telkom.mwallet.p064a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1351e {
    static String f2914a = "RootUtil";

    public static boolean m4935a(Context context) {
        C1351e c1351e = new C1351e();
        if (c1351e.m4936a() || c1351e.m4937b() || c1351e.m4939c() || c1351e.m4938b(context) || c1351e.m4940d()) {
            return true;
        }
        Log.d(f2914a, "divice not rooted...");
        return false;
    }

    public boolean m4936a() {
        Log.d(f2914a, "checked android os build tag =======");
        String str = Build.TAGS;
        Log.d(f2914a, "build tag: " + str);
        return str != null && str.contains("test-keys");
    }

    public boolean m4937b() {
        Log.d(f2914a, "checked file path =======");
        String[] strArr = new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/su", "/system/sd/xbin/su", "/system/bin/su", "/system/bin/failsafe/su", "/system/bin/.ext", "/system/xbin/su", "/system/xbin/.ext", "/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/data/data/com.noshufou.android.su"};
        String str = Environment.getExternalStorageDirectory() + "";
        String[] strArr2 = new String[(strArr.length * 2)];
        int i = 0;
        while (i < strArr2.length) {
            int i2;
            if (i < strArr.length) {
                i2 = 1;
            } else {
                boolean z = false;
            }
            strArr2[i] = i2 != 0 ? new String(strArr[i]) : new String(str + strArr[i - strArr.length]);
            try {
                File file = new File(strArr2[i]);
                if (file == null || !file.exists()) {
                    Log.d(f2914a, "not founded: " + strArr2[i]);
                    i++;
                } else {
                    Log.d(f2914a, "founded path: " + strArr2[i]);
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public boolean m4938b(Context context) {
        Log.d(f2914a, "checked installed package =======");
        String[] strArr = new String[]{"com.noshufou.android.su", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.zachspong.temprootremovejb", "com.ramdroid.appquarantine"};
        PackageManager packageManager = context.getPackageManager();
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                packageManager.getPackageInfo(str, 128);
                Log.d(f2914a, "founded: " + str);
                return true;
            } catch (Exception e) {
                Log.d(f2914a, "not founded: " + str);
                i++;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m4939c() {
        /*
        r7 = this;
        r0 = 1;
        r1 = 0;
        r2 = f2914a;
        r3 = "checked command permission =======";
        android.util.Log.d(r2, r3);
        r2 = 0;
        r3 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x0027, all -> 0x0037 }
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0027, all -> 0x0037 }
        r5 = 0;
        r6 = "su";
        r4[r5] = r6;	 Catch:{ Exception -> 0x0027, all -> 0x0037 }
        r2 = r3.exec(r4);	 Catch:{ Exception -> 0x0027, all -> 0x0037 }
        r3 = f2914a;	 Catch:{ Exception -> 0x0042, all -> 0x0037 }
        r4 = "superuser permission enabled";
        android.util.Log.d(r3, r4);	 Catch:{ Exception -> 0x0042, all -> 0x0037 }
        if (r2 == 0) goto L_0x0026;
    L_0x0023:
        r2.destroy();
    L_0x0026:
        return r0;
    L_0x0027:
        r0 = move-exception;
        r0 = r2;
    L_0x0029:
        r2 = f2914a;	 Catch:{ all -> 0x003e }
        r3 = "superuser permission disabled";
        android.util.Log.d(r2, r3);	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x0035;
    L_0x0032:
        r0.destroy();
    L_0x0035:
        r0 = r1;
        goto L_0x0026;
    L_0x0037:
        r0 = move-exception;
    L_0x0038:
        if (r2 == 0) goto L_0x003d;
    L_0x003a:
        r2.destroy();
    L_0x003d:
        throw r0;
    L_0x003e:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x0038;
    L_0x0042:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.telkom.mwallet.a.e.c():boolean");
    }

    public boolean m4940d() {
        Process exec;
        BufferedReader bufferedReader;
        Throwable th;
        Process process = null;
        Log.d(f2914a, "checked default property =======");
        BufferedReader bufferedReader2;
        try {
            exec = Runtime.getRuntime().exec(new String[]{"cat", "/default.prop"});
            try {
                exec.waitFor();
                bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            } catch (Exception e) {
                bufferedReader = null;
                process = exec;
                if (process != null) {
                    process.destroy();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = null;
                if (exec != null) {
                    exec.destroy();
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                    }
                }
                throw th;
            }
            try {
                String str = "";
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    Log.d(f2914a, "property: " + readLine);
                    stringBuilder.append(readLine);
                }
                str = stringBuilder.toString();
                if (str.contains("ro.secure=0")) {
                    Log.d(f2914a, "founded: ro.secure=0");
                    if (exec != null) {
                        exec.destroy();
                    }
                    if (bufferedReader2 == null) {
                        return true;
                    }
                    try {
                        bufferedReader2.close();
                        return true;
                    } catch (IOException e4) {
                        return true;
                    }
                } else if (str.contains("ro.debuggable=1")) {
                    Log.d(f2914a, "founded: ro.debuggable=1");
                    if (exec != null) {
                        exec.destroy();
                    }
                    if (bufferedReader2 == null) {
                        return true;
                    }
                    try {
                        bufferedReader2.close();
                        return true;
                    } catch (IOException e5) {
                        return true;
                    }
                } else if (str.contains("service.adb.root=1")) {
                    Log.d(f2914a, "founded: service.adb.root=1");
                    if (exec != null) {
                        exec.destroy();
                    }
                    if (bufferedReader2 == null) {
                        return true;
                    }
                    try {
                        bufferedReader2.close();
                        return true;
                    } catch (IOException e6) {
                        return true;
                    }
                } else {
                    if (exec != null) {
                        exec.destroy();
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e7) {
                        }
                    }
                    return false;
                }
            } catch (Exception e8) {
                bufferedReader = bufferedReader2;
                process = exec;
                if (process != null) {
                    process.destroy();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (exec != null) {
                    exec.destroy();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                throw th;
            }
        } catch (Exception e9) {
            bufferedReader = null;
            if (process != null) {
                process.destroy();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader2 = null;
            exec = null;
            if (exec != null) {
                exec.destroy();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }
}
