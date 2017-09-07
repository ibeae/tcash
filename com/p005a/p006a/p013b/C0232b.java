package com.p005a.p006a.p013b;

import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.p005a.p006a.p013b.p014a.C0222b;
import com.p005a.p006a.p013b.p017c.C0233a;
import com.p005a.p006a.p013b.p019e.C0243a;

public final class C0232b {
    private final int f339a;
    private final int f340b;
    private final int f341c;
    private final Drawable f342d;
    private final Drawable f343e;
    private final Drawable f344f;
    private final boolean f345g;
    private final boolean f346h;
    private final boolean f347i;
    private final C0222b f348j;
    private final Options f349k;
    private final int f350l;
    private final boolean f351m;
    private final Object f352n;
    private final C0243a f353o;
    private final C0243a f354p;
    private final C0233a f355q;
    private final Handler f356r;
    private final boolean f357s;

    public static class C0229a {
        private int f319a;
        private int f320b;
        private int f321c;
        private Drawable f322d;
        private Drawable f323e;
        private Drawable f324f;
        private boolean f325g;
        private boolean f326h;
        private boolean f327i;
        private C0222b f328j;
        private Options f329k;
        private int f330l;
        private boolean f331m;
        private Object f332n;
        private C0243a f333o;
        private C0243a f334p;
        private C0233a f335q;
        private Handler f336r;
        private boolean f337s;

        public C0229a() {
            this.f319a = 0;
            this.f320b = 0;
            this.f321c = 0;
            this.f322d = null;
            this.f323e = null;
            this.f324f = null;
            this.f325g = false;
            this.f326h = false;
            this.f327i = false;
            this.f328j = C0222b.IN_SAMPLE_POWER_OF_2;
            this.f329k = new Options();
            this.f330l = 0;
            this.f331m = false;
            this.f332n = null;
            this.f333o = null;
            this.f334p = null;
            this.f335q = C0227a.m750b();
            this.f336r = null;
            this.f337s = false;
            this.f329k.inPurgeable = true;
            this.f329k.inInputShareable = true;
        }

        public C0229a m771a(boolean z) {
            this.f326h = z;
            return this;
        }

        public C0232b m772a() {
            return new C0232b();
        }

        public C0229a m773b(boolean z) {
            this.f327i = z;
            return this;
        }
    }

    private C0232b(C0229a c0229a) {
        this.f339a = c0229a.f319a;
        this.f340b = c0229a.f320b;
        this.f341c = c0229a.f321c;
        this.f342d = c0229a.f322d;
        this.f343e = c0229a.f323e;
        this.f344f = c0229a.f324f;
        this.f345g = c0229a.f325g;
        this.f346h = c0229a.f326h;
        this.f347i = c0229a.f327i;
        this.f348j = c0229a.f328j;
        this.f349k = c0229a.f329k;
        this.f350l = c0229a.f330l;
        this.f351m = c0229a.f331m;
        this.f352n = c0229a.f332n;
        this.f353o = c0229a.f333o;
        this.f354p = c0229a.f334p;
        this.f355q = c0229a.f335q;
        this.f356r = c0229a.f336r;
        this.f357s = c0229a.f337s;
    }

    public static C0232b m774a() {
        return new C0229a().m772a();
    }
}
