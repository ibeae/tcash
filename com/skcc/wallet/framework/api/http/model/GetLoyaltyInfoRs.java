package com.skcc.wallet.framework.api.http.model;

import com.skcc.wallet.framework.p060b.C1300a;

public class GetLoyaltyInfoRs {
    private C1300a customerInfo = null;
    private Result result = null;

    public GetLoyaltyInfoRs(C1300a c1300a, Result result) {
        this.customerInfo = c1300a;
        this.result = result;
    }

    public C1300a getCustomerInfo() {
        return this.customerInfo;
    }

    public Result getResult() {
        return this.result;
    }

    public void setCustomerInfo(C1300a c1300a) {
        this.customerInfo = c1300a;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
