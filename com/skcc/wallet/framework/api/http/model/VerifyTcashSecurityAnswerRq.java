package com.skcc.wallet.framework.api.http.model;

public class VerifyTcashSecurityAnswerRq {
    private String answer;
    private String birthDay;
    private CommonHeader commonHeader;
    private String email;
    private String firstName;
    private String identityNumber;
    private String lastName;

    public String getAnswer() {
        return this.answer;
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getEmail() {
        return this.email;
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

    public void setAnswer(String str) {
        this.answer = str;
    }

    public void setBirthDay(String str) {
        this.birthDay = str;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setEmail(String str) {
        this.email = str;
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
}
