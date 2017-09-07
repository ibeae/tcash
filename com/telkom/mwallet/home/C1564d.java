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

public class C1564d extends DialogFragment {
    static int f3747d;
    static C1272r f3748e;
    RelativeLayout f3749a;
    int f3750b;
    int f3751c;

    class C15631 implements OnClickListener {
        final /* synthetic */ C1564d f3746a;

        C15631(C1564d c1564d) {
            this.f3746a = c1564d;
        }

        public void onClick(View view) {
            this.f3746a.dismiss();
        }
    }

    public static C1564d m5763a(C1272r c1272r, int i) {
        C1564d c1564d = new C1564d();
        f3748e = c1272r;
        f3747d = i;
        return c1564d;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        View inflate = layoutInflater.inflate(R.layout.fragment_help_home, viewGroup, false);
        String b = f3748e.m4651b("Telkom_language", "");
        View inflate2 = "en".equals(b) ? layoutInflater.inflate(R.layout.fragment_help_home, viewGroup, false) : "in".equals(b) ? layoutInflater.inflate(R.layout.fragment_help_home_in, viewGroup, false) : inflate;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f3750b = displayMetrics.widthPixels;
        this.f3751c = displayMetrics.heightPixels;
        this.f3749a = (RelativeLayout) inflate2.findViewById(R.id.help_container);
        this.f3749a.setOnClickListener(new C15631(this));
        return inflate2;
    }

    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawableResource(17170445);
        window.setWindowAnimations(R.style.dialog_animation_fade);
        this.f3749a.getLayoutParams().width = this.f3750b;
        this.f3749a.getLayoutParams().height = this.f3751c;
    }
}
