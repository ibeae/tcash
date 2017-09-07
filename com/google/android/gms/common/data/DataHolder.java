package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ek;
import java.util.ArrayList;
import java.util.HashMap;

public final class DataHolder implements SafeParcelable {
    public static final C0671a CREATOR = new C0671a();
    private static final C0669a f857l = new C0669a(new String[0], null) {
    };
    Bundle f858a;
    int[] f859b;
    int f860c;
    boolean f861d = false;
    private final int f862e;
    private final String[] f863f;
    private final CursorWindow[] f864g;
    private final int f865h;
    private final Bundle f866i;
    private Object f867j;
    private boolean f868k = true;

    public static class C0669a {
        private final String[] f851a;
        private final ArrayList<HashMap<String, Object>> f852b;
        private final String f853c;
        private final HashMap<Object, Integer> f854d;
        private boolean f855e;
        private String f856f;

        private C0669a(String[] strArr, String str) {
            this.f851a = (String[]) ek.m2332a((Object) strArr);
            this.f852b = new ArrayList();
            this.f853c = str;
            this.f854d = new HashMap();
            this.f855e = false;
            this.f856f = null;
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.f862e = i;
        this.f863f = strArr;
        this.f864g = cursorWindowArr;
        this.f865h = i2;
        this.f866i = bundle;
    }

    public void m1454a() {
        int i;
        int i2 = 0;
        this.f858a = new Bundle();
        for (i = 0; i < this.f863f.length; i++) {
            this.f858a.putInt(this.f863f[i], i);
        }
        this.f859b = new int[this.f864g.length];
        i = 0;
        while (i2 < this.f864g.length) {
            this.f859b[i2] = i;
            i += this.f864g[i2].getNumRows() - (i - this.f864g[i2].getStartPosition());
            i2++;
        }
        this.f860c = i;
    }

    int m1455b() {
        return this.f862e;
    }

    String[] m1456c() {
        return this.f863f;
    }

    CursorWindow[] m1457d() {
        return this.f864g;
    }

    public int describeContents() {
        return 0;
    }

    public int m1458e() {
        return this.f865h;
    }

    public Bundle m1459f() {
        return this.f866i;
    }

    protected void finalize() {
        try {
            if (this.f868k && this.f864g.length > 0 && !m1460g()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call close() on all DataBuffer extending objects when you are done with them. (" + (this.f867j == null ? "internal object: " + toString() : this.f867j.toString()) + ")");
                m1461h();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public boolean m1460g() {
        boolean z;
        synchronized (this) {
            z = this.f861d;
        }
        return z;
    }

    public void m1461h() {
        synchronized (this) {
            if (!this.f861d) {
                this.f861d = true;
                for (CursorWindow close : this.f864g) {
                    close.close();
                }
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0671a.m1462a(this, parcel, i);
    }
}
