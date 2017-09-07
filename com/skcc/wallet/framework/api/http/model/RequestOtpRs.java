package com.skcc.wallet.framework.api.http.model;

public class RequestOtpRs extends ResultRs {
    private boolean isRegisteredMsisdn;

    public boolean isRegisteredMsisdn() {
        return this.isRegisteredMsisdn;
    }

    public void setRegisteredMsisdn(boolean z) {
        this.isRegisteredMsisdn = z;
    }
}
