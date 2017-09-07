package com.telkom.mwallet.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.telkom.mwallet.R;
import com.telkom.mwallet.home.C1385b;
import com.telkom.mwallet.view.waletWebView;

public class C1631b extends C1385b {
    private waletWebView f4052a;

    private void m6192d() {
        if (this.f4052a != null) {
            this.f4052a.loadUrl("http://digitalpayment.telkomsel.com/apps_tcash");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_promotion, null);
        m5208c(R.string.navi_menu_promotion);
        this.f4052a = (waletWebView) inflate.findViewById(R.id.promotion_webview);
        this.f4052a.setHorizontalScrollBarEnabled(false);
        this.f4052a.setVerticalScrollBarEnabled(false);
        m6192d();
        return inflate;
    }
}
