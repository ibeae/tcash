package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class C0673g implements ServiceConnection {
    boolean f883a = false;
    private final BlockingQueue<IBinder> f884b = new LinkedBlockingQueue();

    public IBinder m1479a() {
        if (this.f883a) {
            throw new IllegalStateException();
        }
        this.f883a = true;
        return (IBinder) this.f884b.take();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f884b.put(iBinder);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
