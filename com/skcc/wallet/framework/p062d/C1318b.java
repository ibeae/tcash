package com.skcc.wallet.framework.p062d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.C1302b;
import com.skcc.wallet.framework.api.http.C1257o;
import com.skcc.wallet.framework.api.http.C1257o.C1256a;
import com.skcc.wallet.framework.p058a.C1223b;
import java.lang.Thread.State;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TimerTask;
import java.util.Vector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class C1318b {
    Thread f2825a = new Thread(new C13131(this));
    TimerTask f2826b;
    private Hashtable<String, String> f2827c;
    private C1223b f2828d;
    private C1302b f2829e;
    private Options f2830f;
    private Hashtable<String, Bitmap> f2831g;
    private Vector<C1317a> f2832h = new Vector();
    private final HostnameVerifier f2833i = new C13164(this);

    class C13131 implements Runnable {
        final /* synthetic */ C1318b f2814a;

        C13131(C1318b c1318b) {
            this.f2814a = c1318b;
        }

        public void run() {
            C1317a c1317a = null;
            while (!Thread.interrupted()) {
                try {
                    C1216a.m4519a("CouponImageLoader", ">>>>> thread wait for image works");
                    if (this.f2814a.f2832h.isEmpty()) {
                        C1216a.m4519a("CouponImageLoader", "viewInfoMap.isEmpty() :: " + this.f2814a.f2832h.isEmpty() + ", cnt :: " + this.f2814a.f2832h.size() + ", running info :: " + c1317a);
                        this.f2814a.m4793a(c1317a);
                    }
                    this.f2814a.m4801c();
                    if (this.f2814a.f2832h.isEmpty()) {
                        c1317a = null;
                    } else {
                        c1317a = this.f2814a.m4803d();
                        C1216a.m4519a("CouponImageLoader", ">>>>> thread start image load");
                        if (null == null) {
                            this.f2814a.f2831g.get(c1317a.f2822a);
                        }
                        Bitmap a = null == null ? this.f2814a.m4791a(c1317a.f2822a) : null;
                        if (a == null) {
                            this.f2814a.m4802c(c1317a);
                            C1216a.m4519a("CouponImageLoader", "downloadFile>>" + c1317a.f2822a);
                        } else {
                            this.f2814a.m4794a(c1317a, a);
                        }
                    }
                    if (this.f2814a.f2832h.isEmpty()) {
                        C1216a.m4519a("CouponImageLoader", "viewInfoMap.isEmpty() :: " + this.f2814a.f2832h.isEmpty() + ", cnt :: " + this.f2814a.f2832h.size() + ", running info :: " + c1317a);
                        this.f2814a.m4793a(c1317a);
                    }
                } catch (InterruptedException e) {
                    if (this.f2814a.f2826b != null) {
                        this.f2814a.f2826b.cancel();
                    }
                    this.f2814a.f2826b = null;
                }
            }
            C1216a.m4519a("CouponImageLoader", ">>>>> thread exit");
        }
    }

    class C13164 implements HostnameVerifier {
        final /* synthetic */ C1318b f2821a;

        C13164(C1318b c1318b) {
            this.f2821a = c1318b;
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    class C1317a {
        String f2822a;
        ImageView f2823b;
        final /* synthetic */ C1318b f2824c;

        C1317a(C1318b c1318b) {
            this.f2824c = c1318b;
        }
    }

    public C1318b(Context context) {
        this.f2828d = new C1223b(context);
        this.f2827c = new Hashtable();
        this.f2831g = new Hashtable();
        this.f2830f = new Options();
        this.f2830f.inPurgeable = true;
        this.f2829e = (C1302b) context;
        this.f2825a.setPriority(4);
    }

    private Bitmap m4791a(String str) {
        byte[] a = this.f2828d.m4531a(str);
        return a == null ? null : BitmapFactory.decodeByteArray(a, 0, a.length, this.f2830f);
    }

    private void m4793a(C1317a c1317a) {
        C1216a.m4519a("CouponImageLoader", "notiFinish>>");
        if (this.f2826b != null) {
            this.f2826b.cancel();
        }
        this.f2826b = null;
        C1216a.m4519a("CouponImageLoader", "notiFinish>> task.cancel  ");
    }

    private void m4794a(final C1317a c1317a, final Bitmap bitmap) {
        this.f2831g.put(c1317a.f2822a, bitmap);
        String str = (String) c1317a.f2823b.getTag();
        C1216a.m4519a("CouponImageLoader", ">>>>> bitmap :: " + c1317a.f2822a + ",  tag:" + str);
        if (str == null || str.equals(c1317a.f2822a)) {
            ((Activity) c1317a.f2823b.getContext()).runOnUiThread(new Runnable(this) {
                final /* synthetic */ C1318b f2817c;

                public void run() {
                    c1317a.f2823b.setImageBitmap(bitmap);
                    C1216a.m4519a("CouponImageLoader", ">>>>> bitmap displayed :: " + c1317a.f2822a);
                }
            });
        }
    }

    private void m4797b(C1317a c1317a) {
        C1216a.m4519a("CouponImageLoader", "put >> image:" + c1317a.f2822a + ",imageview:" + c1317a.f2823b);
        synchronized (this.f2832h) {
            this.f2832h.add(c1317a);
            this.f2832h.notifyAll();
        }
        if (this.f2825a != null && this.f2825a.getState() == State.NEW) {
            this.f2825a.start();
        }
    }

    private void m4801c() {
        synchronized (this.f2832h) {
            while (this.f2832h.isEmpty()) {
                this.f2832h.wait();
            }
        }
    }

    private void m4802c(final C1317a c1317a) {
        if (this.f2829e != null && this.f2829e.m4744d() != null && this.f2829e.m4744d().mo1466d()) {
            if (c1317a == null || c1317a.f2822a.length() < 9) {
                C1216a.m4519a("CouponImageLoader", "Invalid image Url. url = ");
                return;
            }
            C1216a.m4519a("CouponImageLoader", "Start to download image from server. url = " + c1317a);
            final String replace = c1317a.f2822a.replace("\\", "/");
            new C1257o(this.f2829e.m4744d()).m4613a(replace, null, this.f2829e.m4744d().mo1464a(), new C1256a(this) {
                final /* synthetic */ C1318b f2820c;

                public void mo1474a(int i) {
                }

                public void mo1475a(String str) {
                    C1216a.m4522b("CouponImageLoader", "startDownload>> Exception occurred : " + str);
                }

                public void mo1476a(byte[] bArr) {
                    this.f2820c.f2828d.m4530a(replace, bArr);
                    this.f2820c.m4794a(c1317a, BitmapFactory.decodeByteArray(bArr, 0, bArr.length, this.f2820c.f2830f));
                }
            });
        }
    }

    private C1317a m4803d() {
        C1317a c1317a;
        synchronized (this.f2832h) {
            c1317a = (C1317a) this.f2832h.remove(this.f2832h.size() - 1);
        }
        return c1317a;
    }

    public void m4807a() {
        Enumeration elements = this.f2831g.elements();
        while (elements.hasMoreElements()) {
            Bitmap bitmap = (Bitmap) elements.nextElement();
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        if (this.f2825a != null && this.f2825a.isAlive()) {
            this.f2825a.interrupt();
        }
        this.f2825a = null;
        this.f2827c.clear();
        this.f2831g.clear();
        this.f2829e = null;
    }

    public void m4808a(String str, ImageView imageView) {
        C1216a.m4519a("CouponImageLoader", "displayImage>>" + str);
        if (str != null) {
            Bitmap bitmap = (Bitmap) this.f2831g.get(str);
            if (bitmap == null) {
                bitmap = m4791a(str);
            }
            if (bitmap != null) {
                this.f2831g.put(str, bitmap);
                imageView.setImageBitmap(bitmap);
                return;
            }
            imageView.setImageDrawable(null);
            C1317a c1317a = new C1317a(this);
            c1317a.f2822a = str;
            c1317a.f2823b = imageView;
            m4797b(c1317a);
        }
    }

    public void m4809b() {
        this.f2828d.m4529a();
    }
}
