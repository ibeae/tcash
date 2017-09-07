package com.telkom.mwallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.home.C1559a;

public class PushProcessActivity extends Activity {
    private C1559a f2851a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2851a = C1559a.m5752a();
        getIntent();
        ((TelkomApplication) getApplication()).m4745e();
        if (this.f2851a.m5757d()) {
            C1216a.m4522b("PUSH", this.f2851a.m5758e().getClass().getSimpleName());
            Intent intent = new Intent(this, this.f2851a.m5758e().getClass());
            intent.addFlags(603979776);
            startActivity(intent);
        } else if (this.f2851a.m5758e() == null) {
            C1216a.m4522b("PUSH", "topActivity is null, start wallet");
            startActivity(new Intent(this, StartActivity.class));
        }
        finish();
    }
}
