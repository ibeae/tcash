package com.telkom.mwallet.tcash.purchase.p070a;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.purchase.TCashTicketActivity;
import com.telkom.mwallet.view.TCashWebview;
import com.telkom.mwallet.view.TCashWebview.C1950b;

public class C1952p extends C1386e {
    private static final String f5665b = C1952p.class.getSimpleName();
    C1950b f5666a = new C19511(this);
    private TCashTicketActivity f5667c;
    private TCashWebview f5668j;
    private String f5669k;
    private String f5670l;
    private String f5671m;
    private String f5672n;

    class C19511 implements C1950b {
        final /* synthetic */ C1952p f5664a;

        C19511(C1952p c1952p) {
            this.f5664a = c1952p;
        }

        public void mo1573a(String str) {
            this.f5664a.f5667c.m7568k(str);
        }
    }

    private void m7827b(View view) {
        this.f5668j = (TCashWebview) view.findViewById(R.id.tcash_purchase_webview);
        this.f5668j.setTCashWebViewListener(this.f5666a);
        m7828d();
        m7831c(this.f5670l);
        m7832f(this.f5671m);
        m7829e();
    }

    private void m7828d() {
        if ("in".equalsIgnoreCase(this.g.m4651b("Telkom_language", ""))) {
            this.f5672n = "id";
        } else {
            this.f5672n = this.g.m4651b("Telkom_language", "");
        }
    }

    private void m7829e() {
        Uri build = Uri.parse(this.f5669k).buildUpon().appendQueryParameter("session_id", this.f5670l).appendQueryParameter("credential", this.f5671m).appendQueryParameter("lang", this.f5672n).build();
        if (this.f5668j != null) {
            this.f5668j.loadUrl(build.toString());
        }
    }

    public void m7830b(String str) {
        this.f5669k = str.trim();
    }

    public void m7831c(String str) {
        this.f5670l = str;
    }

    public void m7832f(String str) {
        this.f5671m = str;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5667c = (TCashTicketActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_ticket_first, null);
        m5202a((ViewGroup) inflate);
        m7827b(inflate);
        return inflate;
    }
}
