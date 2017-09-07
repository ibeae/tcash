package com.skcc.wallet.framework.api.http;

import com.skcc.wallet.framework.api.C1260j;
import com.skcc.wallet.framework.api.http.model.GetAvailLoyaltyCardListRq;
import com.skcc.wallet.framework.api.http.model.GetAvailLoyaltyCardListRs;
import com.skcc.wallet.framework.api.http.model.RemoveLoyaltyCardRq;
import com.skcc.wallet.framework.api.http.model.RemoveLoyaltyCardRs;
import com.skcc.wallet.framework.api.http.model.RequestAddNewLoyaltyCardRq;
import com.skcc.wallet.framework.api.http.model.RequestAddNewLoyaltyCardRs;
import java.lang.reflect.Type;
import twitter4j.HttpResponseCode;

public class C1244e extends C1241b {
    public C1244e(C1260j c1260j) {
        super(c1260j);
    }

    public GetAvailLoyaltyCardListRs m4576a(GetAvailLoyaltyCardListRq getAvailLoyaltyCardListRq) {
        C1243d c1243d = new C1243d(this.b.mo1467f().m4589a() + "/marketing/getAvailLoyaltyCardList", "getAvailLoyaltyCardListRq");
        c1243d.m4574a(this.a.m1244a((Object) getAvailLoyaltyCardListRq));
        C1242c a = m4560a(c1243d);
        if (a.m4565a() != HttpResponseCode.OK) {
            return null;
        }
        this.b.mo1465a(a.m4572d());
        return (GetAvailLoyaltyCardListRs) m4562a(a.m4570c(), (Type) GetAvailLoyaltyCardListRs.class);
    }

    public RemoveLoyaltyCardRs m4577a(RemoveLoyaltyCardRq removeLoyaltyCardRq) {
        C1243d c1243d = new C1243d(this.b.mo1467f().m4589a() + "/marketing/removeLoyaltyCard", "removeLoyaltyCardRq");
        c1243d.m4574a(this.a.m1244a((Object) removeLoyaltyCardRq));
        C1242c a = m4560a(c1243d);
        if (a.m4565a() != HttpResponseCode.OK) {
            return null;
        }
        this.b.mo1465a(a.m4572d());
        return (RemoveLoyaltyCardRs) m4562a(a.m4570c(), (Type) RemoveLoyaltyCardRs.class);
    }

    public RequestAddNewLoyaltyCardRs m4578a(RequestAddNewLoyaltyCardRq requestAddNewLoyaltyCardRq) {
        C1243d c1243d = new C1243d(this.b.mo1467f().m4589a() + "/marketing/requestAddNewLoyaltyCard", "requestAddNewLoyaltyCardRq");
        c1243d.m4574a(this.a.m1244a((Object) requestAddNewLoyaltyCardRq));
        C1242c a = m4560a(c1243d);
        if (a.m4565a() != HttpResponseCode.OK) {
            return null;
        }
        this.b.mo1465a(a.m4572d());
        return (RequestAddNewLoyaltyCardRs) m4562a(a.m4570c(), (Type) RequestAddNewLoyaltyCardRs.class);
    }
}
