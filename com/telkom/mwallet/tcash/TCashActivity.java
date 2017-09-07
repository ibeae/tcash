package com.telkom.mwallet.tcash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.inputmethod.InputMethodManager;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.GetTcashBalanceRs;
import com.skcc.wallet.framework.api.http.model.GetTcashPaymentTemplateRs;
import com.skcc.wallet.framework.api.http.model.GetTcashPurchaseTemplateRs;
import com.skcc.wallet.framework.api.http.model.GetTcashTokenRs;
import com.skcc.wallet.framework.api.http.model.Template;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1531h;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.dialog.p063a.C1498g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import com.telkom.mwallet.tcash.cash.p068a.C1762c;
import com.telkom.mwallet.tcash.cash.p068a.C1772h;
import com.telkom.mwallet.tcash.cash.p068a.C1776j;
import com.telkom.mwallet.tcash.fragment.C1794f;
import com.telkom.mwallet.tcash.fragment.C1797h;
import com.telkom.mwallet.tcash.fragment.C1803j;
import com.telkom.mwallet.tcash.fragment.C1805k;
import com.telkom.mwallet.tcash.payment.p069a.C1871p;
import com.telkom.mwallet.tcash.purchase.p070a.C1969x;
import java.util.ArrayList;

public class TCashActivity extends SlidingFrameActivity {
    public static final String f4371k = TCashActivity.class.getSimpleName();
    private boolean f4372A = false;
    private C1326f f4373B = new C17292(this);
    private C1326f f4374C = new C17303(this);
    private FragmentManager f4375l;
    private String f4376m = null;
    private String f4377n = null;
    private C1794f f4378o;
    private C1531h f4379z;

    class C17292 implements C1326f {
        final /* synthetic */ TCashActivity f4369a;

        C17292(TCashActivity tCashActivity) {
            this.f4369a = tCashActivity;
        }

        public void mo1485a() {
            if (this.f4369a.h != null) {
                this.f4369a.h.dismiss();
            }
            this.f4369a.finish();
        }

        public void mo1486b() {
        }
    }

    class C17303 implements C1326f {
        final /* synthetic */ TCashActivity f4370a;

        C17303(TCashActivity tCashActivity) {
            this.f4370a = tCashActivity;
        }

