package com.skcc.wallet.framework.api.http;

import com.skcc.wallet.framework.api.C1260j;
import com.skcc.wallet.framework.api.http.model.CheckBalanceRs;
import com.skcc.wallet.framework.api.http.model.CheckStatusStickerRq;
import com.skcc.wallet.framework.api.http.model.CheckStatusStickerRs;
import com.skcc.wallet.framework.api.http.model.CreateCardRs;
import com.skcc.wallet.framework.api.http.model.GetVCardTransactionRs;
import com.skcc.wallet.framework.api.http.model.NfcActivationRq;
import com.skcc.wallet.framework.api.http.model.NfcActivationRs;
import com.skcc.wallet.framework.api.http.model.NfcDeactivationRq;
import com.skcc.wallet.framework.api.http.model.NfcDeactivationRs;
import com.skcc.wallet.framework.api.http.model.ReportEligibilityFailRq;
import com.skcc.wallet.framework.api.http.model.ReportExceptionTraceRq;
import com.skcc.wallet.framework.api.http.model.ResultRs;
import com.skcc.wallet.framework.api.http.model.StickerActivationRq;
import com.skcc.wallet.framework.api.http.model.StickerActivationRs;
import com.skcc.wallet.framework.api.http.model.StickerDeactivationRq;
import com.skcc.wallet.framework.api.http.model.StickerDeactivationRs;
import com.skcc.wallet.framework.api.http.model.TopupPrepaidCardRq;
import com.skcc.wallet.framework.api.http.model.TopupPrepaidCardRs;
import com.skcc.wallet.framework.api.http.p059a.C1235b;
import com.skcc.wallet.framework.api.http.p059a.C1236c;
import com.skcc.wallet.framework.api.http.p059a.C1237d;
import com.skcc.wallet.framework.p060b.C1301b;
import java.lang.reflect.Type;
import twitter4j.HttpResponseCode;

public class C1253n extends C1241b {
    public C1253n(C1260j c1260j) {
        super(c1260j);
    }

    public CheckStatusStickerRs m4590a(CheckStatusStickerRq checkStatusStickerRq) {
        C1243d c1243d = new C1243d(this.b.mo1467f().m4589a() + "/tcash/checkStatusSticker", "checkStatusStickerRq");
        c1243d.m4574a(this.a.m1244a((Object) checkStatusStickerRq));
        C1242c a = m4560a(c1243d);
        if (a.m4565a() != HttpResponseCode.OK) {
            return null;
        }
        this.b.mo1465a(a.m4572d());
        return (CheckStatusStickerRs) m4562a(a.m4570c(), (Type) CheckStatusStickerRs.class);
    }

    public NfcActivationRs m4591a(NfcActivationRq nfcActivationRq) {
        C1243d c1243d = new C1243d(this.b.mo1467f().m4589a() + "/tcash/nfcActivation", "nfcActivationRq");
        c1243d.m4574a(this.a.m1244a((Object) nfcActivationRq));
        C1242c a = m4560a(c1243d);
        if (a.m4565a() != HttpResponseCode.OK) {
            return null;
        }
        this.b.mo1465a(a.m4572d());
        return (NfcActivationRs) m4562a(a.m4570c(), (Type) NfcActivationRs.class);
    }

    public NfcDeactivationRs m4592a(NfcDeactivationRq nfcDeactivationRq) {
        C1243d c1243d = new C1243d(this.b.mo1467f().m4589a() + "/tcash/nfcDeactivation", "nfcDeactivationRq");
        c1243d.m4574a(this.a.m1244a((Object) nfcDeactivationRq));
        C1242c a = m4560a(c1243d);
        if (a.m4565a() != HttpResponseCode.OK) {
            return null;
        }
        this.b.mo1465a(a.m4572d());
        return (NfcDeactivationRs) m4562a(a.m4570c(), (Type) NfcDeactivationRs.class);
    }

    public ResultRs m4593a(ReportEligibilityFailRq reportEligibilityFailRq) {
        C1243d c1243d = new C1243d(this.b.mo1467f().m4589a() + "/user/reportEligibilityFail", "reportEligibilityFailRq");
        c1243d.m4574a(this.a.m1244a((Object) reportEligibilityFailRq));
        C1242c a = m4560a(c1243d);
        if (a.m4565a() != HttpResponseCode.OK) {
            return null;
        }
        this.b.mo1465a(a.m4572d());
        return (ResultRs) m4562a(a.m4570c(), (Type) ResultRs.class);
    }

    public ResultRs m4594a(ReportExceptionTraceRq reportExceptionTraceRq) {
        C1243d c1243d = new C1243d(this.b.mo1467f().m4589a() + "/user/reportExceptionTrace", "reportExceptionTraceRq");
        c1243d.m4574a(this.a.m1244a((Object) reportExceptionTraceRq));
        C1242c a = m4560a(c1243d);
        if (a.m4565a() != HttpResponseCode.OK) {
            return null;
        }
        this.b.mo1465a(a.m4572d());
        return (ResultRs) m4562a(a.m4570c(), (Type) ResultRs.class);
    }

    public StickerActivationRs m4595a(StickerActivationRq stickerActivationRq) {
        C1243d c1243d = new C1243d(this.b.mo1467f().m4589a() + "/tcash/stickerActivation", "stickerActivationRq");
        c1243d.m4574a(this.a.m1244a((Object) stickerActivationRq));
        C1242c a = m4560a(c1243d);
        if (a.m4565a() != HttpResponseCode.OK) {
            return null;
        }
        this.b.mo1465a(a.m4572d());
        return (StickerActivationRs) m4562a(a.m4570c(), (Type) StickerActivationRs.class);
    }

    public StickerDeactivationRs m4596a(StickerDeactivationRq stickerDeactivationRq) {
        C1243d c1243d = new C1243d(this.b.mo1467f().m4589a() + "/tcash/stickerDeactivation", "stickerDeactivationRq");
        c1243d.m4574a(this.a.m1244a((Object) stickerDeactivationRq));
        C1242c a = m4560a(c1243d);
        if (a.m4565a() != HttpResponseCode.OK) {
            return null;
        }
        this.b.mo1465a(a.m4572d());
        return (StickerDeactivationRs) m4562a(a.m4570c(), (Type) StickerDeactivationRs.class);
    }

    public TopupPrepaidCardRs m4597a(TopupPrepaidCardRq topupPrepaidCardRq) {
        C1243d c1243d = new C1243d(this.b.mo1467f().m4589a() + "/nfc/topUpPrepaidCard", "topUpPrepaidCardRq");
        c1243d.m4574a(this.a.m1244a((Object) topupPrepaidCardRq));
        C1242c a = m4560a(c1243d);
        if (a.m4565a() != HttpResponseCode.OK) {
            return null;
        }
        this.b.mo1465a(a.m4572d());
        return (TopupPrepaidCardRs) m4562a(a.m4570c(), (Type) TopupPrepaidCardRs.class);
    }

    public CheckBalanceRs m4598b(C1301b c1301b) {
        return new C1235b().m4550a(m4563a(c1301b));
    }

    public CreateCardRs m4599c(C1301b c1301b) {
        return new C1236c().m4551a(m4563a(c1301b));
    }

    public GetVCardTransactionRs m4600d(C1301b c1301b) {
        return new C1237d().m4552a(m4563a(c1301b));
    }
}
