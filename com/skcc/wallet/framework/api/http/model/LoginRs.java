package com.skcc.wallet.framework.api.http.model;

public class LoginRs extends ResultRs {
    private String firstName;
    private String lastName;
    private String pinStatus;
    private String tcashStatus;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPinStatus() {
        return this.pinStatus;
    }

    public String getTcashStatus() {
        return this.tcashStatus;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setPinStatus(String str) {
        this.pinStatus = str;
    }

    public void setTcashStatus(String str) {
        this.tcashStatus = str;
    }
}
