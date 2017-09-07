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

public class C1562c extends DialogFragment {
    static C1272r f3742d;
    RelativeLayout f3743a;
    int f3744b;
    int f3745c;

    class C15611 implements OnClickListener {
        final /* synthetic */ C1562c f3741a;

        C15611(C1562c c1562c) {
            this.f3741a = c1562c;
        }

        public void onClick(View view) {
            this.f3741a.dismiss();
        }
    }

    public static C1562c m5762a(C1272r c1272r) {
        C1562c c1562c = new C1562c();
        f3742d = c1272r;
        return c1562c;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        View inflate = layoutInflater.inflate(R.layout.fragment_help_coupon, viewGroup, false);
        String b = f3742d.m4651b("Telkom_language", "");
        View inflate2 = "en".equals(b) ? layoutInflater.inflate(R.layout.fragment_help_coupon, viewGroup, false) : "in".equals(b) ? layoutInflater.inflate(R.layout.fragment_help_coupon_in, viewGroup, false) : inflate;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f3744b = displayMetrics.widthPixels;
        this.f3745c = displayMetrics.heightPixels;
        this.f3743a = (RelativeLayout) inflate2.findViewById(R.id.help_container);
        this.f3743a.setOnClickListener(new C15611(this));
        return inflate2;
    }

    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawableResource(17170445);
        window.setWindowAnimations(R.style.dialog_animation_fade);
        this.f3743a.getLayoutParams().width = this.f3744b;
        this.f3743a.getLayoutParams().height = this.f3745c;
    }
}
