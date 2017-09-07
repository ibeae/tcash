package com.telkom.mwallet.tcash.purchase.p070a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.purchase.TCashTransportTravelActivity;
import com.telkom.mwallet.tcash.purchase.p070a.C1917d.C1915a;

public class C1964w extends C1917d {
    private static final String f5725l = C1964w.class.getSimpleName();
    C1915a f5726a = new C19631(this);

    class C19631 implements C1915a {
        final /* synthetic */ C1964w f5724a;

        C19631(C1964w c1964w) {
            this.f5724a = c1964w;
        }

        public void mo1561a(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    ((TCashTransportTravelActivity) this.f5724a.getActivity()).m7596q();
                    return;
                default:
                    return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m7617b(getString(R.string.tcash_noti_purchase_transport_travel_msg));
        m7616a(this.f5726a);
        ((LinearLayout) this.b.getParent()).setVisibility(8);
        return onCreateView;
    }
}
