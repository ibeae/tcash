package com.telkom.mwallet.coupon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.tcash.fragment.C1386e;

public class C1467g extends C1386e {
    private static final String f3450a = C1467g.class.getSimpleName();
    private boolean f3451b = false;
    private C1326f f3452c = new C14661(this);

    class C14661 implements C1326f {
        final /* synthetic */ C1467g f3449a;

        C14661(C1467g c1467g) {
            this.f3449a = c1467g;
        }

        public void mo1485a() {
            if (this.f3449a.f != null) {
                this.f3449a.f.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    public void m5552a(boolean z) {
        this.f3451b = z;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_coupon_redeem_qr, null);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.app_fragment_placeholder);
        Fragment c1473h = new C1473h();
        c1473h.m5580a(this.f3451b);
        FragmentTransaction beginTransaction = m5215l().beginTransaction();
        beginTransaction.add(R.id.app_fragment_placeholder, c1473h, f3450a);
        beginTransaction.commit();
        this.h.m4932a(getActivity(), (TextView) inflate.findViewById(R.id.coupon_qr_text), 2);
        return inflate;
    }
}
