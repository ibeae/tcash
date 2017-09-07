package com.telkom.mwallet.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.TCashAirtimeActivity;
import com.telkom.mwallet.tcash.TCashTransferActivity;

public class C1572g extends DialogFragment {
    private static C1359a f3774h;
    int f3775a;
    int f3776b;
    int f3777c;
    int f3778d;
    int f3779e;
    boolean f3780f;
    private ArcMenuView f3781g;

    class C15701 implements OnClickListener {
        final /* synthetic */ C1572g f3772a;

        C15701(C1572g c1572g) {
            this.f3772a = c1572g;
        }

        public void onClick(View view) {
            this.f3772a.dismiss();
            ((HomeActivity) C1572g.f3774h).m5750q();
        }
    }

    private class C1571a implements OnClickListener {
        final /* synthetic */ C1572g f3773a;

        private C1571a(C1572g c1572g) {
            this.f3773a = c1572g;
        }

        public void onClick(View view) {
            Intent intent;
            int intValue = ((Integer) view.getTag()).intValue();
            C1216a.m4522b("onClick", "on Menu  " + intValue);
            switch (intValue) {
                case 0:
                    intent = new Intent(C1572g.f3774h, TCashAirtimeActivity.class);
                    intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                    break;
                case 2:
                    intent = new Intent(C1572g.f3774h, TCashActivity.class);
                    intent.putExtra("CALL_MENU", "TCASH_PAYMENT");
                    intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                    break;
                case 3:
                    if (((HomeActivity) C1572g.f3774h).m5749p()) {
                        intent = new Intent(C1572g.f3774h, TCashTransferActivity.class);
                        intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                        break;
                    }
                    this.f3773a.dismiss();
                    ((HomeActivity) C1572g.f3774h).m5751r();
                    return;
                case 4:
                    intent = new Intent(C1572g.f3774h, TCashActivity.class);
                    intent.putExtra("CALL_MENU", "TCASH_TOKEN");
                    intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                    break;
                default:
                    return;
            }
            intent.setFlags(536870912);
            C1572g.f3774h.startActivity(intent);
            this.f3773a.dismiss();
        }
    }

    public static C1572g m5777a(C1359a c1359a) {
        C1572g c1572g = new C1572g();
        f3774h = c1359a;
        return c1572g;
    }

    public void m5778a(FragmentManager fragmentManager, int i, int i2, int i3, boolean z) {
        show(fragmentManager, "ArcMenu");
        this.f3777c = i;
        this.f3779e = i3;
        this.f3780f = z;
        this.f3778d = i2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        View inflate = layoutInflater.inflate(R.layout.fragment_menu, viewGroup, false);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f3775a = displayMetrics.widthPixels;
        this.f3776b = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        C1216a.m4522b("SCREEN", "DeviceWidth " + this.f3775a);
        C1216a.m4522b("SCREEN", "DeviceHeight " + this.f3776b);
        C1216a.m4522b("SCREEN", "density " + f);
        C1216a.m4522b("SCREEN", "dp " + (((float) this.f3775a) / f) + " x " + (((float) this.f3776b) / f));
        LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 80;
        getDialog().setCanceledOnTouchOutside(false);
        this.f3781g = (ArcMenuView) inflate.findViewById(R.id.menuContainer);
        this.f3781g.setHomeTopMargin(this.f3777c);
        this.f3781g.setHomeClickListener(new C15701(this));
        return inflate;
    }

    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawableResource(17170445);
        window.setWindowAnimations(R.style.dialog_animation_fade);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3781g.getLayoutParams();
        layoutParams.width = this.f3775a;
        layoutParams.height = this.f3776b;
        if (!this.f3780f) {
            window.addContentView(f3774h.getLayoutInflater().inflate(R.layout.fragment_help_home_menu, null), new ViewGroup.LayoutParams(this.f3775a, this.f3779e - this.f3778d));
        }
        this.f3781g.m5727a(new C1571a());
    }
}
