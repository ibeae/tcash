package com.skcc.wallet.framework.p062d;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.ImageView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.C1302b;
import com.skcc.wallet.framework.api.C1271q;
import com.skcc.wallet.framework.api.http.C1257o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.TimerTask;
import java.util.Vector;
import twitter4j.HttpResponseCode;

public class C1323c {
    Thread f2841a = new Thread(new C13201(this));
    C1271q f2842b = null;
    TimerTask f2843c;
    private Hashtable<String, String> f2844d = new Hashtable();
    private C1302b f2845e;
    private Hashtable<String, Bitmap> f2846f = new Hashtable();
    private Vector<C1322a> f2847g = new Vector();
    private File f2848h;

    class C13201 implements Runnable {
        final /* synthetic */ C1323c f2837a;

        C13201(C1323c c1323c) {
            this.f2837a = c1323c;
        }

        public void run() {
            C1322a c1322a = null;
            while (!Thread.interrupted()) {
                try {
                    C1216a.m4519a("ImageLoader", ">>>>> thread wait for image works");
                    if (this.f2837a.f2847g.isEmpty()) {
                        C1216a.m4519a("ImageLoader", "viewInfoMap.isEmpty() :: " + this.f2837a.f2847g.isEmpty() + ", cnt :: " + this.f2837a.f2847g.size() + ", running info :: " + c1322a);
                        this.f2837a.m4816a(c1322a);
                    }
                    this.f2837a.m4819b();
                    if (this.f2837a.f2847g.isEmpty()) {
                        c1322a = null;
                    } else {
                        Bitmap bitmap;
                        final C1322a c = this.f2837a.m4821c();
                        C1216a.m4519a("ImageLoader", ">>>>> thread start image load");
                        String str = (String) this.f2837a.f2844d.get(c.f2839a);
                        if (str != null) {
                            bitmap = (Bitmap) this.f2837a.f2846f.get(str);
                            C1216a.m4519a("ImageLoader", ">>>>> have such a bitmap image.");
                            if (bitmap == null) {
                                bitmap = this.f2837a.m4812a(new File(str));
                            }
                        } else {
                            bitmap = null;
                        }
                        if (bitmap == null) {
                            String a = this.f2837a.m4818b(c.f2839a);
                            str = a;
                            bitmap = this.f2837a.m4813a(c.f2839a, a);
                        }
                        if (bitmap != null) {
                            this.f2837a.f2844d.put(c.f2839a, str);
                            this.f2837a.f2846f.put(str, bitmap);
                            C1216a.m4519a("ImageLoader", ">>>>> bitmap :: info.imgUrl:" + c.f2839a + ", local:" + str + ", tag:" + c.f2840b.getTag());
                            str = c.f2840b.getTag() != null ? String.valueOf(c.f2840b.getTag()) : null;
                            if (str == null || str.equals(c.f2839a)) {
                                ((Activity) c.f2840b.getContext()).runOnUiThread(new Runnable(this) {
                                    final /* synthetic */ C13201 f2836c;

                                    public void run() {
                                        c.f2840b.setImageBitmap(bitmap);
                                        C1216a.m4519a("ImageLoader", ">>>>> bitmap displayed :: " + c.f2839a);
                                    }
                                });
                            }
                            c1322a = c;
                        } else {
                            C1216a.m4519a("ImageLoader", ">>>>> bitmap is null!!");
                            c1322a = c;
                        }
                    }
                    if (this.f2837a.f2847g.isEmpty()) {
                        C1216a.m4523c("ImageLoader", "viewInfoMap.isEmpty() :::: " + this.f2837a.f2847g.isEmpty() + ", cnt :: " + this.f2837a.f2847g.size() + ", running info :: " + c1322a);
                        this.f2837a.m4816a(c1322a);
                    }
                } catch (InterruptedException e) {
                    if (this.f2837a.f2842b != null) {
                        this.f2837a.f2842b.m4644a();
                        this.f2837a.f2842b = null;
                    }
                    if (this.f2837a.f2843c != null) {
                        this.f2837a.f2843c.cancel();
                    }
                    this.f2837a.f2843c = null;
                }
            }
            C1216a.m4519a("ImageLoader", ">>>>> thread exit");
        }
    }

    class C13212 implements Runnable {
        final /* synthetic */ C1323c f2838a;

        C13212(C1323c c1323c) {
            this.f2838a = c1323c;
        }

        public void run() {
            if (this.f2838a.f2842b != null) {
                C1216a.m4519a("ImageLoader", "notiFinish>> onFinishListener.onFinish()  ");
                this.f2838a.f2842b.m4644a();
                this.f2838a.f2842b = null;
            }
        }
    }

    class C1322a {
        String f2839a;
        ImageView f2840b;
    }

    public C1323c(Activity activity) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.f2848h = new File(activity.getFilesDir().getAbsolutePath() + "/img", "LazyList");
        } else {
            this.f2848h = activity.getCacheDir();
        }
        C1216a.m4519a("ImageLoader", "ImageLoader>> Path of imageDir :: " + this.f2848h.getAbsolutePath());
        this.f2845e = (C1302b) activity.getApplication();
        this.f2841a.setPriority(4);
    }

    private Bitmap m4812a(File file) {
        Bitmap bitmap = null;
        if (file.exists()) {
            Options options = new Options();
            options.inSampleSize = 1;
            try {
                bitmap = BitmapFactory.decodeStream(new FileInputStream(file), null, options);
            } catch (FileNotFoundException e) {
            }
        }
        return bitmap;
    }

    private Bitmap m4813a(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            return m4812a(file);
        }
        if (!this.f2845e.m4744d().mo1466d()) {
            return null;
        }
        C1216a.m4519a("ImageLoader", "Start to download image from server. url = " + str);
        return (new C1257o(this.f2845e.m4744d()).m4613a(str, str2, this.f2845e.m4744d().mo1464a(), null).m4565a() == HttpResponseCode.OK && new File(str2).exists()) ? m4812a(file) : null;
    }

    private void m4816a(C1322a c1322a) {
        C1216a.m4519a("ImageLoader", "notiFinish>>");
        ((Activity) c1322a.f2840b.getContext()).runOnUiThread(new C13212(this));
        if (this.f2843c != null) {
            this.f2843c.cancel();
        }
        this.f2843c = null;
        C1216a.m4519a("ImageLoader", "notiFinish>> task.cancel  ");
    }

    private String m4818b(String str) {
        return this.f2848h.getAbsolutePath() + File.separator + String.valueOf(str.hashCode());
    }

    private void m4819b() {
        synchronized (this.f2847g) {
            while (this.f2847g.isEmpty()) {
                this.f2847g.wait();
            }
        }
    }

    private C1322a m4821c() {
        C1322a c1322a;
        synchronized (this.f2847g) {
            c1322a = (C1322a) this.f2847g.remove(this.f2847g.size() - 1);
        }
        return c1322a;
    }

    public File m4825a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String b = m4818b(str);
        return m4813a(str, b) != null ? new File(b) : null;
    }

    public void m4826a() {
        if (!this.f2848h.exists()) {
            this.f2848h.mkdirs();
        }
    }
}
