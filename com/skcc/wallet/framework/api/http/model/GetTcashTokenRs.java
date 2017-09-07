package com.skcc.wallet.framework.api.http.model;

public class GetTcashTokenRs extends ResultRs {
    private String tcashToken;

    public String getTcashToken() {
        return this.tcashToken;
    }

    public void setTcashToken(String str) {
        this.tcashToken = str;
    }
}
