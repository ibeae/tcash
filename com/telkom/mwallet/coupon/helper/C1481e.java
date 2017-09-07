package com.telkom.mwallet.coupon.helper;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class C1481e {
    private final ScheduledExecutorService f3499a = Executors.newSingleThreadScheduledExecutor(new C1479a());
    private final Activity f3500b;
    private ScheduledFuture<?> f3501c = null;
    private final BroadcastReceiver f3502d = new C1480b();
    private boolean f3503e;

    private static final class C1479a implements ThreadFactory {
        private C1479a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }

    private final class C1480b extends BroadcastReceiver {
        final /* synthetic */ C1481e f3498a;

        private C1480b(C1481e c1481e) {
            this.f3498a = c1481e;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction()) && intent.getIntExtra("plugged", -1) > 0) {
                this.f3498a.m5591e();
            }
        }
    }

    public C1481e(Activity activity) {
        this.f3500b = activity;
        m5592a();
    }

    private void m5591e() {
        ScheduledFuture scheduledFuture = this.f3501c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f3501c = null;
        }
    }

    public void m5592a() {
        m5591e();
        if (!this.f3499a.isShutdown()) {
            try {
                this.f3501c = this.f3499a.schedule(new C1477d(this.f3500b), 300, TimeUnit.SECONDS);
            } catch (RejectedExecutionException e) {
            }
        }
    }

    public void m5593b() {
        m5591e();
        if (this.f3503e) {
            this.f3500b.unregisterReceiver(this.f3502d);
            this.f3503e = false;
        }
    }

    public void m5594c() {
        if (!this.f3503e) {
            this.f3500b.registerReceiver(this.f3502d, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.f3503e = true;
        }
        m5592a();
    }

    public void m5595d() {
        m5591e();
        this.f3499a.shutdown();
    }
}
