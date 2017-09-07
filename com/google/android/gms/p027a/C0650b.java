package com.google.android.gms.p027a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.C0672e;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class C0650b<T extends C0641a> {
    private T f804a;
    private Bundle f805b;
    private LinkedList<C0644a> f806c;
    private final C0642e<T> f807d = new C06431(this);

    class C06431 implements C0642e<T> {
        final /* synthetic */ C0650b f789a;

        C06431(C0650b c0650b) {
            this.f789a = c0650b;
        }

        public void mo871a(T t) {
            this.f789a.f804a = t;
            Iterator it = this.f789a.f806c.iterator();
            while (it.hasNext()) {
                ((C0644a) it.next()).mo873a(this.f789a.f804a);
            }
            this.f789a.f806c.clear();
            this.f789a.f805b = null;
        }
    }

    private interface C0644a {
        int mo872a();

        void mo873a(C0641a c0641a);
    }

    class C06496 implements C0644a {
        final /* synthetic */ C0650b f803a;

        C06496(C0650b c0650b) {
            this.f803a = c0650b;
        }

        public int mo872a() {
            return 5;
        }

        public void mo873a(C0641a c0641a) {
            this.f803a.f804a.mo1277a();
        }
    }

    private void m1367a(int i) {
        while (!this.f806c.isEmpty() && ((C0644a) this.f806c.getLast()).mo872a() >= i) {
            this.f806c.removeLast();
        }
    }

    private void m1368a(Bundle bundle, C0644a c0644a) {
        if (this.f804a != null) {
            c0644a.mo873a(this.f804a);
            return;
        }
        if (this.f806c == null) {
            this.f806c = new LinkedList();
        }
        this.f806c.add(c0644a);
        if (bundle != null) {
            if (this.f805b == null) {
                this.f805b = (Bundle) bundle.clone();
            } else {
                this.f805b.putAll(bundle);
            }
        }
        mo1285a(this.f807d);
    }

    public static void m1370b(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int a = C0672e.m1465a(context);
        CharSequence b = C0672e.m1473b(context, a);
        CharSequence c = C0672e.m1477c(context, a);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(b);
        linearLayout.addView(textView);
        if (c != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(c);
            linearLayout.addView(button);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    context.startActivity(C0672e.m1467a(context, a));
                }
            });
        }
    }

    public View m1371a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        final LayoutInflater layoutInflater2 = layoutInflater;
        final ViewGroup viewGroup2 = viewGroup;
        final Bundle bundle2 = bundle;
        m1368a(bundle, new C0644a(this) {
            final /* synthetic */ C0650b f800e;

            public int mo872a() {
                return 2;
            }

            public void mo873a(C0641a c0641a) {
                frameLayout.removeAllViews();
                frameLayout.addView(this.f800e.f804a.mo1276a(layoutInflater2, viewGroup2, bundle2));
            }
        });
        if (this.f804a == null) {
            m1375a(frameLayout);
        }
        return frameLayout;
    }

    public T m1372a() {
        return this.f804a;
    }

    public void m1373a(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        m1368a(bundle2, new C0644a(this) {
            final /* synthetic */ C0650b f793d;

            public int mo872a() {
                return 0;
            }

            public void mo873a(C0641a c0641a) {
                this.f793d.f804a.mo1278a(activity, bundle, bundle2);
            }
        });
    }

    public void m1374a(final Bundle bundle) {
        m1368a(bundle, new C0644a(this) {
            final /* synthetic */ C0650b f795b;

            public int mo872a() {
                return 1;
            }

            public void mo873a(C0641a c0641a) {
                this.f795b.f804a.mo1279a(bundle);
            }
        });
    }

    protected void m1375a(FrameLayout frameLayout) {
        C0650b.m1370b(frameLayout);
    }

    protected abstract void mo1285a(C0642e<T> c0642e);

    public void m1377b() {
        m1368a(null, new C06496(this));
    }

    public void m1378b(Bundle bundle) {
        if (this.f804a != null) {
            this.f804a.mo1281b(bundle);
        } else if (this.f805b != null) {
            bundle.putAll(this.f805b);
        }
    }

    public void m1379c() {
        if (this.f804a != null) {
            this.f804a.mo1280b();
        } else {
            m1367a(5);
        }
    }

    public void m1380d() {
        if (this.f804a != null) {
            this.f804a.mo1282c();
        } else {
            m1367a(2);
        }
    }

    public void m1381e() {
        if (this.f804a != null) {
            this.f804a.mo1283d();
        } else {
            m1367a(1);
        }
    }

    public void m1382f() {
        if (this.f804a != null) {
            this.f804a.mo1284e();
        }
    }
}
