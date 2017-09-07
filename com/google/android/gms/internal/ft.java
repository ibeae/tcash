package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.C0672e;
import com.google.android.gms.internal.C0815o.C0816a;
import com.google.android.gms.internal.ci.C0725a;
import com.google.android.gms.internal.ds.C0751a;
import com.google.android.gms.p027a.C0651c;
import com.google.android.gms.p027a.C0654d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class ft extends C0816a implements ab, ad, an, bh, bk, C0725a, df, fs, C0817y {
    private final at f1625a;
    private final C0814c f1626b;
    private final fw f1627c;
    private final C0688b f1628d;
    private boolean f1629e;
    private final ComponentCallbacks f1630f = new C08111(this);

    class C08111 implements ComponentCallbacks {
        final /* synthetic */ ft f1602a;

        C08111(ft ftVar) {
            this.f1602a = ftVar;
        }

        public void onConfigurationChanged(Configuration configuration) {
            if (this.f1602a.f1626b != null && this.f1602a.f1626b.f1616i != null && this.f1602a.f1626b.f1616i.f1263b != null) {
                this.f1602a.f1626b.f1616i.f1263b.m2129a();
            }
        }

        public void onLowMemory() {
        }
    }

    private static final class C0812a extends ViewSwitcher {
        private final dl f1603a;

        public C0812a(Context context) {
            super(context);
            this.f1603a = new dl(context);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.f1603a.m2091a(motionEvent);
            return false;
        }
    }

    private static final class C0813b implements eb, Runnable {
        private final List<Object[]> f1604a = new Vector();
        private final CountDownLatch f1605b = new CountDownLatch(1);
        private final AtomicReference<eb> f1606c = new AtomicReference();
        private C0814c f1607d;

        public C0813b(C0814c c0814c) {
            this.f1607d = c0814c;
            if (dp.m2111b()) {
                dj.m2058a(this);
            } else {
                run();
            }
        }

        private void m2566a() {
            try {
                this.f1605b.await();
            } catch (Throwable e) {
                dq.m2118c("Interrupted during GADSignals creation.", e);
            }
        }

        private void m2567b() {
            if (!this.f1604a.isEmpty()) {
                for (Object[] objArr : this.f1604a) {
                    if (objArr.length == 1) {
                        ((eb) this.f1606c.get()).mo969a((MotionEvent) objArr[0]);
                    } else if (objArr.length == 3) {
                        ((eb) this.f1606c.get()).mo968a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                    }
                }
            }
        }

        public String mo966a(Context context) {
            m2566a();
            if (this.f1606c.get() == null) {
                return "";
            }
            m2567b();
            return ((eb) this.f1606c.get()).mo966a(context);
        }

        public String mo967a(Context context, String str) {
            m2566a();
            if (this.f1606c.get() == null) {
                return "";
            }
            m2567b();
            return ((eb) this.f1606c.get()).mo967a(context, str);
        }

        public void mo968a(int i, int i2, int i3) {
            eb ebVar = (eb) this.f1606c.get();
            if (ebVar != null) {
                m2567b();
                ebVar.mo968a(i, i2, i3);
                return;
            }
            this.f1604a.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }

        public void mo969a(MotionEvent motionEvent) {
            eb ebVar = (eb) this.f1606c.get();
            if (ebVar != null) {
                m2567b();
                ebVar.mo969a(motionEvent);
                return;
            }
            this.f1604a.add(new Object[]{motionEvent});
        }

        public String mo970b(Context context) {
            m2566a();
            if (this.f1606c.get() == null) {
                return "";
            }
            m2567b();
            return ((eb) this.f1606c.get()).mo970b(context);
        }

        public void run() {
            try {
                this.f1606c.set(ep.m2364a(this.f1607d.f1612e.f1564b, this.f1607d.f1610c));
            } finally {
                this.f1605b.countDown();
                this.f1607d = null;
            }
        }
    }

    private static final class C0814c {
        public final C0812a f1608a;
        public final String f1609b;
        public final Context f1610c;
        public final fg f1611d;
        public final ev f1612e;
        public C0820n f1613f;
        public di f1614g;
        public al f1615h;
        public db f1616i;
        public dc f1617j;
        public C0827q f1618k;
        public cb f1619l;
        public by f1620m;
        public bv f1621n;
        public dg f1622o = null;
        public boolean f1623p = false;
        private HashSet<dc> f1624q = null;

        public C0814c(Context context, al alVar, String str, ev evVar) {
            if (alVar.f924e) {
                this.f1608a = null;
            } else {
                this.f1608a = new C0812a(context);
                this.f1608a.setMinimumWidth(alVar.f926g);
                this.f1608a.setMinimumHeight(alVar.f923d);
                this.f1608a.setVisibility(4);
            }
            this.f1615h = alVar;
            this.f1609b = str;
            this.f1610c = context;
            this.f1612e = evVar;
            this.f1611d = new fg(new C0813b(this));
        }

        public HashSet<dc> m2573a() {
            return this.f1624q;
        }

        public void m2574a(HashSet<dc> hashSet) {
            this.f1624q = hashSet;
        }
    }

    public ft(Context context, al alVar, String str, at atVar, ev evVar) {
        this.f1626b = new C0814c(context, alVar, str, evVar);
        this.f1625a = atVar;
        this.f1627c = new fw(this);
        this.f1628d = new C0688b();
        dk.m2080b(context);
        m2599s();
    }

    private void m2592A() {
        if (this.f1626b.f1616i != null) {
            this.f1626b.f1616i.f1263b.destroy();
            this.f1626b.f1616i = null;
        }
    }

    private void m2594a(int i) {
        dq.m2120e("Failed to load ad: " + i);
        if (this.f1626b.f1613f != null) {
            try {
                this.f1626b.f1613f.mo1103a(i);
            } catch (Throwable e) {
                dq.m2118c("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    private void m2595a(View view) {
        this.f1626b.f1608a.addView(view, new LayoutParams(-2, -2));
    }

    private void m2596b(boolean z) {
        if (this.f1626b.f1616i == null) {
            dq.m2120e("Ad state was null when trying to ping impression URLs.");
            return;
        }
        dq.m2112a("Pinging Impression URLs.");
        this.f1626b.f1617j.m2023a();
        if (this.f1626b.f1616i.f1266e != null) {
            dk.m2068a(this.f1626b.f1610c, this.f1626b.f1612e.f1564b, this.f1626b.f1616i.f1266e);
        }
        if (!(this.f1626b.f1616i.f1276o == null || this.f1626b.f1616i.f1276o.f931d == null)) {
            ar.m1589a(this.f1626b.f1610c, this.f1626b.f1612e.f1564b, this.f1626b.f1616i, this.f1626b.f1609b, z, this.f1626b.f1616i.f1276o.f931d);
        }
        if (this.f1626b.f1616i.f1273l != null && this.f1626b.f1616i.f1273l.f918f != null) {
            ar.m1589a(this.f1626b.f1610c, this.f1626b.f1612e.f1564b, this.f1626b.f1616i, this.f1626b.f1609b, z, this.f1626b.f1616i.f1273l.f918f);
        }
    }

    private boolean m2597b(db dbVar) {
        View view;
        if (dbVar.f1272k) {
            try {
                view = (View) C0654d.m1385a(dbVar.f1274m.mo885a());
                View nextView = this.f1626b.f1608a.getNextView();
                if (nextView != null) {
                    this.f1626b.f1608a.removeView(nextView);
                }
                try {
                    m2595a(view);
                } catch (Throwable th) {
                    dq.m2118c("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (Throwable th2) {
                dq.m2118c("Could not get View from mediation adapter.", th2);
                return false;
            }
        } else if (dbVar.f1279r != null) {
            dbVar.f1263b.m2131a(dbVar.f1279r);
            this.f1626b.f1608a.removeAllViews();
            this.f1626b.f1608a.setMinimumWidth(dbVar.f1279r.f926g);
            this.f1626b.f1608a.setMinimumHeight(dbVar.f1279r.f923d);
            m2595a(dbVar.f1263b);
        }
        if (this.f1626b.f1608a.getChildCount() > 1) {
            this.f1626b.f1608a.showNext();
        }
        if (this.f1626b.f1616i != null) {
            view = this.f1626b.f1608a.getNextView();
            if (view instanceof dt) {
                ((dt) view).m2130a(this.f1626b.f1610c, this.f1626b.f1615h);
            } else if (view != null) {
                this.f1626b.f1608a.removeView(view);
            }
            if (this.f1626b.f1616i.f1274m != null) {
                try {
                    this.f1626b.f1616i.f1274m.mo891c();
                } catch (RemoteException e) {
                    dq.m2120e("Could not destroy previous mediation adapter.");
                }
            }
        }
        this.f1626b.f1608a.setVisibility(0);
        return true;
    }

    private C0751a m2598c(ai aiVar) {
        PackageInfo packageInfo;
        Bundle bundle;
        ApplicationInfo applicationInfo = this.f1626b.f1610c.getApplicationInfo();
        try {
            packageInfo = this.f1626b.f1610c.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (this.f1626b.f1615h.f924e || this.f1626b.f1608a.getParent() == null) {
            bundle = null;
        } else {
            int[] iArr = new int[2];
            this.f1626b.f1608a.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            DisplayMetrics displayMetrics = this.f1626b.f1610c.getResources().getDisplayMetrics();
            int width = this.f1626b.f1608a.getWidth();
            int height = this.f1626b.f1608a.getHeight();
            int i3 = (!this.f1626b.f1608a.isShown() || i + width <= 0 || i2 + height <= 0 || i > displayMetrics.widthPixels || i2 > displayMetrics.heightPixels) ? 0 : 1;
            bundle = new Bundle(5);
            bundle.putInt("x", i);
            bundle.putInt("y", i2);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            bundle.putInt("visible", i3);
        }
        String b = dd.m2035b();
        this.f1626b.f1617j = new dc(b, this.f1626b.f1609b);
        this.f1626b.f1617j.m2025a(aiVar);
        return new C0751a(bundle, aiVar, this.f1626b.f1615h, this.f1626b.f1609b, applicationInfo, packageInfo, b, dd.f1298a, this.f1626b.f1612e, dd.m2032a(this.f1626b.f1610c, this, b));
    }

    private void m2599s() {
        if (VERSION.SDK_INT >= 14 && this.f1626b != null && this.f1626b.f1610c != null) {
            this.f1626b.f1610c.registerComponentCallbacks(this.f1630f);
        }
    }

    private void m2600t() {
        if (VERSION.SDK_INT >= 14 && this.f1626b != null && this.f1626b.f1610c != null) {
            this.f1626b.f1610c.unregisterComponentCallbacks(this.f1630f);
        }
    }

    private void m2601u() {
        dq.m2117c("Ad closing.");
        if (this.f1626b.f1613f != null) {
            try {
                this.f1626b.f1613f.mo1102a();
            } catch (Throwable e) {
                dq.m2118c("Could not call AdListener.onAdClosed().", e);
            }
        }
    }

    private void m2602v() {
        dq.m2117c("Ad leaving application.");
        if (this.f1626b.f1613f != null) {
            try {
                this.f1626b.f1613f.mo1104b();
            } catch (Throwable e) {
                dq.m2118c("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
    }

    private void m2603w() {
        dq.m2117c("Ad opening.");
        if (this.f1626b.f1613f != null) {
            try {
                this.f1626b.f1613f.mo1106d();
            } catch (Throwable e) {
                dq.m2118c("Could not call AdListener.onAdOpened().", e);
            }
        }
    }

    private void m2604x() {
        dq.m2117c("Ad finished loading.");
        if (this.f1626b.f1613f != null) {
            try {
                this.f1626b.f1613f.mo1105c();
            } catch (Throwable e) {
                dq.m2118c("Could not call AdListener.onAdLoaded().", e);
            }
        }
    }

    private boolean m2605y() {
        boolean z = true;
        if (!dk.m2075a(this.f1626b.f1610c.getPackageManager(), this.f1626b.f1610c.getPackageName(), "android.permission.INTERNET")) {
            if (!this.f1626b.f1615h.f924e) {
                dp.m2109a(this.f1626b.f1608a, this.f1626b.f1615h, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            z = false;
        }
        if (!dk.m2074a(this.f1626b.f1610c)) {
            if (!this.f1626b.f1615h.f924e) {
                dp.m2109a(this.f1626b.f1608a, this.f1626b.f1615h, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            z = false;
        }
        if (!(z || this.f1626b.f1615h.f924e)) {
            this.f1626b.f1608a.setVisibility(0);
        }
        return z;
    }

    private void m2606z() {
        if (this.f1626b.f1616i == null) {
            dq.m2120e("Ad state was null when trying to ping click URLs.");
            return;
        }
        dq.m2112a("Pinging click URLs.");
        this.f1626b.f1617j.m2027b();
        if (this.f1626b.f1616i.f1264c != null) {
            dk.m2068a(this.f1626b.f1610c, this.f1626b.f1612e.f1564b, this.f1626b.f1616i.f1264c);
        }
        if (this.f1626b.f1616i.f1276o != null && this.f1626b.f1616i.f1276o.f930c != null) {
            ar.m1589a(this.f1626b.f1610c, this.f1626b.f1612e.f1564b, this.f1626b.f1616i, this.f1626b.f1609b, false, this.f1626b.f1616i.f1276o.f930c);
        }
    }

    public C0651c mo1072a() {
        ek.m2338b("getAdFrame must be called on the main UI thread.");
        return C0654d.m1384a(this.f1626b.f1608a);
    }

    public void mo1073a(al alVar) {
        ek.m2338b("setAdSize must be called on the main UI thread.");
        this.f1626b.f1615h = alVar;
        if (this.f1626b.f1616i != null) {
            this.f1626b.f1616i.f1263b.m2131a(alVar);
        }
        if (this.f1626b.f1608a.getChildCount() > 1) {
            this.f1626b.f1608a.removeView(this.f1626b.f1608a.getNextView());
        }
        this.f1626b.f1608a.setMinimumWidth(alVar.f926g);
        this.f1626b.f1608a.setMinimumHeight(alVar.f923d);
        this.f1626b.f1608a.requestLayout();
    }

    public void mo1074a(by byVar) {
        ek.m2338b("setInAppPurchaseListener must be called on the main UI thread.");
        this.f1626b.f1620m = byVar;
    }

    public void mo1075a(cb cbVar, String str) {
        ek.m2338b("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.f1626b.f1621n = new bv(str);
        this.f1626b.f1619l = cbVar;
        if (!dd.m2037f() && cbVar != null) {
            new bo(this.f1626b.f1610c, this.f1626b.f1619l, this.f1626b.f1621n).m1741e();
        }
    }

    public void mo1076a(db dbVar) {
        int i = 0;
        this.f1626b.f1614g = null;
        if (!(dbVar.f1265d == -2 || dbVar.f1265d == 3)) {
            dd.m2034a(this.f1626b.m2573a());
        }
        if (dbVar.f1265d != -1) {
            boolean z = dbVar.f1262a.f893c != null ? dbVar.f1262a.f893c.getBoolean("_noRefresh", false) : false;
            if (this.f1626b.f1615h.f924e) {
                dk.m2070a(dbVar.f1263b);
            } else if (!z) {
                if (dbVar.f1269h > 0) {
                    this.f1627c.m2648a(dbVar.f1262a, dbVar.f1269h);
                } else if (dbVar.f1276o != null && dbVar.f1276o.f934g > 0) {
                    this.f1627c.m2648a(dbVar.f1262a, dbVar.f1276o.f934g);
                } else if (!dbVar.f1272k && dbVar.f1265d == 2) {
                    this.f1627c.m2647a(dbVar.f1262a);
                }
            }
            if (!(dbVar.f1265d != 3 || dbVar.f1276o == null || dbVar.f1276o.f932e == null)) {
                dq.m2112a("Pinging no fill URLs.");
                ar.m1589a(this.f1626b.f1610c, this.f1626b.f1612e.f1564b, dbVar, this.f1626b.f1609b, false, dbVar.f1276o.f932e);
            }
            if (dbVar.f1265d != -2) {
                m2594a(dbVar.f1265d);
                return;
            }
            int i2;
            if (!this.f1626b.f1615h.f924e) {
                if (!m2597b(dbVar)) {
                    m2594a(0);
                    return;
                } else if (this.f1626b.f1608a != null) {
                    this.f1626b.f1608a.f1603a.m2092a(dbVar.f1283v);
                }
            }
            if (!(this.f1626b.f1616i == null || this.f1626b.f1616i.f1277p == null)) {
                this.f1626b.f1616i.f1277p.m1567a(null);
            }
            if (dbVar.f1277p != null) {
                dbVar.f1277p.m1567a((an) this);
            }
            this.f1628d.m1652b(this.f1626b.f1616i);
            this.f1626b.f1616i = dbVar;
            if (dbVar.f1279r != null) {
                this.f1626b.f1615h = dbVar.f1279r;
            }
            this.f1626b.f1617j.m2024a(dbVar.f1281t);
            this.f1626b.f1617j.m2028b(dbVar.f1282u);
            this.f1626b.f1617j.m2026a(this.f1626b.f1615h.f924e);
            this.f1626b.f1617j.m2029b(dbVar.f1272k);
            if (!this.f1626b.f1615h.f924e) {
                m2596b(false);
            }
            if (this.f1626b.f1622o == null) {
                this.f1626b.f1622o = new dg(this.f1626b.f1609b);
            }
            if (dbVar.f1276o != null) {
                i2 = dbVar.f1276o.f935h;
                i = dbVar.f1276o.f936i;
            } else {
                i2 = 0;
            }
            this.f1626b.f1622o.m2053a(i2, i);
            if (!(this.f1626b.f1615h.f924e || dbVar.f1263b == null || (!dbVar.f1263b.m2142f().m2160a() && dbVar.f1271j == null))) {
                C0721c a = this.f1628d.m1647a(this.f1626b.f1615h, this.f1626b.f1616i);
                if (dbVar.f1263b.m2142f().m2160a() && a != null) {
                    a.m1821a(new fv(dbVar.f1263b));
                }
            }
            this.f1626b.f1616i.f1263b.m2129a();
            m2604x();
        }
    }

    public void mo1077a(C0820n c0820n) {
        ek.m2338b("setAdListener must be called on the main UI thread.");
        this.f1626b.f1613f = c0820n;
    }

    public void mo1078a(C0827q c0827q) {
        ek.m2338b("setAppEventListener must be called on the main UI thread.");
        this.f1626b.f1618k = c0827q;
    }

    public void mo1079a(String str, String str2) {
        if (this.f1626b.f1618k != null) {
            try {
                this.f1626b.f1618k.mo1108a(str, str2);
            } catch (Throwable e) {
                dq.m2118c("Could not call the AppEventListener.", e);
            }
        }
    }

    public void mo1080a(String str, ArrayList<String> arrayList) {
        bx bpVar = new bp(str, arrayList, this.f1626b.f1610c, this.f1626b.f1612e.f1564b);
        if (this.f1626b.f1620m == null) {
            dq.m2120e("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (C0672e.m1465a(this.f1626b.f1610c) != 0) {
                dq.m2120e("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            } else if (this.f1626b.f1619l == null) {
                dq.m2120e("PlayStorePurchaseListener is not set.");
                return;
            } else if (this.f1626b.f1621n == null) {
                dq.m2120e("PlayStorePurchaseVerifier is not initialized.");
                return;
            } else {
                try {
                    if (!this.f1626b.f1619l.mo947a(str)) {
                        return;
                    }
                } catch (RemoteException e) {
                    dq.m2120e("Could not start In-App purchase.");
                }
                bq.m1765a(this.f1626b.f1610c, this.f1626b.f1612e.f1567e, new cq(bpVar, this.f1626b.f1619l, this.f1626b.f1621n, this.f1626b.f1610c));
                return;
            }
        }
        try {
            this.f1626b.f1620m.mo944a(bpVar);
        } catch (RemoteException e2) {
            dq.m2120e("Could not start In-App purchase.");
        }
    }

    public void mo1081a(HashSet<dc> hashSet) {
        this.f1626b.m2574a(hashSet);
    }

    public void mo1082a(boolean z) {
        this.f1626b.f1623p = z;
    }

    public boolean mo1083a(ai aiVar) {
        ek.m2338b("loadAd must be called on the main UI thread.");
        if (this.f1626b.f1614g != null) {
            dq.m2120e("An ad request is already in progress. Aborting.");
            return false;
        } else if (this.f1626b.f1615h.f924e && this.f1626b.f1616i != null) {
            dq.m2120e("An interstitial is already loading. Aborting.");
            return false;
        } else if (!m2605y()) {
            return false;
        } else {
            dt dtVar;
            dq.m2117c("Starting ad request.");
            if (!aiVar.f896f) {
                dq.m2117c("Use AdRequest.Builder.addTestDevice(\"" + dp.m2105a(this.f1626b.f1610c) + "\") to get test ads on this device.");
            }
            this.f1627c.m2646a();
            this.f1626b.f1623p = false;
            C0751a c = m2598c(aiVar);
            if (this.f1626b.f1615h.f924e) {
                dt a = dt.m2125a(this.f1626b.f1610c, this.f1626b.f1615h, false, false, this.f1626b.f1611d, this.f1626b.f1612e);
                a.m2142f().m2154a(this, null, this, this, true, this, this);
                dtVar = a;
            } else {
                dt dtVar2;
                View nextView = this.f1626b.f1608a.getNextView();
                if (nextView instanceof dt) {
                    dtVar2 = (dt) nextView;
                    dtVar2.m2130a(this.f1626b.f1610c, this.f1626b.f1615h);
                } else {
                    if (nextView != null) {
                        this.f1626b.f1608a.removeView(nextView);
                    }
                    nextView = dt.m2125a(this.f1626b.f1610c, this.f1626b.f1615h, false, false, this.f1626b.f1611d, this.f1626b.f1612e);
                    if (this.f1626b.f1615h.f927h == null) {
                        m2595a(nextView);
                    }
                }
                dtVar2.m2142f().m2153a(this, this, this, this, false, this);
                dtVar = dtVar2;
            }
            this.f1626b.f1614g = ci.m1861a(this.f1626b.f1610c, c, this.f1626b.f1611d, dtVar, this.f1625a, this);
            return true;
        }
    }

    public void mo1084b() {
        ek.m2338b("destroy must be called on the main UI thread.");
        m2600t();
        this.f1626b.f1613f = null;
        this.f1626b.f1618k = null;
        this.f1627c.m2646a();
        this.f1628d.m1648a();
        mo1089g();
        if (this.f1626b.f1608a != null) {
            this.f1626b.f1608a.removeAllViews();
        }
        if (!(this.f1626b.f1616i == null || this.f1626b.f1616i.f1263b == null)) {
            this.f1626b.f1616i.f1263b.destroy();
        }
        if (this.f1626b.f1616i != null && this.f1626b.f1616i.f1274m != null) {
            try {
                this.f1626b.f1616i.f1274m.mo891c();
            } catch (RemoteException e) {
                dq.m2120e("Could not destroy mediation adapter.");
            }
        }
    }

    public void m2620b(ai aiVar) {
        ViewParent parent = this.f1626b.f1608a.getParent();
        if ((parent instanceof View) && ((View) parent).isShown() && dk.m2073a() && !this.f1629e) {
            mo1083a(aiVar);
            return;
        }
        dq.m2117c("Ad is not visible. Not refreshing ad.");
        this.f1627c.m2647a(aiVar);
    }

    public boolean mo1085c() {
        ek.m2338b("isLoaded must be called on the main UI thread.");
        return this.f1626b.f1614g == null && this.f1626b.f1616i != null;
    }

    public void mo1086d() {
        ek.m2338b("pause must be called on the main UI thread.");
        if (this.f1626b.f1616i != null) {
            dk.m2070a(this.f1626b.f1616i.f1263b);
        }
        if (!(this.f1626b.f1616i == null || this.f1626b.f1616i.f1274m == null)) {
            try {
                this.f1626b.f1616i.f1274m.mo892d();
            } catch (RemoteException e) {
                dq.m2120e("Could not pause mediation adapter.");
            }
        }
        this.f1628d.m1651b();
        this.f1627c.m2649b();
    }

    public void mo1087e() {
        ek.m2338b("resume must be called on the main UI thread.");
        if (this.f1626b.f1616i != null) {
            dk.m2081b(this.f1626b.f1616i.f1263b);
        }
        if (!(this.f1626b.f1616i == null || this.f1626b.f1616i.f1274m == null)) {
            try {
                this.f1626b.f1616i.f1274m.mo893e();
            } catch (RemoteException e) {
                dq.m2120e("Could not resume mediation adapter.");
            }
        }
        this.f1627c.m2650c();
        this.f1628d.m1653c();
    }

    public void mo1088f() {
        ek.m2338b("showInterstitial must be called on the main UI thread.");
        if (!this.f1626b.f1615h.f924e) {
            dq.m2120e("Cannot call showInterstitial on a banner ad.");
        } else if (this.f1626b.f1616i == null) {
            dq.m2120e("The interstitial has not loaded.");
        } else if (this.f1626b.f1616i.f1263b.m2145i()) {
            dq.m2120e("The interstitial is already showing.");
        } else {
            this.f1626b.f1616i.f1263b.m2136a(true);
            if (this.f1626b.f1616i.f1263b.m2142f().m2160a() || this.f1626b.f1616i.f1271j != null) {
                C0721c a = this.f1628d.m1647a(this.f1626b.f1615h, this.f1626b.f1616i);
                if (this.f1626b.f1616i.f1263b.m2142f().m2160a() && a != null) {
                    a.m1821a(new fv(this.f1626b.f1616i.f1263b));
                }
            }
            if (this.f1626b.f1616i.f1272k) {
                try {
                    this.f1626b.f1616i.f1274m.mo890b();
                    return;
                } catch (Throwable e) {
                    dq.m2118c("Could not show interstitial.", e);
                    m2592A();
                    return;
                }
            }
            C0842v c0842v = new C0842v(this.f1626b.f1623p, false);
            if (this.f1626b.f1610c instanceof Activity) {
                Window window = ((Activity) this.f1626b.f1610c).getWindow();
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                window.getDecorView().getGlobalVisibleRect(rect);
                window.getDecorView().getWindowVisibleDisplayFrame(rect2);
                if (!(rect.bottom == 0 || rect2.bottom == 0)) {
                    c0842v = new C0842v(this.f1626b.f1623p, rect.top == rect2.top);
                }
            }
            bf.m1684a(this.f1626b.f1610c, new ch(this, this, this, this.f1626b.f1616i.f1263b, this.f1626b.f1616i.f1268g, this.f1626b.f1612e, this.f1626b.f1616i.f1283v, c0842v));
        }
    }

    public void mo1089g() {
        ek.m2338b("stopLoading must be called on the main UI thread.");
        if (this.f1626b.f1616i != null) {
            this.f1626b.f1616i.f1263b.stopLoading();
            this.f1626b.f1616i = null;
        }
        if (this.f1626b.f1614g != null) {
            this.f1626b.f1614g.m1742f();
        }
    }

    public void mo1090h() {
        ek.m2338b("recordManualImpression must be called on the main UI thread.");
        if (this.f1626b.f1616i == null) {
            dq.m2120e("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        dq.m2112a("Pinging manual tracking URLs.");
        if (this.f1626b.f1616i.f1267f != null) {
            dk.m2068a(this.f1626b.f1610c, this.f1626b.f1612e.f1564b, this.f1626b.f1616i.f1267f);
        }
    }

    public al mo1091i() {
        ek.m2338b("getAdSize must be called on the main UI thread.");
        return this.f1626b.f1615h;
    }

    public void mo1092j() {
        mo1100r();
    }

    public void mo1093k() {
        mo1097o();
    }

    public void mo1094l() {
        mo1099q();
    }

    public void mo1095m() {
        mo1098p();
    }

    public void mo1096n() {
        if (this.f1626b.f1616i != null) {
            dq.m2120e("Mediation adapter " + this.f1626b.f1616i.f1275n + " refreshed, but mediation adapters should never refresh.");
        }
        m2596b(true);
        m2604x();
    }

    public void mo1097o() {
        this.f1628d.m1652b(this.f1626b.f1616i);
        if (this.f1626b.f1615h.f924e) {
            m2592A();
        }
        this.f1629e = false;
        m2601u();
        this.f1626b.f1617j.m2030c();
    }

    public void mo1098p() {
        if (this.f1626b.f1615h.f924e) {
            m2596b(false);
        }
        this.f1629e = true;
        m2603w();
    }

    public void mo1099q() {
        m2602v();
    }

    public void mo1100r() {
        m2606z();
    }
}
