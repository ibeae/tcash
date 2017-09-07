package com.telkom.mwallet.setting;

import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.home.C1385b;

public class C1630a extends C1385b {
    private static final String f4040a = C1630a.class.getSimpleName();
    private Button f4041b;
    private Button f4042c;
    private Button f4043j;
    private Button f4044k;
    private LinearLayout f4045l;
    private LinearLayout f4046m;
    private LinearLayout f4047n;
    private LinearLayout f4048o;
    private TextView f4049p;
    private AboutTWalletActivity f4050q;
    private OnClickListener f4051r = new C16291(this);

    class C16291 implements OnClickListener {
        final /* synthetic */ C1630a f4039a;

        C16291(C1630a c1630a) {
            this.f4039a = c1630a;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.about_twallet_email_button:
                case R.id.about_twallet_email_layout:
                    this.f4039a.m6189e();
                    return;
                case R.id.about_twallet_facebook_button:
                case R.id.about_twallet_facebook_layout:
                    this.f4039a.f4050q.m6078q();
                    return;
                case R.id.about_twallet_sms_button:
                case R.id.about_twallet_sms_layout:
                    this.f4039a.m6188d();
                    return;
                case R.id.about_twallet_twitter_button:
                case R.id.about_twallet_twitter_layout:
                    this.f4039a.f4050q.m6077p();
                    return;
                default:
                    return;
            }
        }
    }

    private int m6187h() {
        return (getResources().getDisplayMetrics().heightPixels - m6190f()) - m6191g();
    }

    protected void m6188d() {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("sms:"));
        intent.putExtra("sms_body", getString(R.string.body_message));
        startActivity(intent);
    }

    protected void m6189e() {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:"));
        intent.putExtra("android.intent.extra.EMAIL", getString(R.string.customer_care_mail));
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.share_message));
        intent.putExtra("android.intent.extra.TEXT", getString(R.string.body_message));
        startActivity(intent);
    }

    public int m6190f() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
    }

    public int m6191g() {
        TypedValue typedValue = new TypedValue();
        return getActivity().getTheme().resolveAttribute(16843499, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics()) : 50;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_about_twallet, null);
        ((RelativeLayout) inflate.findViewById(R.id.pageArea)).getLayoutParams().height = m6187h();
        m5208c(R.string.title_about_twallet);
        this.f4050q = (AboutTWalletActivity) getActivity();
        this.f4041b = (Button) inflate.findViewById(R.id.about_twallet_sms_button);
        this.f4042c = (Button) inflate.findViewById(R.id.about_twallet_email_button);
        this.f4043j = (Button) inflate.findViewById(R.id.about_twallet_facebook_button);
        this.f4044k = (Button) inflate.findViewById(R.id.about_twallet_twitter_button);
        this.f4045l = (LinearLayout) inflate.findViewById(R.id.about_twallet_sms_layout);
        this.f4046m = (LinearLayout) inflate.findViewById(R.id.about_twallet_email_layout);
        this.f4047n = (LinearLayout) inflate.findViewById(R.id.about_twallet_facebook_layout);
        this.f4048o = (LinearLayout) inflate.findViewById(R.id.about_twallet_twitter_layout);
        this.f4041b.setOnClickListener(this.f4051r);
        this.f4042c.setOnClickListener(this.f4051r);
        this.f4043j.setOnClickListener(this.f4051r);
        this.f4044k.setOnClickListener(this.f4051r);
        this.f4045l.setOnClickListener(this.f4051r);
        this.f4046m.setOnClickListener(this.f4051r);
        this.f4047n.setOnClickListener(this.f4051r);
        this.f4048o.setOnClickListener(this.f4051r);
        this.f4049p = (TextView) inflate.findViewById(R.id.about_twallet_version_textview);
        String str = "";
        try {
            str = this.f4050q.getPackageManager().getPackageInfo(this.f4050q.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        this.f4049p.setText(getString(R.string.about_version) + " " + str);
        View view = (TextView) inflate.findViewById(R.id.about_twallet_share_textview1);
        View view2 = (TextView) inflate.findViewById(R.id.about_twallet_share_textview2);
        View view3 = (TextView) inflate.findViewById(R.id.about_twallet_share_textview3);
        View view4 = (TextView) inflate.findViewById(R.id.about_support_call);
        this.h.m4934a(this.f4050q.getApplicationContext(), (ViewGroup) inflate, 1);
        this.h.m4932a(this.f4050q.getApplicationContext(), view, 1);
        this.h.m4932a(this.f4050q.getApplicationContext(), view2, 3);
        this.h.m4932a(this.f4050q.getApplicationContext(), view3, 1);
        this.h.m4932a(this.f4050q.getApplicationContext(), view4, 3);
        return inflate;
    }
}
