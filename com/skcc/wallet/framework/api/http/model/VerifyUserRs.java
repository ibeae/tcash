package com.skcc.wallet.framework.api.http.model;

public class VerifyUserRs extends ResultRs {
    private String firstName;
    private String lastName;
    private String temporaryCustomerId;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getTemporaryCustomerId() {
        return this.temporaryCustomerId;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setTemporaryCustomerId(String str) {
        this.temporaryCustomerId = str;
    }
}
