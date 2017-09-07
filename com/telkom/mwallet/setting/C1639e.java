package com.telkom.mwallet.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.TelkomApplication;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.setting.tcash.ChangeTCashPINActivity;
import com.telkom.mwallet.setting.tcash.TCashFavoriteListActivity;
import com.telkom.mwallet.setting.tcash.TCashForgetPINActivity;

public class C1639e extends DialogFragment {
    private static final String f4077a = C1639e.class.getSimpleName();
    private LinearLayout f4078b;
    private Button f4079c;
    private Button f4080d;
    private Button f4081e;
    private Button f4082f;
    private C1359a f4083g;
    private C1514b f4084h;
    private OnClickListener f4085i = new C16371(this);
    private C1326f f4086j = new C16382(this);

    class C16371 implements OnClickListener {
        final /* synthetic */ C1639e f4075a;

        C16371(C1639e c1639e) {
            this.f4075a = c1639e;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.setting_tcash_menu_change_tcash_pin_button:
                    this.f4075a.f4083g.startActivity(new Intent(this.f4075a.getActivity(), ChangeTCashPINActivity.class));
                    return;
                case R.id.setting_tcash_menu_forgot_tcash_pin_button:
                    String b = ((TelkomApplication) this.f4075a.getActivity().getApplication()).m4745e().m4651b("TCASH_STATUS", "");
                    if ("BASIC_SERVICE".equalsIgnoreCase(b)) {
                        this.f4075a.f4084h = this.f4075a.m6211a(this.f4075a.f4086j, (int) R.string.cannot_reset_tcash_pin);
                        return;
                    } else if ("FULL_SERVICE".equalsIgnoreCase(b)) {
                        this.f4075a.f4083g.startActivity(new Intent(this.f4075a.getActivity(), TCashForgetPINActivity.class));
                        return;
                    } else {
                        return;
                    }
                case R.id.setting_tcash_menu_myfavorite_button:
                    this.f4075a.f4083g.startActivity(new Intent(this.f4075a.getActivity(), TCashFavoriteListActivity.class));
                    return;
                case R.id.setting_tcash_menu_slide_button:
                    this.f4075a.dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    class C16382 implements C1326f {
        final /* synthetic */ C1639e f4076a;

        C16382(C1639e c1639e) {
            this.f4076a = c1639e;
        }

        public void mo1485a() {
            if (this.f4076a.f4084h != null) {
                this.f4076a.f4084h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    public C1514b m6211a(C1326f c1326f, int i) {
        Fragment a = C1514b.m5647a(i);
        a.m5651a(c1326f);
        FragmentTransaction beginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        beginTransaction.add(a, "notice");
        try {
            beginTransaction.commitAllowingStateLoss();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void m6212a(View view) {
        this.f4078b = (LinearLayout) view.findViewById(R.id.setting_tcash_menu_button_layout);
        this.f4079c = (Button) view.findViewById(R.id.setting_tcash_menu_slide_button);
        this.f4080d = (Button) view.findViewById(R.id.setting_tcash_menu_change_tcash_pin_button);
        this.f4081e = (Button) view.findViewById(R.id.setting_tcash_menu_myfavorite_button);
        this.f4082f = (Button) view.findViewById(R.id.setting_tcash_menu_forgot_tcash_pin_button);
        this.f4079c.setOnClickListener(this.f4085i);
        this.f4080d.setOnClickListener(this.f4085i);
        this.f4081e.setOnClickListener(this.f4085i);
        this.f4082f.setOnClickListener(this.f4085i);
        LayoutParams layoutParams = (LayoutParams) this.f4078b.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        this.f4078b.setLayoutParams(layoutParams);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setGravity(81);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        View inflate = layoutInflater.inflate(R.layout.fragment_setting_tcash_menu, viewGroup);
        m6212a(inflate);
        this.f4083g = (C1359a) getActivity();
        this.f4083g.m4982d().m4934a(this.f4083g.getApplicationContext(), (ViewGroup) inflate, 2);
        this.f4083g.m4982d().m4932a(this.f4083g.getApplicationContext(), (TextView) inflate.findViewById(R.id.sub_menu_title_textview), 3);
        return inflate;
    }
}
