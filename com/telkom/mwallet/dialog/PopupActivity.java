package com.telkom.mwallet.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.StartActivity;
import com.telkom.mwallet.TelkomApplication;
import com.telkom.mwallet.home.C1559a;
import com.telkom.mwallet.p064a.C1350d;

public class PopupActivity extends Activity {
    private TelkomApplication f3530a;
    private C1350d f3531b;
    private int f3532c;
    private String f3533d;
    private int f3534e = -1;
    private int f3535f = -1;

    class C14911 implements OnClickListener {
        final /* synthetic */ PopupActivity f3528a;

        C14911(PopupActivity popupActivity) {
            this.f3528a = popupActivity;
        }

        public void onClick(View view) {
            this.f3528a.m5614a();
        }
    }

    class C14922 implements OnClickListener {
        final /* synthetic */ PopupActivity f3529a;

        C14922(PopupActivity popupActivity) {
            this.f3529a = popupActivity;
        }

        public void onClick(View view) {
            this.f3529a.finish();
        }
    }

    private void m5614a() {
        this.f3530a.m4745e();
        C1559a a = C1559a.m5752a();
        if (a.m5757d()) {
            C1216a.m4522b("PUSH", a.m5758e().getClass().getSimpleName());
            Intent intent = new Intent(this, a.m5758e().getClass());
            intent.addFlags(603979776);
            startActivity(intent);
        } else if (a.m5758e() == null) {
            C1216a.m4522b("PUSH", "topActivity is null, start wallet");
            startActivity(new Intent(this, StartActivity.class));
        }
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.dialog_notice2);
        this.f3530a = (TelkomApplication) getApplication();
        this.f3531b = this.f3530a.m4899j();
        this.f3532c = R.string.push_msg_reminder;
        this.f3534e = R.string.btn_ok;
        this.f3535f = R.string.btn_later;
        View view = (TextView) findViewById(R.id.dialog_title);
        view.setText(R.string.title_notice);
        this.f3531b.m4932a((Context) this, view, 3);
        view = (TextView) findViewById(R.id.notice_dialog_message);
        if (this.f3532c != 0) {
            view.setText(this.f3532c);
        } else {
            view.setText(this.f3533d);
        }
        this.f3531b.m4932a((Context) this, view, 2);
        view = (Button) findViewById(R.id.notice_dialog_button_ok);
        view.setOnClickListener(new C14911(this));
        if (this.f3534e > 0) {
            view.setText(this.f3534e);
        }
        View view2 = (Button) findViewById(R.id.notice_dialog_button_cancel);
        view2.setOnClickListener(new C14922(this));
        if (this.f3535f > 0) {
            view2.setText(this.f3535f);
        }
        this.f3531b.m4932a((Context) this, view, 3);
        this.f3531b.m4932a((Context) this, view2, 3);
    }
}
