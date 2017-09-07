package com.skcc.wallet.framework.api.http.model;

public class VerifySecurityAnswerRs extends ResultRs {
    private String customerId;
    private String encryptedToken;
    private String tcashPin;

    public String getCustomerId() {
        return this.customerId;
    }

    public String getEncryptedToken() {
        return this.encryptedToken;
    }

    public String getTcashPin() {
        return this.tcashPin;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public void setEncryptedToken(String str) {
        this.encryptedToken = str;
    }

    public void setTcashPin(String str) {
        this.tcashPin = str;
    }
}
