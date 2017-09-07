package com.telkom.mwallet.cards;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.telkom.mwallet.R;

public class C1403g extends DialogFragment {
    private static final String f3135a = C1403g.class.getSimpleName();
    private Context f3136b;

    private void m5272a() {
    }

    private void m5273a(View view) {
    }

    public void m5274a(Context context) {
        this.f3136b = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        View inflate = layoutInflater.inflate(R.layout.fragment_card_pay_wave_menu, viewGroup, false);
        getDialog().getWindow().getAttributes();
        m5273a(inflate);
        m5272a();
        return inflate;
    }
}
