package com.skcc.wallet.framework.api.http.model;

public class VerifyUserRq {
    private CommonHeader commonHeader;
    private String dateOfBirth;
    private String email;
    private String firstName;
    private String lastName;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setDateOfBirth(String str) {
        this.dateOfBirth = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }
}
