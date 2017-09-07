package com.telkom.mwallet.tcash.tap;

import com.skcc.wallet.framework.api.C1273s;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;

public abstract class C1972b implements C1273s {
    protected C1359a f5749b;
    protected C1514b f5750c;
    protected boolean f5751d;

    class C19781 implements C1326f {
        final /* synthetic */ C1972b f5765a;

        C19781(C1972b c1972b) {
            this.f5765a = c1972b;
        }

        public void mo1485a() {
            this.f5765a.f5750c.dismiss();
            if (this.f5765a.f5751d) {
                this.f5765a.f5749b.finish();
            }
        }

        public void mo1486b() {
        }
    }

    public C1972b(C1359a c1359a) {
        this(c1359a, true);
    }

    public C1972b(C1359a c1359a, boolean z) {
        this.f5749b = c1359a;
        this.f5751d = z;
    }

    private void m7883a(int i) {
        this.f5750c = this.f5749b.m4968a(new C19781(this), i, false);
    }

    public void mo1487a() {
        this.f5749b.m4990k();
        m7883a(R.string.no_network);
    }

    public void mo1491b() {
        this.f5749b.m4990k();
        m7883a(R.string.no_response);
    }

    public void mo1492c() {
        this.f5749b.m4990k();
        this.f5749b.m4989j();
    }
}
