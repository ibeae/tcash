package com.skcc.wallet.framework.api.http.model;

public class ChangeTcashPinRs extends ResultRs {
    private String encryptedToken;

    public String getEncryptedToken() {
        return this.encryptedToken;
    }

    public void setEncryptedToken(String str) {
        this.encryptedToken = str;
    }
}
