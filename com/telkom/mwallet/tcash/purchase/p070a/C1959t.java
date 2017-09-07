package com.telkom.mwallet.tcash.purchase.p070a;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.purchase.TCashTransportTravelActivity;
import com.telkom.mwallet.view.TCashWebview;
import com.telkom.mwallet.view.TCashWebview.C1950b;

public class C1959t extends C1386e {
    private static final String f5696b = C1959t.class.getSimpleName();
    C1950b f5697a = new C19581(this);
    private TCashTransportTravelActivity f5698c;
    private TCashWebview f5699j;
    private String f5700k;
    private String f5701l;
    private String f5702m;
    private String f5703n;

    class C19581 implements C1950b {
        final /* synthetic */ C1959t f5695a;

        C19581(C1959t c1959t) {
            this.f5695a = c1959t;
        }

        public void mo1573a(String str) {
            this.f5695a.f5698c.m7593k(str);
        }
    }

    private void m7850b(View view) {
        this.f5699j = (TCashWebview) view.findViewById(R.id.tcash_purchase_webview);
        this.f5699j.setTCashWebViewListener(this.f5697a);
        m7851d();
        m7853b(this.f5701l);
        m7854c(this.f5702m);
        m7852e();
    }

    private void m7851d() {
        if ("in".equalsIgnoreCase(this.g.m4651b("Telkom_language", ""))) {
            this.f5703n = "id";
        } else {
            this.f5703n = this.g.m4651b("Telkom_language", "");
        }
    }

    private void m7852e() {
        Uri build = Uri.parse(this.f5700k).buildUpon().appendQueryParameter("session_id", this.f5701l).appendQueryParameter("credential", this.f5702m).appendQueryParameter("lang", this.f5703n).build();
        if (this.f5699j != null) {
            this.f5699j.loadUrl(build.toString());
        }
    }

    public void m7853b(String str) {
        this.f5701l = str;
    }

    public void m7854c(String str) {
        this.f5702m = str;
    }

    public void m7855f(String str) {
        this.f5700k = str.trim();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5698c = (TCashTransportTravelActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_ticket_first, null);
        m5202a((ViewGroup) inflate);
        m7850b(inflate);
        return inflate;
    }
}
