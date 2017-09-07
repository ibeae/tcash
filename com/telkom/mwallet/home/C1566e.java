package com.telkom.mwallet.home;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import com.skcc.wallet.framework.api.C1272r;
import com.telkom.mwallet.R;

public class C1566e extends DialogFragment {
    static C1272r f3753d;
    RelativeLayout f3754a;
    int f3755b;
    int f3756c;

    class C15651 implements OnClickListener {
        final /* synthetic */ C1566e f3752a;

        C15651(C1566e c1566e) {
            this.f3752a = c1566e;
        }

        public void onClick(View view) {
            this.f3752a.dismiss();
        }
    }

    public static C1566e m5764a(C1272r c1272r) {
        C1566e c1566e = new C1566e();
        f3753d = c1272r;
        return c1566e;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        View inflate = layoutInflater.inflate(R.layout.fragment_help_nevi, viewGroup, false);
        String b = f3753d.m4651b("Telkom_language", "");
        View inflate2 = "en".equals(b) ? layoutInflater.inflate(R.layout.fragment_help_nevi, viewGroup, false) : "in".equals(b) ? layoutInflater.inflate(R.layout.fragment_help_nevi_in, viewGroup, false) : inflate;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f3755b = displayMetrics.widthPixels;
        this.f3756c = displayMetrics.heightPixels;
        this.f3754a = (RelativeLayout) inflate2.findViewById(R.id.help_container);
        this.f3754a.setOnClickListener(new C15651(this));
        return inflate2;
    }

    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawableResource(17170445);
        window.setWindowAnimations(R.style.dialog_animation_fade);
        this.f3754a.getLayoutParams().width = this.f3755b;
        this.f3754a.getLayoutParams().height = this.f3756c;
    }
}
