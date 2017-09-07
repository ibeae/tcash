package com.telkom.mwallet.tcash.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.skcc.wallet.framework.api.C1298u;
import com.telkom.mwallet.R;
import com.telkom.mwallet.TelkomApplication;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.setting.tcash.TCashFavoriteListActivity;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.cash.TCashInSMSBankingActivity;

public class C1805k extends C1761d {
    public static final String f4762a = C1805k.class.getSimpleName();
    private TelkomApplication f4763b;
    private C1298u f4764c;
    private Context f4765d;
    private LinearLayout f4766e;
    private Button f4767f;
    private Button f4768g;
    private Button f4769h;
    private Button f4770i;
    private boolean f4771j = false;
    private OnClickListener f4772k = new C18041(this);

    class C18041 implements OnClickListener {
        final /* synthetic */ C1805k f4761a;

        C18041(C1805k c1805k) {
            this.f4761a = c1805k;
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.tcash_sms_banking_bni_button:
                    intent.setClass(this.f4761a.getActivity().getApplicationContext(), TCashInSMSBankingActivity.class);
                    intent.putExtra("TCASH_MENU_ID", "5131000");
                    if (this.f4761a.f4771j) {
                        intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                    }
                    this.f4761a.startActivity(intent);
                    return;
                case R.id.tcash_sms_banking_mandiri_button:
                    intent.setClass(this.f4761a.getActivity().getApplicationContext(), TCashInSMSBankingActivity.class);
                    intent.putExtra("TCASH_MENU_ID", "5132000");
                    if (this.f4761a.f4771j) {
                        intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                    }
                    this.f4761a.startActivity(intent);
                    return;
                case R.id.tcash_sms_banking_mega_button:
                    intent.setClass(this.f4761a.getActivity().getApplicationContext(), TCashInSMSBankingActivity.class);
                    intent.putExtra("TCASH_MENU_ID", "5133000");
                    if (this.f4761a.f4771j) {
                        intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                    }
                    this.f4761a.startActivity(intent);
                    return;
                case R.id.tcash_sms_banking_slide_button:
                    if (TCashActivity.class.getSimpleName().equals(this.f4761a.getActivity().getClass().getSimpleName())) {
                        ((TCashActivity) this.f4761a.getActivity()).m6513b(this.f4761a.f4771j);
                    } else {
                        ((TCashFavoriteListActivity) this.f4761a.getActivity()).mo1505o();
                    }
                    this.f4761a.dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    public void m6922a(Context context) {
        this.f4765d = context;
    }

    public void m6923a(boolean z) {
        this.f4771j = z;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (TCashActivity.class.getSimpleName().equals(getActivity().getClass().getSimpleName())) {
            ((TCashActivity) getActivity()).m6513b(this.f4771j);
        } else {
            ((TCashFavoriteListActivity) getActivity()).mo1505o();
        }
        dismiss();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setGravity(81);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_sms_banking_menu, viewGroup, false);
        this.f4763b = (TelkomApplication) getActivity().getApplication();
        this.f4764c = this.f4763b.m4739a();
        this.f4766e = (LinearLayout) inflate.findViewById(R.id.tcash_sms_banking_button_layout);
        this.f4767f = (Button) inflate.findViewById(R.id.tcash_sms_banking_slide_button);
        this.f4768g = (Button) inflate.findViewById(R.id.tcash_sms_banking_bni_button);
        this.f4769h = (Button) inflate.findViewById(R.id.tcash_sms_banking_mega_button);
        this.f4770i = (Button) inflate.findViewById(R.id.tcash_sms_banking_mandiri_button);
        this.f4767f.setOnClickListener(this.f4772k);
        this.f4768g.setOnClickListener(this.f4772k);
        this.f4769h.setOnClickListener(this.f4772k);
        this.f4770i.setOnClickListener(this.f4772k);
        m6761a((ViewGroup) inflate);
        m6763a((TextView) inflate.findViewById(R.id.sub_menu_title_textview));
        m6762a(this.f4766e);
        return inflate;
    }
}
