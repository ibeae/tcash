package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class dj {
    private static final ThreadFactory f1324a = new C07452();
    private static final ThreadPoolExecutor f1325b = new ThreadPoolExecutor(0, 10, 65, TimeUnit.SECONDS, new SynchronousQueue(true), f1324a);

    static class C07452 implements ThreadFactory {
        private final AtomicInteger f1323a = new AtomicInteger(1);

        C07452() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.f1323a.getAndIncrement());
        }
    }

    public static int m2057a() {
        return f1325b.getPoolSize();
    }

    public static void m2058a(final Runnable runnable) {
        try {
            f1325b.execute(new Runnable() {
                public void run() {
                    Process.setThreadPriority(10);
                    runnable.run();
                }
            });
        } catch (Throwable e) {
            dq.m2118c("Too many background threads already running. Aborting task.  Current pool size: " + m2057a(), e);
        }
    }
}
