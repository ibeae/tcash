package com.skcc.wallet.framework.api.http.model;

public class ResetTcashPinRq {
    private String birthDay;
    private CommonHeader commonHeader;
    private String firstName;
    private String identityNumber;
    private String lastName;
    private String otp;

    public String getBirthDay() {
        return this.birthDay;
    }

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getIdentityNumber() {
        return this.identityNumber;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getOtp() {
        return this.otp;
    }

    public void setBirthDay(String str) {
        this.birthDay = str;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setIdentityNumber(String str) {
        this.identityNumber = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setOtp(String str) {
        this.otp = str;
    }
}
