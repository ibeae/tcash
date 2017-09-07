package com.telkom.mwallet.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1227c;
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1350d;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

public class C1385b extends Fragment implements C1245f {
    private C1326f f3057a = new C15601(this);
    protected C1298u f3058d;
    protected SlidingFrameActivity f3059e;
    protected C1514b f3060f;
    protected C1272r f3061g;
    protected C1350d f3062h;
    protected C1227c f3063i;

    class C15601 implements C1326f {
        final /* synthetic */ C1385b f3740a;

        C15601(C1385b c1385b) {
            this.f3740a = c1385b;
        }

        public void mo1485a() {
            if (this.f3740a.f3060f != null) {
                this.f3740a.f3060f.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    public C1514b m5199a(C1326f c1326f, int i, boolean z) {
        return this.f3059e.m4968a(c1326f, i, z);
    }

    public void mo1487a() {
        m5218o();
        m5213f(R.string.no_network);
    }

    protected void m5201a(View view) {
        if (this.f3059e == null) {
            this.f3059e = (SlidingFrameActivity) getActivity();
        }
        this.f3059e.addAD(view);
    }

    protected void m5202a(ViewGroup viewGroup) {
        m5216m().m4982d().m4933a(getActivity().getApplicationContext(), viewGroup);
    }

    public void mo1488a(String str) {
        m5217n();
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.f3061g.m4647a("time for update", System.currentTimeMillis());
        m5218o();
        m5212e("" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a("BaseFragment", "onSuccessNetwork");
        this.f3061g.m4647a("time for update", System.currentTimeMillis());
        m5218o();
    }

    public void mo1491b() {
        m5218o();
        m5213f(R.string.no_response);
    }

    public void mo1492c() {
        m5218o();
        C1359a c1359a = (C1359a) getActivity();
        if (c1359a != null) {
            c1359a.m4989j();
        } else {
            getActivity().finish();
        }
    }

    protected void m5208c(int i) {
        if (this.f3059e == null) {
            this.f3059e = (SlidingFrameActivity) getActivity();
        }
        this.f3059e.m5023d(i);
    }

    protected void m5209d(int i) {
        if (this.f3059e == null) {
            this.f3059e = (SlidingFrameActivity) getActivity();
        }
        this.f3059e.m5024e(i);
    }

    protected void m5210d(String str) {
        if (this.f3059e == null) {
            this.f3059e = (SlidingFrameActivity) getActivity();
        }
        this.f3059e.m5025h(str);
    }

    protected void m5211e(int i) {
        if (this.f3059e == null) {
            this.f3059e = (SlidingFrameActivity) getActivity();
        }
        this.f3059e.m5022c(i);
    }

    protected void m5212e(String str) {
        this.f3060f = this.f3059e.m4970a(this.f3057a, str, false);
    }

    protected void m5213f(int i) {
        this.f3060f = this.f3059e.m4968a(this.f3057a, i, false);
    }

    public void mo1550k() {
    }

    protected FragmentManager m5215l() {
        if (this.f3059e == null) {
            this.f3059e = (SlidingFrameActivity) getActivity();
        }
        return this.f3059e.getSupportFragmentManager();
    }

    protected SlidingFrameActivity m5216m() {
        this.f3059e = (SlidingFrameActivity) getActivity();
        return this.f3059e;
    }

    protected void m5217n() {
        if (this.f3059e == null) {
            this.f3059e = (SlidingFrameActivity) getActivity();
        }
        this.f3059e.m4972a(this.f3059e, (int) R.string.loading);
    }

    protected void m5218o() {
        if (this.f3059e == null) {
            this.f3059e = (SlidingFrameActivity) getActivity();
        }
        this.f3059e.m4990k();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3059e = (SlidingFrameActivity) getActivity();
        this.f3058d = this.f3059e.m5027y();
        this.f3061g = this.f3059e.m4984e();
        this.f3063i = this.f3059e.m4985f();
        this.f3062h = this.f3059e.m4982d();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void startActivity(Intent intent) {
        intent.addFlags(67108864);
        super.startActivity(intent);
    }
}
