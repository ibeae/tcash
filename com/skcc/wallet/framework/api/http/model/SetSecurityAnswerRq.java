package com.skcc.wallet.framework.api.http.model;

public class SetSecurityAnswerRq {
    private CommonHeader commonHeader;
    private SecurityQuestion securityQuestion;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public SecurityQuestion getSecurityQuestion() {
        return this.securityQuestion;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setSecurityQuestion(SecurityQuestion securityQuestion) {
        this.securityQuestion = securityQuestion;
    }
}
