package com.skcc.wallet.framework.api.http.model;

public class CheckUserStatusRs extends ResultRs {
    private String tcashStatus;

    public String getTcashStatus() {
        return this.tcashStatus;
    }

    public void setTcashStatus(String str) {
        this.tcashStatus = str;
    }
}