        public void mo1485a() {
            if (this.f4370a.h != null) {
                this.f4370a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    private void m6503j(String str) {
        m4972a((Context) this, (int) R.string.loading);
        this.p.m4724f(str, (C1245f) this);
    }

    public void mo1487a() {
        m4990k();
        this.h = m4967a(this.f4373B, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        this.h = m4969a(this.f4373B, "" + str3);
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f4371k, "onSuccessNetwork");
        this.b.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("getTcashPurchaseTemplate".equalsIgnoreCase(str)) {
            GetTcashPurchaseTemplateRs getTcashPurchaseTemplateRs = (GetTcashPurchaseTemplateRs) obj;
            if (getTcashPurchaseTemplateRs.getTemplates() == null || getTcashPurchaseTemplateRs.getTemplates().size() != 0) {
                m6508a(getTcashPurchaseTemplateRs.getTemplates());
            } else {
                m6521q();
            }
        } else if ("getTcashBalance".equalsIgnoreCase(str)) {
            GetTcashBalanceRs getTcashBalanceRs = (GetTcashBalanceRs) obj;
            this.f4378o.m6885c(this.b.m4651b("TCASH_STATUS", ""));
            this.f4378o.m6884b(String.valueOf(getTcashBalanceRs.getTcashBalance()));
        } else if ("getTcashPaymentTemplate".equalsIgnoreCase(str)) {
            GetTcashPaymentTemplateRs getTcashPaymentTemplateRs = (GetTcashPaymentTemplateRs) obj;
            if (getTcashPaymentTemplateRs.getTemplates() == null || getTcashPaymentTemplateRs.getTemplates().size() != 0) {
                m6512b(getTcashPaymentTemplateRs.getTemplates());
            } else {
                m6521q();
            }
        } else if ("getTcashToken".equalsIgnoreCase(str)) {
            GetTcashTokenRs getTcashTokenRs = (GetTcashTokenRs) obj;
            C1803j c1803j = new C1803j();
            c1803j.setStyle(0, R.style.tcash_menu_dialog);
            c1803j.m6918a(getTcashTokenRs.getTcashToken());
            c1803j.m6917a(System.currentTimeMillis());
            c1803j.m6919a(this.f4372A);
            c1803j.show(getSupportFragmentManager(), null);
            this.b.m4648a("TCASH_RETAIL_TOKEN", getTcashTokenRs.getTcashToken());
            this.b.m4647a("TCASH_RETAIL_TIME", System.currentTimeMillis());
        }
    }

    public void m6508a(ArrayList<Template> arrayList) {
        C1969x c1969x = new C1969x();
        c1969x.setStyle(0, R.style.tcash_menu_dialog);
        c1969x.m7875a(this.f4377n);
        c1969x.m7876a((ArrayList) arrayList);
        c1969x.m7877a(this.f4372A);
        c1969x.show(this.f4375l, null);
    }

    public void m6509a(final boolean z) {
        if (this.f4379z == null || this.f4379z.getDialog() == null || !this.f4379z.getDialog().isShowing()) {
            this.f4379z = C1531h.m5672a((int) R.string.msg_tcash_token_generated);
            this.f4379z.m5675a(new C1498g(this) {
                final /* synthetic */ TCashActivity f4368b;

                public void mo1544a() {
                    this.f4368b.f4379z.dismiss();
                    if (z) {
                        this.f4368b.finish();
                    }
                }

                public void mo1545a(String str) {
                    if (this.f4368b.f4379z != null) {
                        this.f4368b.f4379z.dismiss();
                    }
                    this.f4368b.m6503j(str);
                }
            });
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(this.f4379z, "pinconfirm");
            try {
                beginTransaction.commitAllowingStateLoss();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ((InputMethodManager) this.a.getSystemService("input_method")).toggleSoftInput(2, 1);
        }
    }

    public void m6510a(boolean z, boolean z2) {
        C1797h c1797h = new C1797h();
        c1797h.m6897a(getApplicationContext());
        c1797h.m6898a(z);
        c1797h.m6899b(z2);
        c1797h.setStyle(0, R.style.tcash_menu_dialog);
        c1797h.show(this.f4375l, null);
    }

    public void mo1491b() {
        m4990k();
        this.h = m4967a(this.f4373B, (int) R.string.no_response);
    }

    public void m6512b(ArrayList<Template> arrayList) {
        C1871p c1871p = new C1871p();
        c1871p.setStyle(0, R.style.tcash_menu_dialog);
        c1871p.m7332a(this.f4377n);
        c1871p.m7333a((ArrayList) arrayList);
        c1871p.m7334a(this.f4372A);
        c1871p.show(this.f4375l, null);
    }

    public void m6513b(boolean z) {
        C1762c c1762c = new C1762c();
        c1762c.m6766a(getApplicationContext());
        c1762c.m6767a(z);
        c1762c.setStyle(0, R.style.tcash_menu_dialog);
        c1762c.show(this.f4375l, null);
    }

    public void mo1492c() {
        m4990k();
        m4989j();
    }

    public void m6515c(boolean z) {
        C1805k c1805k = new C1805k();
        c1805k.m6922a(getApplicationContext());
        c1805k.m6923a(z);
        c1805k.setStyle(0, R.style.tcash_menu_dialog);
        c1805k.show(this.f4375l, null);
    }

    public void m6516e(String str) {
        this.f4377n = str;
    }

    public void m6517f(String str) {
        m4972a((Context) this, (int) R.string.loading);
        this.p.m4716d(str, (C1245f) this);
    }

    public void m6518g(String str) {
        m4972a((Context) this, (int) R.string.loading);
        this.p.m4721e(str, (C1245f) this);
    }

    public void mo1505o() {
        C1772h c1772h = new C1772h();
        c1772h.m6798a(getApplicationContext());
        c1772h.setStyle(0, R.style.tcash_menu_dialog);
        c1772h.show(this.f4375l, null);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        C1216a.m4519a("TTEST", "onActivityResult return");
        if (i == 1) {
            C1216a.m4519a("TTEST", "onActivityResult 1");
            if (i2 == -1) {
                C1216a.m4519a("TTEST", "onActivityResult");
                m6513b(this.f4372A);
            }
        }
    }

    public void onBackPressed() {
        m5016B();
    }

    public void onCreate(Bundle bundle) {
        this.f4378o = new C1794f();
        super.m5019a(this.f4378o);
        super.onCreate(bundle);
        this.f4375l = getSupportFragmentManager();
        this.f4376m = this.b.m4651b("TCASH_STATUS", "");
        String stringExtra = getIntent().getStringExtra("CALL_MENU");
        if ("TCASH_PAYMENT".equals(stringExtra)) {
            m6510a(true, false);
            this.f4372A = true;
        } else if ("TCASH_CASHIN".equals(stringExtra)) {
            m6513b(true);
            this.f4372A = true;
        } else if ("TCASH_TOKEN".equals(stringExtra)) {
            this.f4372A = true;
            m6509a(this.f4372A);
        } else if ("TCASH_INTERNET".equalsIgnoreCase(stringExtra)) {
            this.f4372A = true;
            m6510a(true, true);
        }
        m4972a((Context) this, (int) R.string.loading);
        this.p.m4729i(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f4371k, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f4371k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f4371k, " in onResume >>>>>");
    }

    public void m6520p() {
        if (C1358h.f2933d.equalsIgnoreCase(this.f4376m)) {
            C1776j c1776j = new C1776j();
            c1776j.m6802a(getApplicationContext());
            c1776j.setStyle(0, R.style.tcash_menu_dialog);
            c1776j.show(this.f4375l, null);
            return;
        }
        this.h = m4968a(this.f4374C, (int) R.string.tcash_grade_info, false);
    }

    public void m6521q() {
        this.h = m4968a(this.f4374C, (int) R.string.tcash_menu_unavailable, false);
    }
}
