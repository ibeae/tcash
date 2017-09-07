package com.skcc.wallet.framework.api.http.model;

public class RegisterUserMobileRs extends ResultRs {
    private String customerId;
    private String encTokenKey;

    public String getCustomerId() {
        return this.customerId;
    }

    public String getEncTokenKey() {
        return this.encTokenKey;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public void setEncTokenKey(String str) {
        this.encTokenKey = str;
    }
}
