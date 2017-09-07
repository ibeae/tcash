package com.telkom.mwallet.setting.twitter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.BaseAdapter;
import com.skcc.wallet.core.p057a.C1216a;
import java.io.File;
import java.util.Hashtable;
import java.util.Stack;

public class C1697c {
    Hashtable<String, Bitmap> f4274a;
    BaseAdapter f4275b;
    int f4276c = 0;
    Stack<C1696b> f4277d;
    Stack<String> f4278e;
    private File f4279f;

    private class C1695a extends AsyncTask<Object, Void, Bitmap> {
        String f4269a;
        final /* synthetic */ C1697c f4270b;

        private C1695a(C1697c c1697c) {
            this.f4270b = c1697c;
        }

        protected Bitmap m6378a(Object... objArr) {
            this.f4269a = (String) objArr[0];
            String str = (String) objArr[1];
            str = C1704e.m6415a(str, this.f4270b.m6381a(str), this.f4270b);
            C1216a.m4522b("getImage", "download 0" + str);
            if (str == null) {
                return null;
            }
            Bitmap a;
            C1216a.m4522b("getImage", "download 1" + new File(str).exists());
            synchronized (this.f4270b) {
                a = C1704e.m6414a(new File(str));
            }
            return a;
        }

        protected void m6379a(Bitmap bitmap) {
            C1697c c1697c = this.f4270b;
            c1697c.f4276c--;
            if (bitmap != null) {
                this.f4270b.f4274a.put(this.f4269a, bitmap);
                this.f4270b.f4275b.notifyDataSetChanged();
                this.f4270b.m6385b();
                return;
            }
            this.f4270b.f4275b.notifyDataSetChanged();
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m6378a(objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m6379a((Bitmap) obj);
        }
    }

    class C1696b {
        String f4271a;
        String f4272b;
        final /* synthetic */ C1697c f4273c;

        public C1696b(C1697c c1697c, String str, String str2) {
            this.f4273c = c1697c;
            this.f4271a = str;
            this.f4272b = str2;
        }
    }

    public C1697c(Activity activity) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.f4279f = new File(activity.getFilesDir().getAbsolutePath(), "tfriends");
        } else {
            this.f4279f = activity.getCacheDir();
        }
        if (!this.f4279f.exists()) {
            this.f4279f.mkdirs();
        }
        this.f4274a = new Hashtable();
        this.f4277d = new Stack();
        this.f4277d.setSize(10);
        this.f4278e = new Stack();
        this.f4278e.setSize(3);
    }

    private String m6381a(String str) {
        String toLowerCase = str.toLowerCase();
        int lastIndexOf = toLowerCase.lastIndexOf(47);
        return this.f4279f.getAbsolutePath() + File.separator + toLowerCase.substring(toLowerCase.lastIndexOf(47, lastIndexOf - 1) + 1, lastIndexOf) + "_" + toLowerCase.substring(lastIndexOf + 1);
    }

    public Bitmap m6382a(String str, String str2) {
        Bitmap bitmap = (Bitmap) this.f4274a.get(str);
        if (bitmap != null) {
            if (bitmap.getHeight() > 1) {
                return bitmap;
            }
            this.f4274a.remove(str);
        }
        String a = m6381a(str2);
        C1216a.m4524d("getImage", "check savedFile  " + str + " = " + a + " on rc " + this.f4276c);
        C1216a.m4524d("getImage", "check savedFile  " + str + " is Exist " + new File(a).exists());
        synchronized (this) {
            bitmap = C1704e.m6414a(new File(a));
        }
        if (bitmap != null) {
            this.f4274a.put(str, bitmap);
            return bitmap;
        } else if (this.f4274a.containsKey(str)) {
            C1216a.m4522b("getImage", "cannot reach " + str);
            return bitmap;
        } else {
            C1216a.m4522b("getImage", "check recent " + str2);
            if (this.f4278e.contains(str)) {
                return null;
            }
            C1216a.m4522b("getImage", "has not exist " + str2);
            if (this.f4276c >= 3) {
                this.f4277d.push(new C1696b(this, str, str2));
            } else {
                C1216a.m4522b("getImage", "download " + str + " start on rc: " + this.f4276c);
                this.f4276c++;
                this.f4278e.push(str);
                new C1695a().execute(new Object[]{str, str2});
            }
            return null;
        }
    }

    public void m6383a() {
        this.f4276c = 0;
        this.f4277d.clear();
    }

    public void m6384a(BaseAdapter baseAdapter) {
        this.f4275b = baseAdapter;
        m6383a();
    }

    public void m6385b() {
        if (!this.f4277d.isEmpty()) {
            C1696b c1696b = (C1696b) this.f4277d.pop();
            if (!this.f4274a.containsKey(c1696b.f4271a)) {
                String a = m6381a(c1696b.f4272b);
                C1216a.m4524d("getImage", "next savedFile  " + c1696b.f4271a + " = " + a);
                C1216a.m4524d("getImage", "next savedFile  " + c1696b.f4271a + " is Exist " + new File(a).exists());
                if (new File(a).exists()) {
                    Bitmap a2;
                    synchronized (this) {
                        a2 = C1704e.m6414a(new File(a));
                    }
                    if (a2 != null) {
                        C1216a.m4523c("getImage", "next local file exist  " + c1696b.f4271a);
                        this.f4274a.put(c1696b.f4271a, a2);
                        return;
                    }
                    return;
                }
                C1216a.m4522b("getImage", "load item from queue " + c1696b.f4271a + " check on rc: " + this.f4276c);
                if (this.f4276c < 3) {
                    this.f4276c++;
                    this.f4278e.push(c1696b.f4271a);
                    new C1695a().execute(new Object[]{c1696b.f4271a, c1696b.f4272b});
                }
            }
        }
    }
}
