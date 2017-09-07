package com.skcc.wallet.framework.api.http.model;

public class RegisterUserRs extends ResultRs {
    private String pinStatus;

    public String getPinStatus() {
        return this.pinStatus;
    }

    public void setPinStatus(String str) {
        this.pinStatus = str;
    }
}
