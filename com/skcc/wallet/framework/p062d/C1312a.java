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
import com.skcc.wallet.framework.p058a.C1222a;
import java.lang.Thread.State;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TimerTask;
import java.util.Vector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class C1312a {
    Thread f2805a = new Thread(new C13071(this));
    TimerTask f2806b;
    private Hashtable<String, String> f2807c;
    private C1222a f2808d;
    private C1302b f2809e;
    private Options f2810f;
    private Hashtable<String, Bitmap> f2811g;
    private Vector<C1311a> f2812h = new Vector();
    private final HostnameVerifier f2813i = new C13104(this);

    class C13071 implements Runnable {
        final /* synthetic */ C1312a f2794a;

        C13071(C1312a c1312a) {
            this.f2794a = c1312a;
        }

        public void run() {
            C1311a c1311a = null;
            while (!Thread.interrupted()) {
                try {
                    C1216a.m4519a("CardImageLoader", ">>>>> thread wait for image works");
                    if (this.f2794a.f2812h.isEmpty()) {
                        C1216a.m4519a("CardImageLoader", "viewInfoMap.isEmpty() :: " + this.f2794a.f2812h.isEmpty() + ", cnt :: " + this.f2794a.f2812h.size() + ", running info :: " + c1311a);
                        this.f2794a.m4771a(c1311a);
                    }
                    this.f2794a.m4775b();
                    if (this.f2794a.f2812h.isEmpty()) {
                        c1311a = null;
                    } else {
                        c1311a = this.f2794a.m4779c();
                        C1216a.m4519a("CardImageLoader", ">>>>> thread start image load");
                        if (null == null) {
                            this.f2794a.f2811g.get(c1311a.f2802a);
                        }
                        Bitmap a = null == null ? this.f2794a.m4769a(c1311a.f2802a) : null;
                        if (a == null) {
                            this.f2794a.m4781c(c1311a);
                            C1216a.m4519a("CardImageLoader", "downloadFile>>" + c1311a.f2802a);
                        } else {
                            this.f2794a.m4772a(c1311a, a);
                        }
                    }
                    if (this.f2794a.f2812h.isEmpty()) {
                        C1216a.m4519a("CardImageLoader", "viewInfoMap.isEmpty() :: " + this.f2794a.f2812h.isEmpty() + ", cnt :: " + this.f2794a.f2812h.size() + ", running info :: " + c1311a);
                        this.f2794a.m4771a(c1311a);
                    }
                } catch (InterruptedException e) {
                    if (this.f2794a.f2806b != null) {
                        this.f2794a.f2806b.cancel();
                    }
                    this.f2794a.f2806b = null;
                }
            }
            C1216a.m4519a("CardImageLoader", ">>>>> thread exit");
        }
    }

    class C13104 implements HostnameVerifier {
        final /* synthetic */ C1312a f2801a;

        C13104(C1312a c1312a) {
            this.f2801a = c1312a;
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    class C1311a {
        String f2802a;
        ImageView f2803b;
        final /* synthetic */ C1312a f2804c;

        C1311a(C1312a c1312a) {
            this.f2804c = c1312a;
        }
    }

    public C1312a(Context context) {
        this.f2808d = new C1222a(context);
        this.f2807c = new Hashtable();
        this.f2811g = new Hashtable();
        this.f2810f = new Options();
        this.f2810f.inPurgeable = true;
        this.f2809e = (C1302b) context;
        this.f2805a.setPriority(4);
    }

    private Bitmap m4769a(String str) {
        byte[] a = this.f2808d.m4527a(str);
        return a == null ? null : BitmapFactory.decodeByteArray(a, 0, a.length, this.f2810f);
    }

    private void m4771a(C1311a c1311a) {
        C1216a.m4519a("CardImageLoader", "notiFinish>>");
        if (this.f2806b != null) {
            this.f2806b.cancel();
        }
        this.f2806b = null;
        C1216a.m4519a("CardImageLoader", "notiFinish>> task.cancel  ");
    }

    private void m4772a(final C1311a c1311a, final Bitmap bitmap) {
        this.f2811g.put(c1311a.f2802a, bitmap);
        String str = (String) c1311a.f2803b.getTag();
        C1216a.m4519a("CardImageLoader", ">>>>> bitmap :: " + c1311a.f2802a + ",  tag:" + str);
        if (str == null || str.equals(c1311a.f2802a)) {
            ((Activity) c1311a.f2803b.getContext()).runOnUiThread(new Runnable(this) {
                final /* synthetic */ C1312a f2797c;

                public void run() {
                    c1311a.f2803b.setImageBitmap(bitmap);
                    c1311a.f2803b.setVisibility(0);
                    C1216a.m4519a("CardImageLoader", ">>>>> bitmap displayed :: " + c1311a.f2802a);
                }
            });
        }
    }

    private void m4775b() {
        synchronized (this.f2812h) {
            while (this.f2812h.isEmpty()) {
                this.f2812h.wait();
            }
        }
    }

    private void m4776b(C1311a c1311a) {
        C1216a.m4519a("CardImageLoader", "put >> image:" + c1311a.f2802a + ",imageview:" + c1311a.f2803b);
        synchronized (this.f2812h) {
            this.f2812h.add(c1311a);
            this.f2812h.notifyAll();
        }
        if (this.f2805a != null && this.f2805a.getState() == State.NEW) {
            this.f2805a.start();
        }
    }

    private C1311a m4779c() {
        C1311a c1311a;
        synchronized (this.f2812h) {
            c1311a = (C1311a) this.f2812h.remove(this.f2812h.size() - 1);
        }
        return c1311a;
    }

    private void m4781c(final C1311a c1311a) {
        if (this.f2809e != null && this.f2809e.m4744d() != null && this.f2809e.m4744d().mo1466d()) {
            if (c1311a == null || c1311a.f2802a.length() < 9) {
                C1216a.m4519a("CardImageLoader", "Invalid image Url. url = ");
                return;
            }
            C1216a.m4519a("CardImageLoader", "Start to download image from server. url = " + c1311a);
            final String replace = c1311a.f2802a.replace("\\", "/");
            new C1257o(this.f2809e.m4744d()).m4613a(replace, null, this.f2809e.m4744d().mo1464a(), new C1256a(this) {
                final /* synthetic */ C1312a f2800c;

                public void mo1474a(int i) {
                }

                public void mo1475a(String str) {
                    C1216a.m4522b("CardImageLoader", "startDownload>> Exception occurred : " + str);
                }

                public void mo1476a(byte[] bArr) {
                    this.f2800c.f2808d.m4526a(replace, bArr);
                    this.f2800c.m4772a(c1311a, BitmapFactory.decodeByteArray(bArr, 0, bArr.length, this.f2800c.f2810f));
                }
            });
        }
    }

    public void m4785a() {
        Enumeration elements = this.f2811g.elements();
        while (elements.hasMoreElements()) {
            Bitmap bitmap = (Bitmap) elements.nextElement();
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        if (this.f2805a != null && this.f2805a.isAlive()) {
            this.f2805a.interrupt();
        }
        this.f2805a = null;
        this.f2807c.clear();
        this.f2811g.clear();
        this.f2809e = null;
    }

    public void m4786a(String str, ImageView imageView) {
        C1216a.m4519a("CardImageLoader", "displayImage>>" + str);
        if (str != null) {
            Bitmap bitmap = (Bitmap) this.f2811g.get(str);
            if (bitmap == null) {
                bitmap = m4769a(str);
            }
            if (bitmap != null) {
                this.f2811g.put(str, bitmap);
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(0);
                return;
            }
            imageView.setImageDrawable(null);
            C1311a c1311a = new C1311a(this);
            c1311a.f2802a = str;
            c1311a.f2803b = imageView;
            m4776b(c1311a);
        }
    }
}
