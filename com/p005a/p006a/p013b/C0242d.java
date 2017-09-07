package com.p005a.p006a.p013b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.p005a.p006a.p007a.p008a.C0200b;
import com.p005a.p006a.p007a.p008a.p010b.C0206a;
import com.p005a.p006a.p007a.p011b.C0209a;
import com.p005a.p006a.p007a.p011b.p012a.C0210a;
import com.p005a.p006a.p013b.p014a.C0224c;
import com.p005a.p006a.p013b.p014a.C0225d;
import com.p005a.p006a.p013b.p016b.C0230b;
import com.p005a.p006a.p013b.p018d.C0238b;
import com.p005a.p006a.p013b.p018d.C0240c;
import com.p005a.p006a.p013b.p018d.C0241d;
import com.p005a.p006a.p013b.p019e.C0243a;
import com.p005a.p006a.p020c.C0246b;
import java.util.concurrent.Executor;

public final class C0242d {
    final Resources f395a;
    final int f396b;
    final int f397c;
    final int f398d;
    final int f399e;
    final CompressFormat f400f;
    final int f401g;
    final C0243a f402h;
    final Executor f403i;
    final Executor f404j;
    final boolean f405k;
    final boolean f406l;
    final int f407m;
    final int f408n;
    final C0225d f409o;
    final C0209a<String, Bitmap> f410p;
    final C0200b f411q;
    final C0238b f412r;
    final C0230b f413s;
    final C0232b f414t;
    final boolean f415u;
    final C0200b f416v;
    final C0238b f417w;
    final C0238b f418x;

    public static class C0237a {
        public static final C0225d f363a = C0225d.FIFO;
        private boolean f364A = false;
        private Context f365b;
        private int f366c = 0;
        private int f367d = 0;
        private int f368e = 0;
        private int f369f = 0;
        private CompressFormat f370g = null;
        private int f371h = 0;
        private C0243a f372i = null;
        private Executor f373j = null;
        private Executor f374k = null;
        private boolean f375l = false;
        private boolean f376m = false;
        private int f377n = 3;
        private int f378o = 4;
        private boolean f379p = false;
        private C0225d f380q = f363a;
        private int f381r = 0;
        private int f382s = 0;
        private int f383t = 0;
        private C0209a<String, Bitmap> f384u = null;
        private C0200b f385v = null;
        private C0206a f386w = null;
        private C0238b f387x = null;
        private C0230b f388y;
        private C0232b f389z = null;

        public C0237a(Context context) {
            this.f365b = context.getApplicationContext();
        }

        private void m780c() {
            if (this.f373j == null) {
                this.f373j = C0227a.m749a(this.f377n, this.f378o, this.f380q);
            } else {
                this.f375l = true;
            }
            if (this.f374k == null) {
                this.f374k = C0227a.m749a(this.f377n, this.f378o, this.f380q);
            } else {
                this.f376m = true;
            }
            if (this.f385v == null) {
                if (this.f386w == null) {
                    this.f386w = C0227a.m743a();
                }
                this.f385v = C0227a.m744a(this.f365b, this.f386w, this.f382s, this.f383t);
            }
            if (this.f384u == null) {
                this.f384u = C0227a.m746a(this.f381r);
            }
            if (this.f379p) {
                this.f384u = new C0210a(this.f384u, C0224c.m742a());
            }
            if (this.f387x == null) {
                this.f387x = C0227a.m748a(this.f365b);
            }
            if (this.f388y == null) {
                this.f388y = C0227a.m747a(this.f364A);
            }
            if (this.f389z == null) {
                this.f389z = C0232b.m774a();
            }
        }

        public C0237a m799a() {
            this.f364A = true;
            return this;
        }

        public C0237a m800a(C0232b c0232b) {
            this.f389z = c0232b;
            return this;
        }

        public C0242d m801b() {
            m780c();
            return new C0242d();
        }
    }

    private C0242d(C0237a c0237a) {
        this.f395a = c0237a.f365b.getResources();
        this.f396b = c0237a.f366c;
        this.f397c = c0237a.f367d;
        this.f398d = c0237a.f368e;
        this.f399e = c0237a.f369f;
        this.f400f = c0237a.f370g;
        this.f401g = c0237a.f371h;
        this.f402h = c0237a.f372i;
        this.f403i = c0237a.f373j;
        this.f404j = c0237a.f374k;
        this.f407m = c0237a.f377n;
        this.f408n = c0237a.f378o;
        this.f409o = c0237a.f380q;
        this.f411q = c0237a.f385v;
        this.f410p = c0237a.f384u;
        this.f414t = c0237a.f389z;
        this.f415u = c0237a.f364A;
        this.f412r = c0237a.f387x;
        this.f413s = c0237a.f388y;
        this.f405k = c0237a.f375l;
        this.f406l = c0237a.f376m;
        this.f417w = new C0240c(this.f412r);
        this.f418x = new C0241d(this.f412r);
        this.f416v = C0227a.m745a(C0246b.m807a(c0237a.f365b, false));
    }
}
