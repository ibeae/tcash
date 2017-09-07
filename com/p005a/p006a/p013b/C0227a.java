package com.p005a.p006a.p013b;

import android.content.Context;
import android.graphics.Bitmap;
import com.p005a.p006a.p007a.p008a.C0200b;
import com.p005a.p006a.p007a.p008a.p009a.C0203a;
import com.p005a.p006a.p007a.p008a.p009a.C0204b;
import com.p005a.p006a.p007a.p008a.p009a.C0205c;
import com.p005a.p006a.p007a.p008a.p010b.C0206a;
import com.p005a.p006a.p007a.p008a.p010b.C0207b;
import com.p005a.p006a.p007a.p011b.C0209a;
import com.p005a.p006a.p007a.p011b.p012a.C0211b;
import com.p005a.p006a.p013b.p014a.C0225d;
import com.p005a.p006a.p013b.p014a.p015a.C0216c;
import com.p005a.p006a.p013b.p016b.C0230b;
import com.p005a.p006a.p013b.p016b.C0231a;
import com.p005a.p006a.p013b.p017c.C0233a;
import com.p005a.p006a.p013b.p017c.C0234b;
import com.p005a.p006a.p013b.p018d.C0238b;
import com.p005a.p006a.p013b.p018d.C0239a;
import com.p005a.p006a.p020c.C0246b;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class C0227a {

    private static class C0212a implements ThreadFactory {
        private static final AtomicInteger f290a = new AtomicInteger(1);
        private final ThreadGroup f291b;
        private final AtomicInteger f292c = new AtomicInteger(1);
        private final String f293d;
        private final int f294e;

        C0212a(int i) {
            this.f294e = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.f291b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f293d = "uil-pool-" + f290a.getAndIncrement() + "-thread-";
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f291b, runnable, this.f293d + this.f292c.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f294e);
            return thread;
        }
    }

    public static C0206a m743a() {
        return new C0207b();
    }

    public static C0200b m744a(Context context, C0206a c0206a, int i, int i2) {
        return i > 0 ? new C0204b(C0246b.m808b(context), c0206a, i) : i2 > 0 ? new C0203a(C0246b.m808b(context), c0206a, i2) : new C0205c(C0246b.m806a(context), c0206a);
    }

    public static C0200b m745a(File file) {
        File file2 = new File(file, "uil-images");
        if (file2.exists() || file2.mkdir()) {
            file = file2;
        }
        return new C0204b(file, 2097152);
    }

    public static C0209a<String, Bitmap> m746a(int i) {
        if (i == 0) {
            i = (int) (Runtime.getRuntime().maxMemory() / 8);
        }
        return new C0211b(i);
    }

    public static C0230b m747a(boolean z) {
        return new C0231a(z);
    }

    public static C0238b m748a(Context context) {
        return new C0239a(context);
    }

    public static Executor m749a(int i, int i2, C0225d c0225d) {
        return new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, (c0225d == C0225d.LIFO ? 1 : null) != null ? new C0216c() : new LinkedBlockingQueue(), C0227a.m751b(i2));
    }

    public static C0233a m750b() {
        return new C0234b();
    }

    private static ThreadFactory m751b(int i) {
        return new C0212a(i);
    }
}
