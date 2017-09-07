package com.telkom.mwallet.cards;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.http.model.LoyaltyCardDetail;
import com.skcc.wallet.framework.p062d.C1312a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.fragment.C1386e;
import java.io.IOException;

public class C1404h extends C1386e {
    private ImageView f3137a;
    private TextView f3138b;
    private LoyaltyCardDetail f3139c;
    private C1312a f3140j;

    private void m5275b(View view) {
        this.f3140j = new C1312a(getParentFragment().getActivity().getApplication());
        this.f3137a = (ImageView) view.findViewById(R.id.card_img);
        this.f3138b = (TextView) view.findViewById(R.id.card_number_textview);
        m5276d();
    }

    private void m5276d() {
        if (this.f3139c != null) {
            m5277e();
            this.f3138b.setText(C1354g.m4956g(this.f3139c.getLoyaltyCardNumber()));
        }
    }

    private void m5277e() {
        String loyaltyCardImageUrl = this.f3139c.getLoyaltyCardImageUrl();
        if (loyaltyCardImageUrl != null && loyaltyCardImageUrl.startsWith("http")) {
            this.f3140j.m4786a(loyaltyCardImageUrl, this.f3137a);
        } else if (loyaltyCardImageUrl != null) {
            try {
                C1216a.m4522b("imagesub", "image:  ");
                this.f3137a.setImageDrawable(Drawable.createFromStream(getParentFragment().getActivity().getAssets().open(loyaltyCardImageUrl), null));
            } catch (IOException e) {
            }
        }
    }

    public void m5278a(LoyaltyCardDetail loyaltyCardDetail) {
        this.f3139c = loyaltyCardDetail;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_card_selected, null);
        m5275b(inflate);
        return inflate;
    }

    public void onDestroy() {
        this.f3140j.m4785a();
        super.onDestroy();
    }
}
