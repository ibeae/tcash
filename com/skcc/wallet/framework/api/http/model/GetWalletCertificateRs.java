package com.skcc.wallet.framework.api.http.model;

public class GetWalletCertificateRs extends ResultRs {
    private String tokenKey;

    public String getTokenKey() {
        return this.tokenKey;
    }

    public void setTokenKey(String str) {
        this.tokenKey = str;
    }
}
