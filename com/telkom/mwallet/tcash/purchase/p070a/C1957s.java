package com.telkom.mwallet.tcash.purchase.p070a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.purchase.TCashTicketActivity;
import com.telkom.mwallet.tcash.purchase.p070a.C1917d.C1915a;

public class C1957s extends C1917d {
    private static final String f5693l = C1957s.class.getSimpleName();
    C1915a f5694a = new C19561(this);

    class C19561 implements C1915a {
        final /* synthetic */ C1957s f5692a;

        C19561(C1957s c1957s) {
            this.f5692a = c1957s;
        }

        public void mo1561a(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    ((TCashTicketActivity) this.f5692a.getActivity()).m7571q();
                    return;
                default:
                    return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m7617b(getString(R.string.tcash_noti_purchase_ticket_msg));
        m7616a(this.f5694a);
        ((LinearLayout) this.b.getParent()).setVisibility(8);
        return onCreateView;
    }
}
