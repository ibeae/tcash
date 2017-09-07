package com.skcc.wallet.framework.api.http.model;

public class VerifyTcashPinForRegisterRs extends ResultRs {
    private String customerId;
    private String encTokenKey;
    private boolean inviteSuccess;

    public String getCustomerId() {
        return this.customerId;
    }

    public String getEncTokenKey() {
        return this.encTokenKey;
    }

    public boolean isInviteSuccess() {
        return this.inviteSuccess;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public void setEncTokenKey(String str) {
        this.encTokenKey = str;
    }

    public void setInviteSuccess(boolean z) {
        this.inviteSuccess = z;
    }
}
