package com.telkom.mwallet.setting;

import android.content.Intent;
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
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;

public class C1633c extends DialogFragment {
    private static final String f4054a = C1633c.class.getSimpleName();
    private LinearLayout f4055b;
    private Button f4056c;
    private Button f4057d;
    private Button f4058e;
    private Button f4059f;
    private Button f4060g;
    private Button f4061h;
    private C1359a f4062i;
    private OnClickListener f4063j = new C16321(this);

    class C16321 implements OnClickListener {
        final /* synthetic */ C1633c f4053a;

        C16321(C1633c c1633c) {
            this.f4053a = c1633c;
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.setting_general_menu_about_twallet_button:
                    this.f4053a.f4062i.startActivity(new Intent(this.f4053a.getActivity(), AboutTWalletActivity.class));
                    return;
                case R.id.setting_general_menu_language_button:
                    this.f4053a.dismiss();
                    ((SettingMainActivity) this.f4053a.getActivity()).mo1505o();
                    return;
                case R.id.setting_general_menu_notification_button:
                    this.f4053a.f4062i.startActivity(new Intent(this.f4053a.getActivity(), TWalletNewsActivity.class));
                    return;
                case R.id.setting_general_menu_profile_button:
                    this.f4053a.f4062i.startActivity(new Intent(this.f4053a.getActivity(), ProfileActivity.class));
                    return;
                case R.id.setting_general_menu_slide_button:
                    this.f4053a.dismiss();
                    return;
                case R.id.logout_button:
                    ((SettingMainActivity) this.f4053a.getActivity()).m6170p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m6194a(View view) {
        this.f4055b = (LinearLayout) view.findViewById(R.id.setting_general_menu_button_layout);
        this.f4056c = (Button) view.findViewById(R.id.setting_general_menu_slide_button);
        this.f4057d = (Button) view.findViewById(R.id.setting_general_menu_notification_button);
        this.f4058e = (Button) view.findViewById(R.id.setting_general_menu_language_button);
        this.f4059f = (Button) view.findViewById(R.id.setting_general_menu_profile_button);
        this.f4060g = (Button) view.findViewById(R.id.setting_general_menu_about_twallet_button);
        this.f4061h = (Button) view.findViewById(R.id.logout_button);
        this.f4056c.setOnClickListener(this.f4063j);
        this.f4057d.setOnClickListener(this.f4063j);
        this.f4058e.setOnClickListener(this.f4063j);
        this.f4059f.setOnClickListener(this.f4063j);
        this.f4060g.setOnClickListener(this.f4063j);
        this.f4061h.setOnClickListener(this.f4063j);
        LayoutParams layoutParams = (LayoutParams) this.f4055b.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        this.f4055b.setLayoutParams(layoutParams);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setGravity(81);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        View inflate = layoutInflater.inflate(R.layout.fragment_setting_general_menu, viewGroup);
        m6194a(inflate);
        this.f4062i = (C1359a) getActivity();
        this.f4062i.m4982d().m4934a(this.f4062i.getApplicationContext(), (ViewGroup) inflate, 2);
        this.f4062i.m4982d().m4932a(this.f4062i.getApplicationContext(), (TextView) inflate.findViewById(R.id.sub_menu_title_textview), 3);
        return inflate;
    }
}
