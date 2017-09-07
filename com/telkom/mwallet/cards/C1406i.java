package com.telkom.mwallet.cards;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.ServiceVo;
import com.telkom.mwallet.R;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1406i extends DialogFragment {
    private static final String f3142a = C1406i.class.getSimpleName();
    private Context f3143b;
    private TextView f3144c;
    private TextView f3145d;
    private TextView f3146e;
    private Random2of6PinEditView f3147f;
    private LinearLayout f3148g;
    private Button f3149h;
    private Button f3150i;
    private ServiceVo f3151j;
    private String f3152k;
    private OnClickListener f3153l = new C14051(this);

    class C14051 implements OnClickListener {
        final /* synthetic */ C1406i f3141a;

        C14051(C1406i c1406i) {
            this.f3141a = c1406i;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.card_topup_confirm_close_button:
                    this.f3141a.dismiss();
                    return;
                case R.id.card_topup_confirm_topup_button:
                    if (this.f3141a.f3147f.m8024c()) {
                        ((CardTopupActivity) this.f3141a.getActivity()).m5183e(this.f3141a.f3152k);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void m5280a(View view) {
        this.f3148g = (LinearLayout) view.findViewById(R.id.card_topup_confirm_layout);
        this.f3144c = (TextView) view.findViewById(R.id.card_topup_confirm_amount_textview);
        this.f3145d = (TextView) view.findViewById(R.id.card_topup_confirm_card_name);
        this.f3146e = (TextView) view.findViewById(R.id.card_topup_confirm_card_type);
        this.f3147f = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        this.f3149h = (Button) view.findViewById(R.id.card_topup_confirm_close_button);
        this.f3150i = (Button) view.findViewById(R.id.card_topup_confirm_topup_button);
        this.f3149h.setOnClickListener(this.f3153l);
        this.f3150i.setOnClickListener(this.f3153l);
        LayoutParams layoutParams = (LayoutParams) this.f3148g.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        this.f3148g.setLayoutParams(layoutParams);
        if (this.f3151j != null) {
            this.f3144c.setText(this.f3152k);
            this.f3145d.setText(this.f3151j.getName());
            this.f3146e.setText(this.f3151j.getCardType());
        }
    }

    public void m5282a(Context context) {
        this.f3143b = context;
    }

    public void m5283a(ServiceVo serviceVo) {
        this.f3151j = serviceVo;
    }

    public void m5284a(String str) {
        this.f3152k = str;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setGravity(81);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        View inflate = layoutInflater.inflate(R.layout.fragment_card_topup_confirm, viewGroup, false);
        getDialog().getWindow().getAttributes();
        m5280a(inflate);
        return inflate;
    }
}
