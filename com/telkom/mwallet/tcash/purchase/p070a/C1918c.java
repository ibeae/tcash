package com.telkom.mwallet.tcash.purchase.p070a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.purchase.TCashMerchantActivty;
import com.telkom.mwallet.tcash.purchase.p070a.C1917d.C1915a;

public class C1918c extends C1917d {
    private static final String f5496l = C1918c.class.getSimpleName();
    C1915a f5497a = new C19161(this);

    class C19161 implements C1915a {
        final /* synthetic */ C1918c f5467a;

        C19161(C1918c c1918c) {
            this.f5467a = c1918c;
        }

        public void mo1561a(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    TCashMerchantActivty tCashMerchantActivty = (TCashMerchantActivty) this.f5467a.getActivity();
                    if (this.f5467a.b.isSelected()) {
                        String obj = this.f5467a.c.getText().toString();
                        if (obj.isEmpty()) {
                            obj = this.f5467a.getString(R.string.hint_favorite_title);
                        }
                        tCashMerchantActivty.m7503j(obj);
                    } else {
                        tCashMerchantActivty.m7507r();
                    }
                    tCashMerchantActivty.m7506q();
                    return;
                default:
                    return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m7617b(getString(R.string.tcash_noti_purchase_merchant_msg));
        m7616a(this.f5497a);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
