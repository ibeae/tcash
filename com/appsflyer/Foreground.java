package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class Foreground implements ActivityLifecycleCallbacks {
    public static final long CHECK_DELAY = 500;
    private static Foreground instance;
    private Runnable check;
    private boolean foreground = false;
    private Handler handler = new Handler();
    private List<Listener> listeners = new CopyOnWriteArrayList();
    private boolean paused = true;
    private Thread thread;

    public interface Listener {
        void onBecameBackground(Activity activity);

        void onBecameForeground(Activity activity);
    }

    public static Foreground get(Application application) {
        if (instance == null) {
            init(application);
        }
        return instance;
    }

    public static Foreground get(Context context) {
        if (instance != null) {
            return instance;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            init((Application) applicationContext);
        }
        throw new IllegalStateException("Foreground is not initialised and cannot obtain the Application object");
    }

    public static Foreground getInstance() {
        if (instance != null) {
            return instance;
        }
        throw new IllegalStateException("Foreground is not initialised - invoke at least once with parameter init/get");
    }

    public static Foreground init(Application application) {
        if (instance == null) {
            instance = new Foreground();
            if (VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(instance);
            }
        }
        return instance;
    }

    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    public boolean isBackground() {
        return !this.foreground;
    }

    public boolean isForeground() {
        return this.foreground;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(final Activity activity) {
        this.paused = true;
        if (this.check != null) {
            this.handler.removeCallbacks(this.check);
        }
        new Timer().schedule(new TimerTask() {
            public void run() {
                if (Foreground.this.foreground && Foreground.this.paused) {
                    Foreground.this.foreground = false;
                    for (Listener onBecameBackground : Foreground.this.listeners) {
                        try {
                            onBecameBackground.onBecameBackground(activity);
                        } catch (Throwable e) {
                            AFLogger.afLogE("Listener threw exception! ", e);
                        }
                    }
                }
            }
        }, 500);
    }

    public void onActivityResumed(Activity activity) {
        boolean z = false;
        this.paused = false;
        if (!this.foreground) {
            z = true;
        }
        this.foreground = true;
        if (this.check != null) {
            this.handler.removeCallbacks(this.check);
        }
        if (z) {
            for (Listener onBecameForeground : this.listeners) {
                try {
                    onBecameForeground.onBecameForeground(activity);
                } catch (Throwable e) {
                    AFLogger.afLogE("Listener threw exception! ", e);
                }
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }
}
