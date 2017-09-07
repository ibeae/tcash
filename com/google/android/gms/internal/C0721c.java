package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.facebook.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.C0775e.C0715a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class C0721c implements OnGlobalLayoutListener, OnScrollChangedListener {
    private static final long f1088m = TimeUnit.MILLISECONDS.toNanos(100);
    private final Object f1089a;
    private final WeakReference<db> f1090b;
    private WeakReference<ViewTreeObserver> f1091c;
    private final WeakReference<View> f1092d;
    private final C0677a f1093e;
    private final Context f1094f;
    private final C0775e f1095g;
    private boolean f1096h;
    private final WindowManager f1097i;
    private final PowerManager f1098j;
    private final KeyguardManager f1099k;
    private C0687d f1100l;
    private boolean f1101n;
    private boolean f1102o;
    private long f1103p;
    private boolean f1104q;
    private BroadcastReceiver f1105r;
    private HashSet<fx> f1106s;

    class C07161 implements C0715a {
        final /* synthetic */ C0721c f1083a;

        C07161(C0721c c0721c) {
            this.f1083a = c0721c;
        }

        public void mo945a() {
            this.f1083a.f1096h = true;
            this.f1083a.m1827b(false);
            this.f1083a.m1817a();
        }
    }

    class C07172 extends BroadcastReceiver {
        final /* synthetic */ C0721c f1084a;

        C07172(C0721c c0721c) {
            this.f1084a = c0721c;
        }

        public void onReceive(Context context, Intent intent) {
            this.f1084a.m1827b(false);
        }
    }

    class C07183 implements aa {
        final /* synthetic */ C0721c f1085a;

        C07183(C0721c c0721c) {
            this.f1085a = c0721c;
        }

        public void mo874a(dt dtVar, Map<String, String> map) {
            this.f1085a.m1819a(dtVar, (Map) map);
        }
    }

    class C07194 implements aa {
        final /* synthetic */ C0721c f1086a;

        C07194(C0721c c0721c) {
            this.f1086a = c0721c;
        }

        public void mo874a(dt dtVar, Map<String, String> map) {
            if (map.containsKey("pingType") && "unloadPing".equals(map.get("pingType"))) {
                this.f1086a.m1829c(this.f1086a.f1095g);
                dq.m2117c("Unregistered GMSG handlers for: " + this.f1086a.f1093e.m1532d());
            }
        }
    }

    class C07205 implements aa {
        final /* synthetic */ C0721c f1087a;

        C07205(C0721c c0721c) {
            this.f1087a = c0721c;
        }

        public void mo874a(dt dtVar, Map<String, String> map) {
            if (map.containsKey("isVisible")) {
                boolean z = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("isVisible")) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(map.get("isVisible"));
                this.f1087a.m1823a(Boolean.valueOf(z).booleanValue());
            }
        }
    }

    public C0721c(al alVar, db dbVar) {
        this(alVar, dbVar, dbVar.f1263b.m2144h(), dbVar.f1263b, new C0804f(dbVar.f1263b.getContext(), dbVar.f1263b.m2144h()));
    }

    public C0721c(al alVar, db dbVar, ev evVar, View view, C0775e c0775e) {
        this.f1089a = new Object();
        this.f1101n = false;
        this.f1102o = false;
        this.f1103p = Long.MIN_VALUE;
        this.f1106s = new HashSet();
        this.f1090b = new WeakReference(dbVar);
        this.f1092d = new WeakReference(view);
        this.f1091c = new WeakReference(null);
        this.f1104q = true;
        this.f1093e = new C0677a(Integer.toString(dbVar.hashCode()), evVar, alVar.f921b, dbVar.f1271j);
        this.f1095g = c0775e;
        this.f1097i = (WindowManager) view.getContext().getSystemService("window");
        this.f1098j = (PowerManager) view.getContext().getApplicationContext().getSystemService("power");
        this.f1099k = (KeyguardManager) view.getContext().getSystemService("keyguard");
        this.f1094f = view.getContext().getApplicationContext();
        m1820a(c0775e);
        this.f1095g.mo1055a(new C07161(this));
        m1826b(this.f1095g);
        dq.m2117c("Tracking ad unit: " + this.f1093e.m1532d());
    }

    protected int m1815a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    protected JSONObject m1816a(View view) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr);
        view.getLocationInWindow(iArr2);
        JSONObject h = m1834h();
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.f1097i.getDefaultDisplay().getWidth();
        rect2.bottom = this.f1097i.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        view.getLocalVisibleRect(rect4);
        h.put("viewBox", new JSONObject().put("top", m1815a(rect2.top, displayMetrics)).put("bottom", m1815a(rect2.bottom, displayMetrics)).put("left", m1815a(rect2.left, displayMetrics)).put("right", m1815a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", m1815a(rect.top, displayMetrics)).put("bottom", m1815a(rect.bottom, displayMetrics)).put("left", m1815a(rect.left, displayMetrics)).put("right", m1815a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", m1815a(rect3.top, displayMetrics)).put("bottom", m1815a(rect3.bottom, displayMetrics)).put("left", m1815a(rect3.left, displayMetrics)).put("right", m1815a(rect3.right, displayMetrics))).put("localVisibleBox", new JSONObject().put("top", m1815a(rect4.top, displayMetrics)).put("bottom", m1815a(rect4.bottom, displayMetrics)).put("left", m1815a(rect4.left, displayMetrics)).put("right", m1815a(rect4.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", m1824a(view, globalVisibleRect)).put("isStopped", this.f1102o).put("isPaused", this.f1101n);
        return h;
    }

    protected void m1817a() {
        synchronized (this.f1089a) {
            if (this.f1105r != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.f1105r = new C07172(this);
            this.f1094f.registerReceiver(this.f1105r, intentFilter);
        }
    }

    public void m1818a(C0687d c0687d) {
        synchronized (this.f1089a) {
            this.f1100l = c0687d;
        }
    }

    protected void m1819a(dt dtVar, Map<String, String> map) {
        m1827b(false);
    }

    protected void m1820a(C0775e c0775e) {
        c0775e.mo1056a("http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }

    public void m1821a(fx fxVar) {
        this.f1106s.add(fxVar);
    }

    protected void m1822a(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        this.f1095g.mo1058a("AFMA_updateActiveView", jSONObject2);
    }

    protected void m1823a(boolean z) {
        Iterator it = this.f1106s.iterator();
        while (it.hasNext()) {
            ((fx) it.next()).mo1101a(this, z);
        }
    }

    protected boolean m1824a(View view, boolean z) {
        return view.getVisibility() == 0 && z && view.isShown() && this.f1098j.isScreenOn() && !this.f1099k.inKeyguardRestrictedInputMode();
    }

    protected void m1825b() {
        synchronized (this.f1089a) {
            if (this.f1105r != null) {
                this.f1094f.unregisterReceiver(this.f1105r);
                this.f1105r = null;
            }
        }
    }

    protected void m1826b(C0775e c0775e) {
        c0775e.mo1057a("/updateActiveView", new C07183(this));
        c0775e.mo1057a("/activeViewPingSent", new C07194(this));
        c0775e.mo1057a("/visibilityChanged", new C07205(this));
        c0775e.mo1057a("/viewabilityChanged", C0853z.f1803a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m1827b(boolean r9) {
        /*
        r8 = this;
        r2 = r8.f1089a;
        monitor-enter(r2);
        r0 = r8.f1096h;	 Catch:{ all -> 0x001e }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r8.f1104q;	 Catch:{ all -> 0x001e }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
    L_0x000c:
        return;
    L_0x000d:
        r0 = java.lang.System.nanoTime();	 Catch:{ all -> 0x001e }
        if (r9 == 0) goto L_0x0021;
    L_0x0013:
        r4 = r8.f1103p;	 Catch:{ all -> 0x001e }
        r6 = f1088m;	 Catch:{ all -> 0x001e }
        r4 = r4 + r6;
        r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r3 <= 0) goto L_0x0021;
    L_0x001c:
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        goto L_0x000c;
    L_0x001e:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        throw r0;
    L_0x0021:
        r8.f1103p = r0;	 Catch:{ all -> 0x001e }
        r0 = r8.f1090b;	 Catch:{ all -> 0x001e }
        r0 = r0.get();	 Catch:{ all -> 0x001e }
        r0 = (com.google.android.gms.internal.db) r0;	 Catch:{ all -> 0x001e }
        r1 = r8.f1092d;	 Catch:{ all -> 0x001e }
        r1 = r1.get();	 Catch:{ all -> 0x001e }
        r1 = (android.view.View) r1;	 Catch:{ all -> 0x001e }
        if (r1 == 0) goto L_0x0037;
    L_0x0035:
        if (r0 != 0) goto L_0x003f;
    L_0x0037:
        r0 = 1;
    L_0x0038:
        if (r0 == 0) goto L_0x0041;
    L_0x003a:
        r8.m1828c();	 Catch:{ all -> 0x001e }
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        goto L_0x000c;
    L_0x003f:
        r0 = 0;
        goto L_0x0038;
    L_0x0041:
        r0 = r8.m1816a(r1);	 Catch:{ JSONException -> 0x0050 }
        r8.m1822a(r0);	 Catch:{ JSONException -> 0x0050 }
    L_0x0048:
        r8.m1832f();	 Catch:{ all -> 0x001e }
        r8.m1830d();	 Catch:{ all -> 0x001e }
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        goto L_0x000c;
    L_0x0050:
        r0 = move-exception;
        r1 = "Active view update failed.";
        com.google.android.gms.internal.dq.m2116b(r1, r0);	 Catch:{ all -> 0x001e }
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.c.b(boolean):void");
    }

    public void m1828c() {
        synchronized (this.f1089a) {
            if (this.f1104q) {
                m1833g();
                m1825b();
                try {
                    m1822a(m1835i());
                } catch (Throwable e) {
                    dq.m2116b("JSON Failure while processing active view data.", e);
                }
                this.f1104q = false;
                m1830d();
                dq.m2117c("Untracked ad unit: " + this.f1093e.m1532d());
            }
        }
    }

    protected void m1829c(C0775e c0775e) {
        c0775e.mo1060b("/viewabilityChanged");
        c0775e.mo1060b("/visibilityChanged");
        c0775e.mo1060b("/activeViewPingSent");
        c0775e.mo1060b("/updateActiveView");
    }

    protected void m1830d() {
        if (this.f1100l != null) {
            this.f1100l.mo909a(this);
        }
    }

    public boolean m1831e() {
        boolean z;
        synchronized (this.f1089a) {
            z = this.f1104q;
        }
        return z;
    }

    protected void m1832f() {
        View view = (View) this.f1092d.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f1091c.get();
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                this.f1091c = new WeakReference(viewTreeObserver2);
                viewTreeObserver2.addOnScrollChangedListener(this);
                viewTreeObserver2.addOnGlobalLayoutListener(this);
            }
        }
    }

    protected void m1833g() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f1091c.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject m1834h() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.f1093e.m1530b()).put("activeViewJSON", this.f1093e.m1531c()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", this.f1093e.m1529a()).put("hashCode", this.f1093e.m1532d());
        return jSONObject;
    }

    protected JSONObject m1835i() {
        JSONObject h = m1834h();
        h.put("doneReasonCode", "u");
        return h;
    }

    public void m1836j() {
        synchronized (this.f1089a) {
            this.f1102o = true;
            m1827b(false);
            this.f1095g.mo1054a();
        }
    }

    public void m1837k() {
        synchronized (this.f1089a) {
            this.f1101n = true;
            m1827b(false);
            this.f1095g.mo1054a();
        }
    }

    public void m1838l() {
        synchronized (this.f1089a) {
            this.f1095g.mo1059b();
            this.f1101n = false;
            m1827b(false);
        }
    }

    public void onGlobalLayout() {
        m1827b(false);
    }

    public void onScrollChanged() {
        m1827b(true);
    }
}
