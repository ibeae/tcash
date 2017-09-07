package com.google.android.gms.internal;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public abstract class ec implements eb {
    protected MotionEvent f1490a;
    protected DisplayMetrics f1491b;
    protected fl f1492c;
    private fn f1493d;

    protected ec(Context context, fl flVar, fn fnVar) {
        this.f1492c = flVar;
        this.f1493d = fnVar;
        try {
            this.f1491b = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.f1491b = new DisplayMetrics();
            this.f1491b.density = 1.0f;
        }
    }

    private String m2196a(Context context, String str, boolean z, boolean z2) {
        try {
            byte[] b;
            synchronized (this) {
                m2197a();
                if (z) {
                    mo1012e(context);
                } else if (z2) {
                    mo1013d(context);
                } else {
                    mo1011c(context);
                }
                b = m2198b();
            }
            return b.length == 0 ? Integer.toString(5) : m2201a(b, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    private void m2197a() {
        this.f1493d.mo1064a();
    }

    private byte[] m2198b() {
        return this.f1493d.mo1067b();
    }

    public String mo966a(Context context) {
        return m2196a(context, null, false, false);
    }

    public String mo967a(Context context, String str) {
        return m2196a(context, str, true, false);
    }

    String m2201a(byte[] bArr, String str) {
        byte[] bArr2;
        if (bArr.length > 239) {
            m2197a();
            m2203a(20, 1);
            bArr = m2198b();
        }
        if (bArr.length < 239) {
            bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr2);
        bArr2 = ByteBuffer.allocate(NotificationCompat.FLAG_LOCAL_ONLY).put(instance.digest()).put(bArr2).array();
        byte[] bArr3 = new byte[NotificationCompat.FLAG_LOCAL_ONLY];
        new dx().m2180a(bArr2, bArr3);
        if (str != null && str.length() > 0) {
            m2206a(str, bArr3);
        }
        return this.f1492c.mo962a(bArr3, true);
    }

    public void mo968a(int i, int i2, int i3) {
        if (this.f1490a != null) {
            this.f1490a.recycle();
        }
        this.f1490a = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.f1491b.density, ((float) i2) * this.f1491b.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    protected void m2203a(int i, long j) {
        this.f1493d.mo1065a(i, j);
    }

    protected void m2204a(int i, String str) {
        this.f1493d.mo1066a(i, str);
    }

    public void mo969a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f1490a != null) {
                this.f1490a.recycle();
            }
            this.f1490a = MotionEvent.obtain(motionEvent);
        }
    }

    void m2206a(String str, byte[] bArr) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new fj(str.getBytes("UTF-8")).m2510a(bArr);
    }

    public String mo970b(Context context) {
        return m2196a(context, null, false, true);
    }

    protected abstract void mo1011c(Context context);

    protected abstract void mo1013d(Context context);

    protected abstract void mo1012e(Context context);
}
