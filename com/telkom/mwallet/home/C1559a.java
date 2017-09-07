package com.telkom.mwallet.home;

import android.content.Context;
import android.content.Intent;
import com.telkom.mwallet.C1359a;
import java.util.Stack;

public class C1559a {
    private static C1559a f3736c = new C1559a();
    private final String[] f3737a = new String[]{HomeActivity.f3727k};
    private Stack<C1359a> f3738b = new Stack();
    private boolean f3739d = false;

    private C1559a() {
    }

    public static C1559a m5752a() {
        if (f3736c == null) {
            f3736c = new C1559a();
        }
        return f3736c;
    }

    public void m5753a(C1359a c1359a) {
        if (c1359a != null) {
            String simpleName = c1359a.getClass().getSimpleName();
            C1359a.m4963a((Object) this, "Stack addActivity : " + simpleName);
            if (this.f3737a[0].equals(simpleName)) {
                this.f3739d = true;
            }
            this.f3738b.push(c1359a);
        }
    }

    public C1359a m5754b() {
        if (this.f3738b == null) {
            return null;
        }
        Context context = null;
        while (!this.f3738b.isEmpty()) {
            C1359a c1359a = (C1359a) this.f3738b.pop();
            String simpleName = c1359a.getClass().getSimpleName();
            C1359a.m4963a((Object) this, "Stack Last Activity : " + simpleName + " remain:" + this.f3738b.size());
            if (simpleName.equals(this.f3737a[0])) {
                this.f3738b.push(c1359a);
                if (context != null) {
                    context.finish();
                }
                return c1359a;
            } else if (context == null) {
                context = c1359a;
            } else {
                c1359a.finish();
            }
        }
        Intent intent = new Intent();
        intent.setClass(context, HomeActivity.class);
        intent.setFlags(603979776);
        context.startActivity(intent);
        context.finish();
        return null;
    }

    public void m5755b(C1359a c1359a) {
        if (this.f3738b.size() > 0) {
            C1359a.m4963a((Object) this, "Stack removeActivity " + c1359a.getClass().getSimpleName() + " : status : " + this.f3738b.remove(c1359a) + " called onDestroy()");
        }
        if (this.f3738b.isEmpty()) {
            this.f3739d = false;
        }
    }

    public boolean m5756c() {
        return this.f3738b.isEmpty();
    }

    public boolean m5757d() {
        return this.f3739d;
    }

    public C1359a m5758e() {
        if (this.f3738b.isEmpty()) {
            return null;
        }
        C1359a.m4963a((Object) this, "Stack size : " + this.f3738b.size());
        return (C1359a) this.f3738b.peek();
    }

    public void m5759f() {
        while (!this.f3738b.isEmpty()) {
            C1359a c1359a = (C1359a) this.f3738b.pop();
            C1359a.m4963a((Object) this, "Stack removeAll " + c1359a.getClass().getSimpleName() + ".finish()");
            c1359a.finish();
        }
        this.f3739d = false;
    }
}
