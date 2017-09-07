package com.skcc.wallet.framework.api.http.model;

public class GetMsisdnRs extends ResultRs {
    private String msisdn;

    public String getMsisdn() {
        return this.msisdn;
    }

    public void setMsisdn(String str) {
        this.msisdn = str;
    }
}
