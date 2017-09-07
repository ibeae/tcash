package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract class el extends ec {
    static boolean f1533d = false;
    private static Method f1534e;
    private static Method f1535f;
    private static Method f1536g;
    private static Method f1537h;
    private static Method f1538i;
    private static Method f1539j;
    private static Method f1540k;
    private static Method f1541l;
    private static String f1542m;
    private static long f1543n = 0;
    private static fo f1544o;

    static class C0792a extends Exception {
        public C0792a(Throwable th) {
            super(th);
        }
    }

    protected el(Context context, fl flVar, fn fnVar) {
        super(context, flVar, fnVar);
    }

    static String m2340a() {
        if (f1542m != null) {
            return f1542m;
        }
        throw new C0792a();
    }

    static String m2341a(Context context, fl flVar) {
        if (f1537h == null) {
            throw new C0792a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) f1537h.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return flVar.mo962a(byteBuffer.array(), true);
            }
            throw new C0792a();
        } catch (Throwable e) {
            throw new C0792a(e);
        } catch (Throwable e2) {
            throw new C0792a(e2);
        }
    }

    static ArrayList<Long> m2342a(MotionEvent motionEvent, DisplayMetrics displayMetrics) {
        if (f1538i == null || motionEvent == null) {
            throw new C0792a();
        }
        try {
            return (ArrayList) f1538i.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new C0792a(e);
        } catch (Throwable e2) {
            throw new C0792a(e2);
        }
    }

    protected static synchronized void m2343a(String str, Context context, fl flVar) {
        synchronized (el.class) {
            if (!f1533d) {
                try {
                    f1544o = new fo(flVar, null);
                    f1542m = str;
                    mo1014h(context);
                    f1543n = m2344b().longValue();
                    f1533d = true;
                } catch (C0792a e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
        }
    }

    static Long m2344b() {
        if (f1534e == null) {
            throw new C0792a();
        }
        try {
            return (Long) f1534e.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0792a(e);
        } catch (Throwable e2) {
            throw new C0792a(e2);
        }
    }

    static String m2345b(Context context, fl flVar) {
        if (f1540k == null) {
            throw new C0792a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) f1540k.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return flVar.mo962a(byteBuffer.array(), true);
            }
            throw new C0792a();
        } catch (Throwable e) {
            throw new C0792a(e);
        } catch (Throwable e2) {
            throw new C0792a(e2);
        }
    }

    private static String m2346b(byte[] bArr, String str) {
        try {
            return new String(f1544o.m2532a(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new C0792a(e);
        } catch (Throwable e2) {
            throw new C0792a(e2);
        }
    }

    static String m2347c() {
        if (f1536g == null) {
            throw new C0792a();
        }
        try {
            return (String) f1536g.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0792a(e);
        } catch (Throwable e2) {
            throw new C0792a(e2);
        }
    }

    static Long m2348d() {
        if (f1535f == null) {
            throw new C0792a();
        }
        try {
            return (Long) f1535f.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0792a(e);
        } catch (Throwable e2) {
            throw new C0792a(e2);
        }
    }

    static String m2349f(Context context) {
        if (f1539j == null) {
            throw new C0792a();
        }
        try {
            String str = (String) f1539j.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new C0792a();
        } catch (Throwable e) {
            throw new C0792a(e);
        } catch (Throwable e2) {
            throw new C0792a(e2);
        }
    }

    static ArrayList<Long> m2350g(Context context) {
        if (f1541l == null) {
            throw new C0792a();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) f1541l.invoke(null, new Object[]{context});
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            throw new C0792a();
        } catch (Throwable e) {
            throw new C0792a(e);
        } catch (Throwable e2) {
            throw new C0792a(e2);
        }
    }

    private static void mo1014h(Context context) {
        File file;
        File createTempFile;
        try {
            byte[] a = f1544o.m2531a(fq.m2537a());
            byte[] a2 = f1544o.m2532a(a, fq.m2538b());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new C0792a();
                }
            }
            file = cacheDir;
            createTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(a2, 0, a2.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(m2346b(a, fq.m2539c()));
            Class loadClass2 = dexClassLoader.loadClass(m2346b(a, fq.m2551o()));
            Class loadClass3 = dexClassLoader.loadClass(m2346b(a, fq.m2545i()));
            Class loadClass4 = dexClassLoader.loadClass(m2346b(a, fq.m2543g()));
            Class loadClass5 = dexClassLoader.loadClass(m2346b(a, fq.m2553q()));
            Class loadClass6 = dexClassLoader.loadClass(m2346b(a, fq.m2541e()));
            Class loadClass7 = dexClassLoader.loadClass(m2346b(a, fq.m2549m()));
            Class loadClass8 = dexClassLoader.loadClass(m2346b(a, fq.m2547k()));
            f1534e = loadClass.getMethod(m2346b(a, fq.m2540d()), new Class[0]);
            f1535f = loadClass2.getMethod(m2346b(a, fq.m2552p()), new Class[0]);
            f1536g = loadClass3.getMethod(m2346b(a, fq.m2546j()), new Class[0]);
            f1537h = loadClass4.getMethod(m2346b(a, fq.m2544h()), new Class[]{Context.class});
            f1538i = loadClass5.getMethod(m2346b(a, fq.m2554r()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            f1539j = loadClass6.getMethod(m2346b(a, fq.m2542f()), new Class[]{Context.class});
            f1540k = loadClass7.getMethod(m2346b(a, fq.m2550n()), new Class[]{Context.class});
            f1541l = loadClass8.getMethod(m2346b(a, fq.m2548l()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(file, name.replace(".jar", ".dex")).delete();
        } catch (Throwable e) {
            throw new C0792a(e);
        } catch (Throwable e2) {
            throw new C0792a(e2);
        } catch (Throwable e22) {
            throw new C0792a(e22);
        } catch (Throwable e222) {
            throw new C0792a(e222);
        } catch (Throwable e2222) {
            throw new C0792a(e2222);
        } catch (Throwable e22222) {
            throw new C0792a(e22222);
        } catch (Throwable th) {
            String name2 = createTempFile.getName();
            createTempFile.delete();
            new File(file, name2.replace(".jar", ".dex")).delete();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void mo1011c(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 1;
        r1 = m2347c();	 Catch:{ a -> 0x0059, IOException -> 0x004f }
        r6.m2204a(r0, r1);	 Catch:{ a -> 0x0059, IOException -> 0x004f }
    L_0x0008:
        r0 = 2;
        r1 = m2340a();	 Catch:{ a -> 0x0057, IOException -> 0x004f }
        r6.m2204a(r0, r1);	 Catch:{ a -> 0x0057, IOException -> 0x004f }
    L_0x0010:
        r0 = 25;
        r1 = m2344b();	 Catch:{ a -> 0x0055, IOException -> 0x004f }
        r2 = r1.longValue();	 Catch:{ a -> 0x0055, IOException -> 0x004f }
        r6.m2203a(r0, r2);	 Catch:{ a -> 0x0055, IOException -> 0x004f }
    L_0x001d:
        r1 = m2350g(r7);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r2 = 31;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r4 = r0.longValue();	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r6.m2203a(r2, r4);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r2 = 32;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r0 = r0.longValue();	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r6.m2203a(r2, r0);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
    L_0x0041:
        r0 = 33;
        r1 = m2348d();	 Catch:{ a -> 0x0051, IOException -> 0x004f }
        r2 = r1.longValue();	 Catch:{ a -> 0x0051, IOException -> 0x004f }
        r6.m2203a(r0, r2);	 Catch:{ a -> 0x0051, IOException -> 0x004f }
    L_0x004e:
        return;
    L_0x004f:
        r0 = move-exception;
        goto L_0x004e;
    L_0x0051:
        r0 = move-exception;
        goto L_0x004e;
    L_0x0053:
        r0 = move-exception;
        goto L_0x0041;
    L_0x0055:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0057:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0059:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.el.c(android.content.Context):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void mo1012e(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 2;
        r1 = m2340a();	 Catch:{ a -> 0x0097, IOException -> 0x008a }
        r6.m2204a(r0, r1);	 Catch:{ a -> 0x0097, IOException -> 0x008a }
    L_0x0008:
        r0 = 1;
        r1 = m2347c();	 Catch:{ a -> 0x0094, IOException -> 0x008a }
        r6.m2204a(r0, r1);	 Catch:{ a -> 0x0094, IOException -> 0x008a }
    L_0x0010:
        r0 = m2344b();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = 25;
        r6.m2203a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = f1543n;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0034;
    L_0x0025:
        r2 = 17;
        r4 = f1543n;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0 - r4;
        r6.m2203a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = 23;
        r2 = f1543n;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r6.m2203a(r0, r2);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
    L_0x0034:
        r0 = r6.a;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = r6.b;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = m2342a(r0, r1);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 14;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r4 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2203a(r2, r4);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 15;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r4 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2203a(r2, r4);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r1.size();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 3;
        if (r0 < r2) goto L_0x0073;
    L_0x0063:
        r2 = 16;
        r0 = 2;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2203a(r2, r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
    L_0x0073:
        r0 = 27;
        r1 = r6.c;	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r1 = m2341a(r7, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r6.m2204a(r0, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
    L_0x007e:
        r0 = 29;
        r1 = r6.c;	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r1 = m2345b(r7, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r6.m2204a(r0, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
    L_0x0089:
        return;
    L_0x008a:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008c:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008e:
        r0 = move-exception;
        goto L_0x007e;
    L_0x0090:
        r0 = move-exception;
        goto L_0x0073;
    L_0x0092:
        r0 = move-exception;
        goto L_0x0034;
    L_0x0094:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0097:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.el.e(android.content.Context):void");
    }
}
