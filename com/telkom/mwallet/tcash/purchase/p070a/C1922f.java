package com.telkom.mwallet.tcash.purchase.p070a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.purchase.TCashPurchaseActivity;
import com.telkom.mwallet.tcash.purchase.p070a.C1917d.C1915a;

public class C1922f extends C1917d {
    private static final String f5504l = C1922f.class.getSimpleName();
    C1915a f5505a = new C19211(this);
    private int f5506m = 0;
    private int f5507n = 8;

    class C19211 implements C1915a {
        final /* synthetic */ C1922f f5503a;

        C19211(C1922f c1922f) {
            this.f5503a = c1922f;
        }

        public void mo1561a(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    TCashPurchaseActivity tCashPurchaseActivity = (TCashPurchaseActivity) this.f5503a.getActivity();
                    if (this.f5503a.f5507n == 0) {
                        if (this.f5503a.k.m8024c()) {
                            tCashPurchaseActivity.m7541j(this.f5503a.k.getPin());
                        } else {
                            return;
                        }
                    }
                    if (this.f5503a.b.isSelected()) {
                        String obj = this.f5503a.c.getText().toString();
                        if (obj.isEmpty()) {
                            obj = this.f5503a.getString(R.string.hint_favorite_title);
                        }
                        tCashPurchaseActivity.m7542k(obj);
                    } else {
                        tCashPurchaseActivity.m7546r();
                    }
                    tCashPurchaseActivity.m7545q();
                    return;
                default:
                    return;
            }
        }
    }

    public void m7631a(int i) {
        this.f5506m = i;
        if (this.b != null) {
            ((LinearLayout) this.b.getParent()).setVisibility(i);
        }
    }

    public void m7632b(int i) {
        this.f5507n = i;
        if (this.j != null) {
            ((LinearLayout) this.j.getParent()).setVisibility(i);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m7631a(this.f5506m);
        m7632b(this.f5507n);
        m7616a(this.f5505a);
        return onCreateView;
    }
}
